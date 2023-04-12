package org.example;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FiltroDeFaturasTest {

    @Test
    public void testFiltroValorMenorQue2000() {
        Fatura fatura1 = new Fatura("001", 1500, new Date(), new Cliente("Ana", new Date(), "SP"));
        Fatura fatura2 = new Fatura("002", 1999, new Date(), new Cliente("Arisu", new Date(), "RJ"));
        Fatura fatura3 = new Fatura("003", 2001, new Date(), new Cliente("Mario", new Date(), "SC"));
        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura1);
        faturas.add(fatura2);
        faturas.add(fatura3);
        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas);
        assertEquals(1, faturasFiltradas.size());
        assertFalse(faturasFiltradas.contains(fatura1));
        assertFalse(faturasFiltradas.contains(fatura2));
        assertTrue(faturasFiltradas.contains(fatura3));
    }

    @Test
    public void testFiltroValorEntre2000E2500EDataMenorQueUmMesAtras() {
        Calendar data = Calendar.getInstance();
        data.add(Calendar.MONTH, -1);
        Date data1MesesAtras = data.getTime();
        data.add(Calendar.MONTH, -2);
        Date data2MesesAtras = data.getTime();

        Fatura fatura1 = new Fatura("001", 2000, data.getTime(), new Cliente("Ana", new Date(), "SP"));
        Fatura fatura2 = new Fatura("002", 2400, data.getTime(), new Cliente("Arisu", new Date(), "RJ"));
        Fatura fatura3 = new Fatura("003", 2500, new Date(), new Cliente("Mario", new Date(), "SC"));

        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura1);
        faturas.add(fatura2);
        faturas.add(fatura3);

        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas);

        assertEquals(1, faturasFiltradas.size());
        assertFalse(faturasFiltradas.contains(fatura1));
        assertFalse(faturasFiltradas.contains(fatura2));
        assertTrue(faturasFiltradas.contains(fatura3));
    }

    @Test
    public void testFiltroValorEntre2500E3000EDataInclusaoClienteMenorQue2MesesAtras() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date data1MesAtras = calendar.getTime();
        calendar.add(Calendar.MONTH, -2);
        Date data2MesesAtras = calendar.getTime();

        Cliente cliente1 = new Cliente("Arisu", data1MesAtras, "SP");
        Cliente cliente2 = new Cliente("Marilene", data2MesesAtras, "SC");
        Cliente cliente3 = new Cliente("Merlin", new Date(), "SC");


        Fatura fatura1 = new Fatura("001", 2000, data1MesAtras, cliente1);
        Fatura fatura2 = new Fatura("002", 2300, new Date(), cliente1);
        Fatura fatura3 = new Fatura("003", 2600, new Date(), cliente2);
        Fatura fatura4 = new Fatura("004", 3000, new Date(), cliente3);

        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura1);
        faturas.add(fatura2);
        faturas.add(fatura3);
        faturas.add(fatura4);

        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas);

        assertEquals(2, faturasFiltradas.size());
        assertFalse(faturasFiltradas.contains(fatura1));
        assertTrue(faturasFiltradas.contains(fatura2));
        assertFalse(faturasFiltradas.contains(fatura3));
        assertTrue(faturasFiltradas.contains(fatura4));

    }
    @Test
    public void testFiltroValorMaiorQue4000EPertenceARegiaoSul() {

        Fatura fatura1 = new Fatura("001", 5000, new Date(), new Cliente("Arisu", new Date(), "SP"));
        Fatura fatura2 = new Fatura("002", 4500, new Date(), new Cliente("Ana", new Date(), "SC"));
        Fatura fatura3 = new Fatura("003", 3000, new Date(), new Cliente("Mario", new Date(), "RS"));

        List<Fatura> faturas = new ArrayList<>();
        faturas.add(fatura1);
        faturas.add(fatura2);
        faturas.add(fatura3);

        FiltroFaturas filtro = new FiltroFaturas();
        List<Fatura> faturasFiltradas = filtro.filtrar(faturas);
        assertEquals(2, faturasFiltradas.size());
        assertTrue(faturasFiltradas.contains(fatura1));
        assertFalse(faturasFiltradas.contains(fatura2));
        assertTrue(faturasFiltradas.contains(fatura3));
    }

}

