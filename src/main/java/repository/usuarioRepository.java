package repository;


import Model.Usuario;
import config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioRepository {

    public List<Usuario> list(){
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar consulta SQL.
            String sql = "SELECT * FROM usuario ";

            //Prepapar statement com os parâmentros recebidos
            PreparedStatement psmt = conn.prepareStatement(sql);
            //executa consulta e armazena o retorno
            ResultSet rs = psmt.executeQuery();

            //Cria um objeto usuario e guarda na lista de usuarios
            while(rs.next()){

                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String email = rs.getString("email");
                        String senha = rs.getString("senha");
                        String telefones = rs.getString("telefone_id");

                usuarios.add(new Usuario(
                        id,
                        nome,
                        email,
                        senha,
                        telefones
                ));


            }

        } catch (Exception e) {
            System.out.println("Listagem de usuarios Falhou!");
            e.printStackTrace();
        }

        return usuarios;
    }

    public Usuario getById(int id){

        Usuario usuario = new Usuario();

        try(Connection conn = ConnectionFactory.getConnection()){
            //Preparar consulta SQL
            String sql = "SELECT * FROM usuario WHERE id = ?";

            //Preparar statement com os parâmetros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs".
            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
//                usuario.setTelefones();
            }


        } catch (SQLException e) {
            System.out.println("Listagem de Usuario FALHOU!");
            e.printStackTrace();
        }


        return  usuario;
    }
}
