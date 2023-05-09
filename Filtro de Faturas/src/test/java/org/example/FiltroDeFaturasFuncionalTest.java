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
        List<Fatura> faturas1 = new ArrayList<>();


        for (double valor : valores) {
            for (String regiao : regioes) {
                for ( long mes : meses){
                    faturas1.add(new Fatura(String.valueOf(valor), valor, new Date(), new Cliente("Cliente", new Date(mes), regiao)));
                }
            }
        }
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas1);

        assertEquals(50, faturasFiltradas.size());

    }

    @Test
    public void testPartiçãoEquivalencia() {

        Date agora = new Date();
        long umMesEmMilissegundos = 30L * 24L * 60L * 60L * 1000L;
        long doisMesesEmMilissegundos = 2 * umMesEmMilissegundos;

        long now = agora.getTime();
        long umMesAtras = agora.getTime() - umMesEmMilissegundos;
        long doisMesesAtras = agora.getTime() - doisMesesEmMilissegundos;

        long[] meses = {now, umMesAtras, doisMesesAtras};
        String[] regioes = {"SC", "PB"};
        double[] valores = {1000,2250,2750,4500};
        List<Fatura> faturas2 = new ArrayList<>();


        for (double valor : valores) {
            for (String regiao : regioes) {
                for ( long mes : meses){
                    faturas2.add(new Fatura(String.valueOf(valor), valor, new Date(), new Cliente("Cliente", new Date(mes), regiao)));
                }
            }
        }
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas2);


        assertEquals(5, faturasFiltradas.size());

    }
    @Test
    public void TabelaDeDecisões() {

        Date agora = new Date();
        long umMesEmMilissegundos = 30L * 24L * 60L * 60L * 1000L;
        long doisMesesEmMilissegundos = 2 * umMesEmMilissegundos;

        long now = agora.getTime();
        long umMesAtras = agora.getTime() - umMesEmMilissegundos;
        long doisMesesAtras = agora.getTime() - doisMesesEmMilissegundos;

        List<Fatura> faturas3 = new ArrayList<>();

        faturas3.add(new Fatura(String.valueOf(01), 1900, new Date(), new Cliente("Cliente01", new Date(now), "PB")));
        faturas3.add(new Fatura(String.valueOf(02), 2200, new Date(), new Cliente("Cliente02", new Date(umMesAtras),"PB")));
        faturas3.add(new Fatura(String.valueOf(03), 2700, new Date(), new Cliente("Cliente03", new Date(doisMesesAtras),"PB")));
        faturas3.add(new Fatura(String.valueOf(04), 4500, new Date(), new Cliente("Cliente04", new Date(now), "SC")));
        faturas3.add(new Fatura(String.valueOf(05), 2200, new Date(), new Cliente("Cliente05", new Date(doisMesesAtras),"PB")));
        faturas3.add(new Fatura(String.valueOf(06), 2700, new Date(), new Cliente("Cliente06", new Date(doisMesesAtras), "PB")));
        faturas3.add(new Fatura(String.valueOf(07), 2700, new Date(), new Cliente("Cliente07", new Date(umMesAtras), "PB")));
        faturas3.add(new Fatura(String.valueOf(8), 4500, new Date(), new Cliente("Cliente08", new Date(now), "PB")));


        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas3);

        for (int i = 0; i < faturasFiltradas.size(); i++) {

            System.out.println(faturasFiltradas.get(i).toString());
        }
        assertEquals(2, faturasFiltradas.size());

    }


}
