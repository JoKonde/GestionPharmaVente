package gestionpharmavente;

import java.util.Date;

/**
 * Représente une vente (en-tête).
 */
public class Vente {

    private int id;
    private Date dateVente;
    private String ref;

    public Vente() {
    }

    public Vente(Date dateVente, String ref) {
        this.dateVente = dateVente;
        this.ref = ref;
    }

    public Vente(int id, Date dateVente, String ref) {
        this.id = id;
        this.dateVente = dateVente;
        this.ref = ref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}

