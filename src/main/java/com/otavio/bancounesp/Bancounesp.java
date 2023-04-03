/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.otavio.bancounesp;

import com.otavio.bancounesp.banco.DisplayBanco;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * <h1>Banco Unesp</h1>
 * <p>Sistema de um banco desenvolvido por Otavio Augusto Teixeira para aula de Programação orientada a objetos
 * 
 * @author Otavio Augusto Teixeira <otavio.a.teixeira@unesp.br>
 */
public class Bancounesp {

    public static void main(String[] args) throws FileNotFoundException {
        // use esta linha notbook File banco = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\banco.txt");
        // use esta linha notbook File agencia = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\agencias.txt");
        // use esta linha notbook File conta = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\contas.txt");
        File banco = new File("C:\\Users\\tavin\\OneDrive\\Desktop\\3semestre\\BancoUnespPOO\\src\\main\\java\\com\\otavio\\bancounesp\\banco.txt");
        File agencia = new File("C:\\Users\\tavin\\OneDrive\\Desktop\\3semestre\\BancoUnespPOO\\src\\main\\java\\com\\otavio\\bancounesp\\agencias.txt");
        File conta = new File("C:\\Users\\tavin\\OneDrive\\Desktop\\3semestre\\BancoUnespPOO\\src\\main\\java\\com\\otavio\\bancounesp\\contas.txt");

        DisplayBanco sistema = new DisplayBanco(banco,agencia,conta);
        sistema.login();
    }
}
