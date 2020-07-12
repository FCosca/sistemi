package web.sistemi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class MateriaPrima {

    @Id
    @NotEmpty
    private Integer codice;

    @NotEmpty
    private String Descrizione;

    @NotEmpty
    private Integer Disponibilita;

    @NotEmpty
    private String Magazzino;


    public MateriaPrima(Integer codice, String descrizione, Integer disponibilita, String magazzino) {
        this.codice = codice;
        this.Descrizione = descrizione;
        this.Disponibilita = disponibilita;
        this.Magazzino = magazzino;
    }


    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        codice = codice;
    }

    public String getDescrizione() {
        return Descrizione;
    }

    public void setDescrizione(String descrizione) {
        Descrizione = descrizione;
    }

    public Integer getDisponibilita() {
        return Disponibilita;
    }

    public void setDisponibilita(Integer disponibilita) {
        Disponibilita = disponibilita;
    }

    public String getMagazzino() {
        return Magazzino;
    }

    public void setMagazzino(String magazzino) {
        Magazzino = magazzino;
    }

    public MateriaPrima(){}
}
