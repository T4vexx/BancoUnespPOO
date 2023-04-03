/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.otavio.bancounesp.banco;
/**
 *
 * @author tavexx
 */
public class Conta {
    private int numero;
    private double saldo;
    private String nome;
    private String endereco;
    private String cpf;
    private String dataNascimento;
    private String senha;
    
    public Conta(String nome, String dataNascimento, String endereco, String cpf, double saldo, int numero, String senha) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cpf = cpf;
        this.saldo = saldo;
        this.senha = senha;
        this.numero = numero;
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
