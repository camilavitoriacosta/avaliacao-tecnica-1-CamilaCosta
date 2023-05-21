package com.example.desafiotecnico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataConversor {
    public Date converterStringParaDate(String data) throws ParseException {
        String pattern = "yyyy-MM-dd";

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(data);
    }
}
