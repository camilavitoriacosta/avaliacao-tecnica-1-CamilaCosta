package com.example.desafiotecnico.dominio.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double renda;

    @Column(nullable = false)
    private Date dataDeNascimento;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;

    public Pessoa(String nome, double renda, Date dataDeNascimento) {
        this.nome = nome;
        this.renda = renda;
        this.dataDeNascimento = dataDeNascimento;
    }

    public void vincularFamilia(Familia familia) {
        this.familia = familia;
    }
}
