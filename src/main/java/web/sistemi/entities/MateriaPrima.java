package web.sistemi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class MateriaPrima {

    @Id
    @NotEmpty
    private Integer codice;

    @NotEmpty
    private String descrizione;

    @NotEmpty
    private Integer disponibilita;

    @NotEmpty
    private String magazzino;

    @ManyToMany(mappedBy = "materiaPrima")
    private List<Fornitore> fornitore;

    @ManyToMany(mappedBy = "materiaPrima")
    private List<OrdineMateriaPrima> ordineMateriaPrima;


    public List<Fornitore> getFornitore() {
        return fornitore;
    }

    public List<OrdineMateriaPrima> getOrdineMateriaPrima() {
        return ordineMateriaPrima;
    }
    public void setFornitore(List<Fornitore> fornitore){this.fornitore = fornitore;}

    public MateriaPrima(Integer codice, String descrizione, Integer disponibilita, String magazzino){
        this.codice = codice;
        this.descrizione = descrizione;
        this.disponibilita = disponibilita;
        this.magazzino = magazzino;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(Integer disponibilita) {
        this.disponibilita = disponibilita;
    }

    public String getMagazzino() {
        return magazzino;
    }

    public void setMagazzino(String magazzino) {
        this.magazzino = magazzino;
    }

    public MateriaPrima(){}
}
