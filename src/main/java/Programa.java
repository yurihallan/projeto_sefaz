import Model.Telefones;
import Model.Usuario;
import repository.usuarioRepository;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Programa {
    public static void main(String[] args) {

//        usuarioRepository usuarioDAO = new usuarioRepository();
//
//        List<Usuario> usuarios = usuarioDAO.list();
//
//        usuarios.stream().forEach(System.out::println);



        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sefaz-projeto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // criar instancias
        Telefones telefonesAdd = new Telefones("98555212","celular",92);
        Usuario usuarioAdd = new Usuario("Pedro","pedro@gmail.com","1345545",telefonesAdd);

        // iniciar uma transação para adicionar
        entityManager.getTransaction().begin();

        //persiste os dados
        entityManager.persist(telefonesAdd);
        entityManager.persist(usuarioAdd);

        // commit/ Finaliza uma transação, persistindo os dados
        entityManager.getTransaction().commit();



        //consulta dos dados
        Usuario findUsers = entityManager.find(Usuario.class,1);

        System.out.println(findUsers);


        //Fecha as conexão das entity
        entityManager.close();
        entityManagerFactory.close();
    }
}
