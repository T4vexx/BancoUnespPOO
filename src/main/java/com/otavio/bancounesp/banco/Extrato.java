/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.otavio.bancounesp.banco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Otavio Augusto Teixeira <otavio.a.teixeira@unesp.br>
 */
public class Extrato {
    private static int extratosTirados=0;
    
    public static void gerarExtrato(String nome, String endereco, String cpf, double saldo, int numero, String nomeBanco, int Agencia) {
        // use esta linha no notbook File diretorio = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\extratos"); 
        File diretorio = new File("C:\\Users\\tavin\\OneDrive\\Desktop\\3semestre\\BancoUnespPOO\\src\\main\\java\\com\\otavio\\bancounesp\\extratos"); 
        String message = String.format("%d_%d_extrato.txt",numero,extratosTirados);
        File arquivo = new File(diretorio, message);
        SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy '|' HH:mm:ss");
        
        try {

            arquivo.createNewFile();
            FileWriter fileWriter = new FileWriter(arquivo, StandardCharsets.UTF_8);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            
            printWriter.println("**********************************************************************************************");
            printWriter.println("***                                        EXTRATO                                         ***");
            printWriter.println("**********************************************************************************************");
            printWriter.println("Banco: "+nomeBanco+"  Agencia: "+Agencia);
            printWriter.println("**********************************************************************************************");
            printWriter.println("Conta: "+nome+"  CPF: "+cpf+"  Numero: "+numero);
            printWriter.println("Endereço: "+endereco+"  Data: "+formatter.format(new Date()));
            printWriter.println("");
            printWriter.println("Saldo: "+saldo);

            
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            System.out.println(e);
        }
        
        extratosTirados++;
    }
}
