/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.otavio.bancounesp;

import com.otavio.bancounesp.banco.DisplayBanco;
import com.otavio.bancounesp.banco.Extrato;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author tavexx
 */
public class Bancounesp {

    public static void main(String[] args) throws FileNotFoundException {
        File banco = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\banco.txt");
        File agencia = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\agencias.txt");
        File conta = new File("C:\\Users\\tavexx\\Documents\\NetBeansProjects\\bancounesp\\src\\main\\java\\com\\otavio\\bancounesp\\contas.txt");
        
        DisplayBanco sistema = new DisplayBanco(banco,agencia,conta);
        Extrato.gerarExtrato("Otávio Augusto Teixeira", "Rua Paulo de carvalho", "502.275.108-95", 130000.00, 19719);
        //sistema.login();
    }
}
