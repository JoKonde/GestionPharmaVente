package gestionpharmavente;

import java.util.Date;

/**
 * Représente un approvisionnement (en-tête).
 */
public class Appro {

    private int id;
    private Date dateAppro;
    private String ref;

    public Appro() {
    }

    public Appro(int id, Date dateAppro, String ref) {
        this.id = id;
        this.dateAppro = dateAppro;
        this.ref = ref;
    }

    public Appro(Date dateAppro, String ref) {
        this.dateAppro = dateAppro;
        this.ref = ref;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAppro() {
        return dateAppro;
    }

    public void setDateAppro(Date dateAppro) {
        this.dateAppro = dateAppro;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}

