package control;

import Model.Usuario;
import repository.usuarioRepository;

import java.util.List;

public class UsuarioControl {

    public void list(){

        usuarioRepository usuarioDAO = new usuarioRepository();

        List<Usuario> usuarios = usuarioDAO.list();

//         usuarios.stream().forEach(System.out::println);

    }
}
