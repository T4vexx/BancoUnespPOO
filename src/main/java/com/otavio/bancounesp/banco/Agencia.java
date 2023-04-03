/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.otavio.bancounesp.banco;

import java.util.ArrayList;

/**
 *
 * @author Otavio Augusto Teixeira <otavio.a.teixeira@unesp.br>
 */
public class Agencia {
    private int codigo;
    private String nome;
    private String endereco;
    private ArrayList<Conta> contas;
    
    public Agencia(int codigo, String nome, String endereco) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        contas = new ArrayList<Conta>();
    }
    
    public void cadastrarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(int numeroConta, String senha) {
        Conta minhaConta = null; 
        for(Conta conta: contas) {
            if(conta.getNumeroDaConta() == numeroConta && conta.validarSenha(senha)) {
                minhaConta = conta;
            }
        }
        return minhaConta;
    }

    public Conta buscarConta(int numeroConta) {
        Conta minhaConta = null; 
        for(Conta conta: contas) {
            if(conta.getNumeroDaConta() == numeroConta) {
                minhaConta = conta;
            }
        }
        return minhaConta;
    }

    public Conta buscarConta(String cpf) {
        Conta minhaConta = null; 
        for(int i=0; i<contas.size(); i++) {
            if(contas.get(i).getCpf().equalsIgnoreCase(cpf)) {
                minhaConta = contas.get(i);
                break;
            }
        }
           
        return minhaConta;
    }
}
