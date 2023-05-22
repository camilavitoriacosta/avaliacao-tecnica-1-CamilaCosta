package com.example.desafiotecnico.dominio.entidades;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Pessoa responsavel;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "conjugue_id")
    private Pessoa conjugue;

    @OneToMany(mappedBy = "familia", cascade = CascadeType.PERSIST)
    private Collection<Pessoa> dependentes = new ArrayList<>();

    @Column(nullable = false)
    private int pontuacao;

    public Familia(Pessoa responsavel, Pessoa conjugue, Collection<Pessoa> dependentes) {
        setResponsavel(responsavel);
        setConjugue(conjugue);
        setDependentes(dependentes);
        this.pontuacao = 0;
    }

    public void setResponsavel(Pessoa pessoa) {
        this.responsavel = pessoa;
        pessoa.vincularFamilia(this);
    }

    public void setConjugue(Pessoa pessoa) {
        this.conjugue = pessoa;
        pessoa.vincularFamilia(this);
    }

    public void setDependentes(Collection<Pessoa> dependentes) {
        this.dependentes = dependentes;
        for (Pessoa dependente : this.dependentes) {
            dependente.vincularFamilia(this);
        }

    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public double obterRendaTotal() {
        double rendaTotal = 0.0;
        rendaTotal += responsavel.getRenda() + conjugue.getRenda() + obterRendaDependentes();
        return rendaTotal;
    }

    private double obterRendaDependentes() {
        double rendaTotal = 0.0;
        for (Pessoa dependente : dependentes) {
            rendaTotal += dependente.getRenda();
        }
        return rendaTotal;
    }
}
