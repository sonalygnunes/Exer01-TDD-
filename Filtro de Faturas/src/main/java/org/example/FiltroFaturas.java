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
            if (fatura.getValor() >= 2000 && fatura.getValor() <= 2500 && fatura.getData().before(getDataUmMesAtras())) {
                continue;
            }
            if (fatura.getValor() >= 2500 && fatura.getValor() <= 3000 && fatura.getCliente().getDataInclusao().before(getDataDoisMesesAtras())) {
                continue;
            }
            if (fatura.getValor() >= 2500 && fatura.getValor() <= 3000 && fatura.getCliente().getDataInclusao().before(getDataDoisMesesAtras())) {
                continue;
            }
            if (fatura.getValor() > 4000 && isClienteDaRegiaoSul(fatura.getCliente())) {
                continue;
            }
            faturasFiltradas.add(fatura);
        }
        return faturasFiltradas;
    }
    private Date getDataUmMesAtras() {
        Date agora = new Date();
        long umMesEmMilissegundos = 30L * 24L * 60L * 60L * 1000L;
        long tempoAtras = agora.getTime() - umMesEmMilissegundos;
        return new Date(tempoAtras);
    }
    private Date getDataDoisMesesAtras() {
        Date agora = new Date();
        long doisMesesEmMilissegundos = 2L * 30L * 24L * 60L * 60L * 1000L;
        long tempoAtras = agora.getTime() - doisMesesEmMilissegundos;
        return new Date(tempoAtras);
    }
    private boolean isClienteDaRegiaoSul(Cliente cliente) {
        String estado = cliente.getEstado();
        return estado.equals("PR") || estado.equals("SC") || estado.equals("RS");
    }

}
