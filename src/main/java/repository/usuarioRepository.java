package repository;


import Model.Usuario;
import config.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuarioRepository {

    public List<Usuario> list(){
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection()) {

            //Preparar consulta SQL.
            String sql = "SELECT u.id, " +
                    "            u.nome, u.email, u.senha " +
                    "       FROM usuario u";

            //Prepapar statement com os parâmentros recebidos
            PreparedStatement psmt = conn.prepareStatement("select * from usuario");
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


//                usuarios.add(usuario);


            }

        } catch (Exception e) {
            System.out.println("Listagem de usuarios Falhou!");
            e.printStackTrace();
        }

        return usuarios;
    }
}
