package org.example;

import java.util.Date;

public class Cliente {
    private String nome;
    private Date dataInclusao;
    private String estado;

    public Cliente(String nome, Date dataInclusao, String estado) {
        this.nome = nome;
        this.dataInclusao = dataInclusao;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}