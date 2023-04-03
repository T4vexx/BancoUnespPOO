/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.otavio.bancounesp.banco;
/**
 *
 * @author Otavio Augusto Teixeira <otavio.a.teixeira@unesp.br>
 */
public class Conta {
    private int numero;
    private double saldo;
    private String nome;
    private String endereco;
    private String cpf;
    private String dataNascimento;
    private String senha;
    private int agencia;
    
    public Conta(String nome, String dataNascimento, String endereco, String cpf, double saldo, int numero, String senha, int agencia) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cpf = cpf;
        this.saldo = saldo;
        this.senha = senha;
        this.numero = numero;
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getNumeroDaConta() {
        return numero;
    }
    
    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if(saldo - valor < 0) {
            return false;
        } else {
            saldo -= valor;
            return true;
        }
    }

    public boolean validarSenha(String senha) {
        if(this.senha.equalsIgnoreCase(senha)) {
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }
}
