/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoestoque.dal;

import java.sql.*;
import jdk.nashorn.internal.ir.ForNode;
//Conector ao banco.

/**
 *
 * @author Desenvolvedor
 */
public class ModuloConexao {
       
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // a linha abaixo chama o driver.
        String driver = "com.mysql.jdbc.Driver";
        // armazenando informações.
        // estabelecendo conexão com o banco.
        String url = "jdbc:mysql://localhost:3306/estoqueprojeto";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
