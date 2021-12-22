package Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class usuario {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;

    @ManyToOne
    @JoinColumn(name = "Telefones", referencedColumnName = "id")
    private List<Model.telefones> telefones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Model.telefones> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Model.telefones> telefones) {
        this.telefones = telefones;
    }

    public usuario() {
    }

    public usuario(String nome, String email, String senha, List<Model.telefones> telefones) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefones = telefones;
    }
}
