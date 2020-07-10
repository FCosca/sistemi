package web.sistemi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Fornitore {

    @NotEmpty
    private String Nome;

    @NotEmpty
    private String sede;

    @Id
    @NotEmpty
    private String PIVA;

    public Fornitore(String nome, String sede, String piva) {
        this.Nome = nome;
        this.sede = sede;
        this.PIVA = piva;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
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
