package org.example;

public class Funcionario {

    private String nome;
    private String email;

    private String cargo;

    private double salarioBase;
    public Funcionario(String nome, String email, String cargo, double salarioBase) {
        this.nome = nome;
        this.email = email;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }


    public String getNome() {
        return this.nome;
    }

    public String getEmail() {
        return this.email;
    }

    public String getCargo() {
        return this.cargo;
    }

    public Double getSalarioBase() {
        return this.salarioBase;
    }
}
