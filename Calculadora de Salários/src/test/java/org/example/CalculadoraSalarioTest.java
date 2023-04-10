package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculadoraSalarioTest {



    @Test
    public void testGetNome(){
        Funcionario funcionario = new Funcionario("Carlos", "carlos@email.com", "Desenvolvedor", 1500.00);
        String nome = funcionario.getNome();
        assertEquals(nome,"Carlos");
    }

    @Test
    public void testGetEmail(){
        Funcionario funcionario = new Funcionario("Carlos", "carlos@email.com", "Desenvolvedor", 1500.00);
        String email = funcionario.getEmail();
        assertEquals(email,"carlos@email.com");
    }

    @Test
    public void testGetCargo(){
        Funcionario funcionario = new Funcionario("Carlos", "carlos@email.com", "Desenvolvedor", 1500.00);
        String cargo = funcionario.getCargo();
        assertEquals(cargo,"Desenvolvedor");
    }

    @Test
    public void testGetSalarioBase(){
        Funcionario funcionario = new Funcionario("Carlos", "carlos@email.com", "Desenvolvedor", 1500.00);
        String salarioBase = funcionario.getSalarioBase();
        assertEquals(salarioBase,1500.00);
    }
    @Test
    public void testCalculaSalarioDesenvolvedorComSalarioMaiorQue3000() {
        Funcionario desenvolvedor = new Funcionario("João", "joao@email.com", "Desenvolvedor", 4000.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 3200.00; // 20% de desconto
        double salarioLiquidoReal = calculadora.calculaSalarioLiquido(desenvolvedor);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoReal, 0.001);
    }

    @Test
    public void testCalculaSalarioDesenvolvedorComSalarioMenorQue3000() {
        Funcionario desenvolvedor = new Funcionario("Maria", "maria@email.com", "Desenvolvedor", 2500.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 2250.00; // 10% de desconto
        double salarioLiquidoReal = calculadora.calculaSalarioLiquido(desenvolvedor);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoReal, 0.001);
    }

    @Test
    public void testCalculaSalarioDbaComSalarioMaiorOuIgualA2000() {
        Funcionario dba = new Funcionario("José", "jose@example.com", "DBA",3000.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 2250.00;
        double salarioLiquidoCalculado = calculadora.calculaSalarioLiquido(dba);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

    @Test
    public void testCalculaSalarioDbaComSalarioMenorQue2000() {
        Funcionario dba = new Funcionario("Ana", "ana@example.com", "DBA", 1500.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 1275.00;
        double salarioLiquidoCalculado = calculadora.calculaSalarioLiquido(dba);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

    @Test
    public void testCalculaSalarioTestadorComSalarioMaiorOuIgualA2000() {
        Funcionario testador = new Funcionario("Pedro", "pedro@example.com","Testador", 3000.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 2250.00;
        double salarioLiquidoCalculado = calculadora.calculaSalarioLiquido(testador);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

    @Test
    public void testCalculaSalarioTestadorComSalarioMenorQue2000() {
        Funcionario testador = new Funcionario("Pedro", "pedro@example.com", "Testador",1000.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 850.00;
        double salarioLiquidoCalculado = calculadora.calculaSalarioLiquido(testador);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

    @Test
    public void testCalculaSalarioGerenteComSalarioMaiorQue2000() {
        Funcionario gerente = new Funcionario("Pedro", "pedro@example.com", "Gerente", 10000.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 7000.00;
        double salarioLiquidoCalculado = calculadora.calculaSalarioLiquido(gerente);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

    @Test
    public void testCalculaSalarioGerenteComSalarioMenorQue2000() {
        Funcionario gerente = new Funcionario("Pedro", "pedro@example.com", "Gerente", 4000.00);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquidoEsperado = 3200.00;
        double salarioLiquidoCalculado = calculadora.calculaSalarioLiquido(gerente);
        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

}
