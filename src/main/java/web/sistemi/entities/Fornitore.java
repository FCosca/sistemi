package web.sistemi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Fornitore {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sede;

    @Id
    @NotEmpty
    private String PIVA;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="RFOMP", joinColumns = {
            @JoinColumn(name ="Fornitore_PIVA", referencedColumnName = "PIVA")}, inverseJoinColumns = {
            @JoinColumn(name = "MATERIAPRIMA_CODICE", referencedColumnName = "codice")})
    private List<MateriaPrima> materiaPrima;


    public Fornitore(String nome, String sede, String piva) {
        this.nome = nome;
        this.sede = sede;
        this.PIVA = piva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPIVA() {
        return PIVA;
    }

    public void setPIVA(String PIVA) {
        this.PIVA = PIVA;
    }

    public Fornitore(){

    }
}
