package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CalculadoraSalarioFuncionalTest {
    @Test
    public void testCalculaSalarioLiquido() {
        CalculadoraSalario calculadora = new CalculadoraSalario();

        // Testando salário líquido para o menor salário base de cada cargo
        Funcionario funcionario1 = new Funcionario("João", "a@a.com", "Desenvolvedor", 998.0);
        Funcionario funcionario2 = new Funcionario("Maria", "a@a.com", "DBA", 998.0);
        Funcionario funcionario3 = new Funcionario("José", "a@a.com", "Testador", 998.0);
        Funcionario funcionario4 = new Funcionario("Ana", "a@a.com", "Gerente", 998.0);

        Assertions.assertEquals(898.2, calculadora.calculaSalarioLiquido(funcionario1), 0.1);
        Assertions.assertEquals(848.3, calculadora.calculaSalarioLiquido(funcionario2), 0.1);
        Assertions.assertEquals(848.3, calculadora.calculaSalarioLiquido(funcionario3), 0.1);
        Assertions.assertEquals(798.4, calculadora.calculaSalarioLiquido(funcionario4), 0.1);

        // Testando salário líquido para o maior salário base de cada cargo
        Funcionario funcionario5 = new Funcionario("Carlos", "a@a.com", "Desenvolvedor", 100000.0);
        Funcionario funcionario6 = new Funcionario("Sandra", "a@a.com", "DBA", 100000.0);
        Funcionario funcionario7 = new Funcionario("Pedro", "a@a.com", "Testador", 100000.0);
        Funcionario funcionario8 = new Funcionario("Paula", "a@a.com", "Gerente", 100000.0);

        Assertions.assertEquals(80000.0, calculadora.calculaSalarioLiquido(funcionario5), 0.1);
        Assertions.assertEquals(75000, calculadora.calculaSalarioLiquido(funcionario6), 0.1);
        Assertions.assertEquals(75000.0, calculadora.calculaSalarioLiquido(funcionario7), 0.1);
        Assertions.assertEquals(70000.0, calculadora.calculaSalarioLiquido(funcionario8), 0.1);

        // Testando salário líquido para valores aleatórios e limites inferiores/superiores - 1
        Funcionario funcionario9 = new Funcionario("Roberto", "a@a.com", "Desenvolvedor", 2000.0);
        Funcionario funcionario10 = new Funcionario("Patrícia", "a@a.com", "DBA", 4000.0);
        Funcionario funcionario11 = new Funcionario("Carlos", "a@a.com", "Testador", 8000.0);
        Funcionario funcionario12 = new Funcionario("Ana", "a@a.com", "Gerente de Projetos", 6000.0);

        // Valor aleatório abaixo do limite inferior
        Funcionario funcionario13 = new Funcionario("Pedro", "a@a.com", "Desenvolvedor", 1001);

        // Valor aleatório acima do limite superior
        Funcionario funcionario14 = new Funcionario("Mariana", "a@a.com", "Gerente", 11000.0);

        Assertions.assertEquals(1800.0, calculadora.calculaSalarioLiquido(funcionario9), 0.1);
        Assertions.assertEquals(3000.0, calculadora.calculaSalarioLiquido(funcionario10), 0.1);
        Assertions.assertEquals(6000.0, calculadora.calculaSalarioLiquido(funcionario11), 0.1);
        Assertions.assertEquals(900.9, calculadora.calculaSalarioLiquido(funcionario13), 0.1);
        Assertions.assertEquals(7700.0, calculadora.calculaSalarioLiquido(funcionario14), 0.1);


    }


}