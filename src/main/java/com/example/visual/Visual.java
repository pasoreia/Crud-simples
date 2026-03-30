package com.example.visual;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.example.daoUsuario.DaoUsuario;
import com.example.model.Usuario;



public class Visual {


    private static Connection conn;
    public static void main(String[] args) {

        try {
            conn = DriverManager.getConnection(  
                 "jdbc:postgresql://localhost:5432/Usuarios",
                "postgres",
                "123456");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Usuario usuario = new Usuario();

        // janela principal 
        JFrame janelaPrincipal = new JFrame("Tabela de cadastro");
        janelaPrincipal.setDefaultCloseOperation(janelaPrincipal.EXIT_ON_CLOSE);
        janelaPrincipal.setSize(400, 400);

        // nomes para explicar qual dado será inserido
        JLabel nome = new JLabel("Nome: ");
        nome.setBounds(10 , 50, 150, 50);
        JLabel email = new JLabel("E-mail: ");
        email.setBounds(10,80,150,50);
        JLabel senha = new JLabel("Senha: ");
        senha.setBounds(10,108, 150, 50);

        //campos de texto  para inserir os dados 
        
        JTextField campoNome = new JTextField(50);
        campoNome.setBounds(60, 65, 300, 20);
        JTextField campoEmail = new JTextField(50);
        campoEmail.setBounds(60, 93,300, 20);
        JTextField campoSenha = new JTextField(50);
        campoSenha.setBounds(60,125,300,20);
    


        //painel do cadastro

        JPanel painel = new JPanel();
        painel.setBorder(new TitledBorder("Cadastro Usuário"));
        painel.setLayout(null);
        painel.add(nome);
        painel.add(email);
        painel.add(campoEmail);
        painel.add(botaoInserir(usuario, campoNome, campoEmail,campoSenha, janelaPrincipal));
        painel.add(campoNome);
        painel.add(campoSenha);
        painel.add(senha);
        

        //o que esta na janela principal

        janelaPrincipal.add(painel);
        janelaPrincipal.setVisible(true);

    };

    //Funções de botões

    public static JButton  botaoInserir(Usuario usuario, JTextField campoNome, JTextField campoEmail, JTextField campoSenha, JFrame janelaPrincipal){
        
        JButton botaoInserir = new JButton("Inserir");
        botaoInserir.setBounds(150,180,80,30);
        botaoInserir.addActionListener(e -> {
            usuario.setNome(campoNome.getText());
            usuario.setEmail(campoEmail.getText());
            usuario.setSenha(campoSenha.getText());

            
            DaoUsuario daoUsuario = new DaoUsuario(conn);
            try {
                daoUsuario.inserir(usuario);
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            JOptionPane.showMessageDialog(janelaPrincipal, "Usuario: " + usuario.getNome() +
               "\nE-mail: " + usuario.getEmail() + "\nCadastrado com sucesso!");
        });
        
        return botaoInserir;
    }


    

    
    
    

}
