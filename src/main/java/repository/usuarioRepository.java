package repository;


import Model.usuario;
import config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuarioRepository {

    public List<usuario> list(){
        List<usuario> usuarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar consulta SQL.
            String sql = "SELECT * FROM usuario";

            //Prepapar statement com os parâmentros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            //executa consulta e armazena o retorno
            ResultSet rs = stmt.executeQuery();

            //Cria um objeto aluno e guarda na lista de alunos
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

//                alunos.add(new Aluno(
//                    id,
//                    nome,
//                    email,
//                    senha
//                ));
            }

        } catch (Exception e) {
            System.out.println("Listagem de usuarios Falhou!");
            e.printStackTrace();
        }

        return usuarios;
    }
}
