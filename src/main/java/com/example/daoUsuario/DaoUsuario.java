package com.example.daoUsuario;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Usuario;

public class DaoUsuario {

    private Connection conn;

    public DaoUsuario(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Usuario usuario) throws SQLException{

        String sql = "INSERT INTO Postagem ( nome, email, senha) VALUES (?, ?, ? )";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getEmail());
        stmt.setString(3, usuario.getSenha());
        stmt.executeUpdate();
        stmt.close();
      
    }


    public  List<Usuario> listar() throws SQLException{

        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nome, email, senha FROM Postagem";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            Usuario u = new Usuario();
             u.setId(rs.getInt("id"));
             u.setNome(rs.getString("nome"));
             u.setEmail(rs.getString("email"));   
             u.setSenha(rs.getString("senha"));
                   
           
            lista.add(u);
        
        }
        rs.close();
        stmt.close();
        return lista;
    }


    public void atualizarNome(int id, String novoNome)throws  SQLException{
        String sql = "UPDATE Postagem SET nome = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        stmt.close();
     }

     public void atualizarEmail(int id, String novoEmail)throws SQLException{
        String sql = "UPDATE Postagem SET email = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoEmail);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        stmt.close();
     }

     public void atualizarSenha(int id, String novaSenha)throws SQLException{
        String sql = "UPDATE Postagem SET senha = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,novaSenha);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        stmt.close();
     }

     public void excluir(int id)throws SQLException{
        String sql = "DELETE FROM Postagem WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
     }

      public void ExcluirTabela(){
        String sql = "DROP Table Postagem";
        try (Statement stmt = conn.createStatement()) {
            {
                stmt.executeUpdate(sql);
                System.out.println("Tabela excluida com sucesso!!");

                stmt.close();
                

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }





}
