package Model;

import javax.persistence.*;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "telefone_id")
    private Telefones telefones;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Telefones getTelefones() {
        return telefones;
    }

    public void setTelefones(Telefones telefones) {
        this.telefones = telefones;
    }

    public Usuario() {
    }



    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String email, String senha, String telefones) {
    }

    public Usuario(String nome, String email, String senha, Telefones telefones) {

        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefones + '\'' +
                '}';
    }
}
