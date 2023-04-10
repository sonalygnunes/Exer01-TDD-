package org.example;

public class CalculadoraSalario {
    public double calculaSalarioLiquido(Funcionario funcionario) {
        validarFuncionario(funcionario);

        double salarioBase = funcionario.getSalarioBase();
        double desconto = calcularDesconto(funcionario.getCargo(), salarioBase);

        double salarioLiquido = salarioBase - desconto;
        return salarioLiquido;
    }

    private double calcularDesconto(String cargo, double salarioBase) {
        switch (cargo) {
            case "Desenvolvedor":
                return salarioBase >= 3000.0 ? salarioBase * 0.2 : salarioBase * 0.1;
            case "DBA":
                return salarioBase >= 2000.0 ? salarioBase * 0.25 : salarioBase * 0.15;
            case "Testador":
                return salarioBase >= 2000.0 ? salarioBase * 0.25 : salarioBase * 0.15;
            case "Gerente":
                return salarioBase >= 5000.0 ? salarioBase * 0.30 : salarioBase * 0.20;
            default:
                throw new IllegalArgumentException("Cargo inválido: " + cargo);
        }
    }

    private void validarFuncionario(Funcionario funcionario) {

        String cargo = funcionario.getCargo();
        String email = funcionario.getEmail();

        if (!"Desenvolvedor".equals(cargo) && !"DBA".equals(cargo) && !"Testador".equals(cargo) && !"Gerente".equals(cargo)) {
            throw new IllegalArgumentException("Cargo inválido: " + cargo);
        }
        else if (!email.contains("@")){
            throw new IllegalArgumentException("Email inválido: " + cargo);
        }
    }
}
