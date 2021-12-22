package Model;

import javax.persistence.*;

@Entity
public class telefones {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Integer ddd;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public telefones() {
    }

    public telefones(String numero, String tipo, Integer ddd) {
        this.numero = numero;
        this.tipo = tipo;
        this.ddd = ddd;
    }



}
