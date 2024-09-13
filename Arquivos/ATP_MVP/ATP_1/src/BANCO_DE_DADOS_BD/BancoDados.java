/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BANCO_DE_DADOS_BD;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author HUGO CASTRO
 */
public class BancoDados {
    Connection cn;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3307/cadastro","root","");
            System.out.println("Conexão estabelecida");
            
            
        } catch (Exception e){
            System.out.println("Erro de conexão"+e);
            
        }
        return cn;
        
    }

}