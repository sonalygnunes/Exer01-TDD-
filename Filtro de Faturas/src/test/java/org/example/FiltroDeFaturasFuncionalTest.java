package org.example;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class FiltroDeFaturasFuncionalTest {
    @Test
    public void testValorLimite() {

        Date agora = new Date();
        long umMesEmMilissegundos = 30L * 24L * 60L * 60L * 1000L;
        long doisMesesEmMilissegundos = 2 * umMesEmMilissegundos;
        long tresMesesEmMilissegundos = 3 * umMesEmMilissegundos;

        long now = agora.getTime();
        long umMesAtras = agora.getTime() - umMesEmMilissegundos;
        long doisMesesAtras = agora.getTime() - doisMesesEmMilissegundos;
        long tresMesesAtras = agora.getTime() - tresMesesEmMilissegundos;

        long[] meses = {now, umMesAtras, doisMesesAtras, tresMesesAtras};
        String[] regioes = {"SC", "PB"};
        double[] valores = {0,1,1000,1998,1999,2000,2001,2250,2499,2500,2501,2750,2999,3000,3001,3500,4001,4002};
        List<Fatura> faturas = new ArrayList<>();


        for (double valor : valores) {
            for (String regiao : regioes) {
                for ( long mes : meses){
                    faturas.add(new Fatura(String.valueOf(valor), valor, new Date(), new Cliente("Cliente", new Date(mes), regiao)));
                }
            }
        }
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas);

        assertEquals(50, faturasFiltradas.size());

       

    }



}
