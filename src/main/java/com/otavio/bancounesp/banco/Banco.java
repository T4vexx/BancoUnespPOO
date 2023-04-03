/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.otavio.bancounesp.banco;

import java.util.ArrayList;

/**
 * <h1>Banco</h1>
 * <p>Classe que cordena toda as funcionalidades dos bancos e agencia 
 * @author Otavio Augusto Teixeira <otavio.a.teixeira@unesp.br>
 */
public class Banco {
    private int numero;
    private String nome;
    private String cnpj;
    private String endereco;
    private Conta contaLogada;
    private ArrayList<Agencia> agencias;
    
    public Banco(String nome, int numero, String cnpj, String endereco) {
        this.nome = nome;
        this.numero = numero;
        this.cnpj = cnpj;
        this.endereco = endereco;
        agencias = new ArrayList<Agencia>();
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroUsuario() {
        return contaLogada.getNumeroDaConta();
    }

    public String getUsuarioCpf() {
        return contaLogada.getCpf();
    }

    public double getSaldoUsuario() {
        return contaLogada.getSaldo();
    }

    public String getNomeUsuario() {
        return contaLogada.getNome();
    }

    public String getEnderecoUsuario() {
        return contaLogada.getEndereco();
    }
    
    public int getAgenciaUsuario() {
        return contaLogada.getAgencia();
    }

    public void cadastrarAgencia(int codigo, String nome, String endereco) {
       Agencia agencia = new Agencia(codigo,nome,endereco);
       agencias.add(agencia);
    }
    
    public void cadastrarAgencia(Agencia agencia) {
        agencias.add(agencia);
    }
    
    public Agencia buscarAgencia(int numeroDaAgencia) {
        return agencias.get(numeroDaAgencia);
    }
    
    public void cadastrarConta(String nome, String dataNascimento, String endereco, String cpf, double saldo, int numero, String senha, int numeroDaAgencia) {
        Conta novaConta;
        Agencia agencia;

        novaConta = new Conta(nome, dataNascimento, endereco, cpf, saldo, numero, senha,numeroDaAgencia);
        agencia = buscarAgencia(numeroDaAgencia);
        agencia.cadastrarConta(novaConta);
        
    }

    public boolean logarCliente(int numAgencia, int numConta, String senha) {
        Agencia minhaAgencia;
        Conta minhaConta=null;
        minhaAgencia = agencias.get(numAgencia);
        if(minhaAgencia != null) {
            minhaConta = minhaAgencia.buscarConta(numConta, senha);

            if(minhaConta != null) {
                contaLogada = minhaConta;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        
    }

    public void realizarDeposito(double deposito) {
        contaLogada.depositar(deposito);
    }

    public boolean realizarSaque(double saque) {
        return contaLogada.sacar(saque);
    }

    public double saldo() {
        return contaLogada.getSaldo();
    }

    public int tranferencia(int numAgencia, int numConta, double valor) {
        Agencia minhaAgencia=null;
        Conta contaParaTransferencia=null;
        boolean isSaqueAvaiable=false;
        minhaAgencia = buscarAgencia(numAgencia);
        contaParaTransferencia = minhaAgencia.buscarConta(numConta);

        if(minhaAgencia != null && contaParaTransferencia != null) {
            isSaqueAvaiable = realizarSaque(valor);
            if(isSaqueAvaiable) {
                contaParaTransferencia.depositar(valor);
                return 0;
            } else {
                return 2;
            }
        } else {
            return 1;
        }

    }

    public int pix(String chaveCpf, double valor) {
        Conta contaPix=null;
        boolean isSaqueAvaiable;
        contaPix = getContaByCpf(chaveCpf);

        if(contaPix != null) {
            isSaqueAvaiable = realizarSaque(valor);
            if(isSaqueAvaiable) {
                contaPix.depositar(valor);
                return 0;
            } else {
                return 2;
            }
        } else {
            return 1;
        }
    }

    public Conta getContaByCpf(String cpf) {
        Agencia agenciaCpf=null;
        Conta contaCpf=null;

        for(int i=0; i<agencias.size(); i++) {
            agenciaCpf = agencias.get(i);
            contaCpf = agenciaCpf.buscarConta(cpf);
            if(contaCpf != null) {
                break;
            }
        }

        return contaCpf;
    }

    public void deslogarConta() {
        contaLogada = null;
    }

}
