package web.sistemi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Fornitore {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String sede;

    @Id
    @NotEmpty
    private String PIVA;

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
