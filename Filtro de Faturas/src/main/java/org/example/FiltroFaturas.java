package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroFaturas {

    List<String> estadosSul = Arrays.asList("PR", "SC", "RS");
    public FiltroFaturas() {
    }
    public List<Fatura> filtrar(List<Fatura> faturas) {

        List<Fatura> faturasFiltradas = faturas.stream()
                .filter(fatura -> fatura.getValor() >= 2000)
                .filter(fatura -> !(fatura.getValor() >= 2000 && fatura.getValor() <= 2500 && fatura.getData().before(getDataUmMesAtras())))
                .filter(fatura -> !(fatura.getValor() >= 2500 && fatura.getValor() <= 3000 && fatura.getCliente().getDataInclusao().before(getDataDoisMesesAtras())))
                .filter(fatura -> !(fatura.getValor() > 4000 && isClienteDaRegiaoSul(fatura.getCliente())))
                .collect(Collectors.toList());


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
        return this.estadosSul.contains(estado);
    }

}