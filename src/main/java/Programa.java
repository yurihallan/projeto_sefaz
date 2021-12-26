import Model.Telefones;
import Model.Usuario;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Programa {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sefaz-projeto");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // criar instancias
        Telefones telefonesAdd = new Telefones("98555212","celular",92);
        Usuario usuarioAdd = new Usuario("Jose","pedro@gmail.com","1345545",telefonesAdd);

        Telefones telefonesAdd2 = new Telefones("98555212","Telefone",11);
        Usuario usuarioAdd2 = new Usuario("Sara","Sara@gmail.com","08200121515",telefonesAdd2);

        // iniciar uma transação para adicionar
        entityManager.getTransaction().begin();

        //persiste os dados
        entityManager.persist(telefonesAdd);
        entityManager.persist(usuarioAdd);
        entityManager.persist(telefonesAdd2);
        entityManager.persist(usuarioAdd2);

        // commit/Finaliza uma transação, persistindo os dados
        entityManager.getTransaction().commit();


      //  Trazendo somente 1 resultado
        Usuario findUsers = entityManager.find(Usuario.class,2);

        System.out.println(findUsers);



        //Trazendo uma lista dos dados
        String sqList = "SELECT * from Usuario";
        List<Usuario> usuarioList = entityManager.createNativeQuery(sqList,Usuario.class).getResultList();
        usuarioList.forEach(usuario -> System.out.println("Lista -> "+ usuario));



//        Alterar os dados
        entityManager.getTransaction().begin();

        findUsers.setNome("Fernanda");
        findUsers.setEmail("Fernanda@gmail.com");

        entityManager.getTransaction().commit();
        System.out.println(findUsers);


        //Remover um dado
        entityManager.getTransaction().begin();

        entityManager.remove(findUsers);

        entityManager.getTransaction().commit();

        //Listando todos os dados do banco depois de remover um dado
        String sqList2 = "SELECT * from Usuario";
        List<Usuario> usuarioListAtual = entityManager.createNativeQuery(sqList2,Usuario.class).getResultList();
        usuarioListAtual.forEach(usuario -> System.out.println("Lista -> "+ usuario));


        //Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();
    }
}
