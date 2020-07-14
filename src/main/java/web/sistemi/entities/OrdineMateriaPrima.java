package web.sistemi.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class OrdineMateriaPrima {

    @Id
    @NotNull
    private Integer codice;

    @NotEmpty
    private String descrizione;

    @NotNull
    private Integer quantita;


    public OrdineMateriaPrima(Integer codice, String descrizione, Integer quantita) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.quantita = quantita;
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

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }



    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "ORDINE_MATERIAPRIMA",
            joinColumns = {@JoinColumn(name = "ORDINEMATERIAPRIMA_CODICE")},
            inverseJoinColumns = {@JoinColumn(name = "MATERIAPRIMA_CODICE")})
    private List<MateriaPrima> materiaPrima;

    @OneToMany(mappedBy = "ordineMateriaPrima")
    private List<Fornitore> fornitore;

    public OrdineMateriaPrima(){}
}
