package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.daoUsuario.DaoUsuario;
import com.example.model.Usuario;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conn = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/Usuarios",
            "postgres",
            "123456"
        );

        DaoUsuario du = new DaoUsuario(conn);
        
        Usuario u2 = new Usuario("Buzz","buzz@hotmail.com", 12345);

        

        
        
        du.inserir(u2);
        //du.atualizarNome(4, "Natalie");
        //du.ExcluirTabela();
        //du.atualizarSenha(4, 1234);
       
        
        /*du.atualizarEmail(8, "buzz@hotmail.com");
        du.atualizarSenha(1, 123456789);
        du.excluir(12);
        du.listar();*/
        

        
       
        

        
    
    }
}