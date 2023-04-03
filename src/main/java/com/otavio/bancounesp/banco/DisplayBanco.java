/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.otavio.bancounesp.banco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author tavexx
 */
public class DisplayBanco {
  
    private Banco meuBanco;

    public DisplayBanco(File banco,File agencias, File contas) {
        Scanner bancoFiles = null;
        Scanner agenciaFiles = null;
        Scanner contasFiles = null;
        String linha;
        String[] campos;

        try {
            bancoFiles = new Scanner(banco);
            agenciaFiles = new Scanner(agencias);
            contasFiles = new Scanner(contas);
        } catch (FileNotFoundException ex) {
            //
        }
           
        while(bancoFiles.hasNextLine()) {
            linha = bancoFiles.nextLine();
            campos = linha.split("#");
            Banco meuBanco = new Banco(campos[0],Integer.parseInt(campos[1]),campos[2],campos[3]);
            this.meuBanco = meuBanco;
        }
        
        while(agenciaFiles.hasNextLine()) {
            linha = agenciaFiles.nextLine();
            campos = linha.split("#");
            meuBanco.cadastrarAgencia(Integer.parseInt(campos[1]),campos[0],campos[2]);
        }
        
        while(contasFiles.hasNextLine()) {
            linha = contasFiles.nextLine();
            campos = linha.split("#");
            meuBanco.cadastrarConta(campos[0],campos[1],campos[2],campos[3],Double.parseDouble(campos[4]),Integer.parseInt(campos[6]),campos[7],Integer.parseInt(campos[5]));
            
        }

        bancoFiles.close();
        agenciaFiles.close();
        contasFiles.close();
        linha = null;
        campos = null;
        
    }

    public void login() {
        Scanner in = new Scanner(System.in);
        int numeroDaAgencia;
        int numeroDaConta;
        String minhaSenha;
        boolean isAccountLogged = true;
        boolean flag=true;

        do {

            do {

                clrscr();
                System.out.println("********************************");
                System.out.println("**** SISTEMA DO BANCO UNESP ****");
                System.out.println("********************************");
                System.out.println("           - Login -            ");
                if(isAccountLogged == false) {
                    System.out.println("Credenciais incorretas - Tente novamente!");
                }
                

                System.out.printf("Digite o número da sua agencia: %n> ");
                numeroDaAgencia = in.nextInt();
                System.out.printf("Digite o número da sua conta: %n> ");
                numeroDaConta = in.nextInt();
                in.nextLine();
                System.out.printf("Digite a senha da sua conta: %n> ");
                minhaSenha = in.nextLine();

            
                isAccountLogged = meuBanco.logarCliente(numeroDaAgencia, numeroDaConta, minhaSenha);
               
            } while(!isAccountLogged);

            telaUsuario();
        } while(flag);

        in.close();
    }

    private void telaUsuario() {
        Scanner in = new Scanner(System.in);
        int opt=0;
    
        do {
            System.out.println("********************************");
            System.out.println("**** SISTEMA DO BANCO UNESP ****");
            System.out.println("********************************");
            System.out.println("          - Dashboard -         ");

            System.out.println("> 1 - Consultar saldo");
            System.out.println("> 2 - Depósito");
            System.out.println("> 3 - Saque");
            System.out.println("> 4 - Transferência");
            System.out.println("> 5 - PIX");
            System.out.println("> 6 - Sair");
            opt = Integer.parseInt(in.nextLine());

            switch (opt) {
                case 1:
                    operacaoSaldo();
                    break;
                case 2:
                    operacaoDeposito();
                    break;
                case 3:
                    operacaoSaque();
                    break;
                case 4:
                    operacaoTransferencia();
                    break;
                case 5:
                    operacaoPIX();
                    break;
                default :
                    operacaoSair();
            }

        } while(opt != 6);

    }

    private void operacaoSair() {
        meuBanco.deslogarConta();
    }

    private void operacaoDeposito() {
        Scanner in = new Scanner(System.in);
        double deposito=0;

        try {
            do {
                System.out.printf("Digite a quantia que deseja depositar: %n> ");
                deposito = in.nextDouble();
            } while(deposito <= 0);
        } catch (InputMismatchException err) {
           System.out.println("Erro o valor digitado não é valido! (Ex usa , no lugar de . ou vice versa)");
           return;
        }

        meuBanco.realizarDeposito(deposito);
    }

    private void operacaoSaque() {
        Scanner in = new Scanner(System.in);
        double saque=0;
        boolean result;

        try {
            do {
                System.out.printf("Digite a quantia que deseja sacar: %n> ");
                saque = in.nextDouble();
            } while(saque <= 0);
        } catch (InputMismatchException err) {
            System.out.println("Erro o valor digitado não é valido! (Ex usa , no lugar de . ou vice versa)");
            return;
        }    
        

        result = meuBanco.realizarSaque(saque);
        if(result) {
            System.out.printf("Voce retirou %.3f da sua conta%n",saque);
        } else {
            System.out.println("Você nao possui saldo o suficiente - tente retirar uma quantia menor que R$ "+saque);
        }
        
    }

    private void operacaoSaldo() {
        double meuSaldo;
        meuSaldo = meuBanco.saldo();
        System.out.println("Seu saldo atual é R$ " + meuSaldo);
    }

    private void operacaoTransferencia() {
        Scanner in = new Scanner(System.in);
        int numeroDaAgencia;
        int numeroDaConta;
        double valorTranferencia;
        int result;

        try {
            do {
                System.out.printf("Digite o número da agencia do destinatario: %n> ");
                numeroDaAgencia = in.nextInt();
                System.out.printf("Digite o número da conta do destinatario: %n> ");
                numeroDaConta = in.nextInt();
                in.nextLine();
                System.out.printf("Digite o valor para ser tranferido: %n> ");
                valorTranferencia = in.nextDouble();
            } while(valorTranferencia <= 0);
        } catch (InputMismatchException err) {
            System.out.println("Erro o valor digitado não é valido! (Ex usa , no lugar de . ou vice versa)");
            return;
        }  
        
        result = meuBanco.tranferencia(numeroDaAgencia, numeroDaConta, valorTranferencia);

        switch (result) {
            case 0:
                System.out.printf("Tranferencia para conta %d feita com sucesso - valor da tranferencia %.3f%n",numeroDaConta,valorTranferencia);
                break;
            case 1:
                System.out.println("Credenciais de conta erradas - Conta inexistente ou nao encontrada - Tente novamente!");
                break;
            case 2:
                System.out.println("Valor de saque indisponivel - Voce nao possui saldo suficiente!");
                break;
        }
        
    }

    private void operacaoPIX() {
        Scanner in = new Scanner(System.in);
        String cpf;
        double valorTranferencia;
        int result;

        try {
            do {
                System.out.printf("Digite o cpf do destinatario: %n> ");
                cpf = in.nextLine();
                System.out.printf("Digite o valor para ser tranferido: %n> ");
                valorTranferencia = in.nextDouble();
            } while(valorTranferencia <= 0);
        } catch (InputMismatchException err) {
            System.out.println("Erro o valor digitado não é valido! (Ex usa , no lugar de . ou vice versa)");
            return;
        }  

        result = meuBanco.pix(cpf, valorTranferencia);

        switch (result) {
            case 0:
                System.out.printf("Pix para conta %s feita com sucesso - valor da tranferencia %.3f%n",cpf,valorTranferencia);
                break;
            case 1:
                System.out.println("Credencial de conta errada - Conta inexistente ou nao encontrada - Tente novamente!");
                break;
            case 2:
                System.out.println("Valor de saque indisponivel - Voce nao possui saldo suficiente!");
                break;
        }
        
    }

    private static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
