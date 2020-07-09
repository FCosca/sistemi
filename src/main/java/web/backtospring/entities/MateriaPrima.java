package web.backtospring.entities;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class MateriaPrima {

    @Id
    @NotEmpty
    private Integer Codice;

    @NotEmpty
    private String Descrizione;

    @NotEmpty
    private Integer Disponibilita;

    @NotEmpty
    private String Magazzino;


    public MateriaPrima(Integer codice, String descrizione, Integer disponibilita, String magazzino) {
        this.Codice = codice;
        this.Descrizione = descrizione;
        this.Disponibilita = disponibilita;
        this.Magazzino = magazzino;
    }


    public Integer getCodice() {
        return Codice;
    }

    public void setCodice(Integer codice) {
        Codice = codice;
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
}
