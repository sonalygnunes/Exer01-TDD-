package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FiltroFaturas {
    public FiltroFaturas() {
    }
    public List<Fatura> filtrar(List<Fatura> faturas) {

        List<Fatura> faturasFiltradas = new ArrayList<>();

        for (Fatura fatura : faturas) {
            if (fatura.getValor() < 2000) {
                continue;
            }
            faturasFiltradas.add(fatura);
        }
        return faturasFiltradas;
    }

}
