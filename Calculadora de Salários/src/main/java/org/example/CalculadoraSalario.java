package org.example;

public class CalculadoraSalario {
    public double calculaSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        double desconto = 0.0;

        if (funcionario.getCargo().equals("Desenvolvedor")) {
            if (salarioBase >= 3000.0) {
                desconto = salarioBase * 0.2;
            } else {
                desconto = salarioBase * 0.1;
            }
        } else if (funcionario.getCargo().equals("DBA")) {
            if (salarioBase >= 2000.0) {
                desconto = salarioBase * 0.25;
            } else {
                desconto = salarioBase * 0.15;
            }

        } else if (funcionario.getCargo().equals("Testador")) {
            if (salarioBase >= 2000.0) {
                desconto = salarioBase * 0.25;
            } else {
                desconto = salarioBase * 0.15;
            }
        } else if (funcionario.getCargo().equals("Gerente")) {
            if (salarioBase >= 5000.0) {
                desconto = salarioBase * 0.3;
            } else {
                desconto = salarioBase * 0.2;
            }

        }
        double salarioLiquido = salarioBase - desconto;
        return salarioLiquido;
    }
}