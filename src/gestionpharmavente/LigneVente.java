package gestionpharmavente;

/**
 * Représente une ligne de vente (détail).
 */
public class LigneVente {

    private int id;
    private int idVente;
    private int idProd;
    private int qte;
    private double prixVente;

    public LigneVente() {
    }

    public LigneVente(int idVente, int idProd, int qte, double prixVente) {
        this.idVente = idVente;
        this.idProd = idProd;
        this.qte = qte;
        this.prixVente = prixVente;
    }

    public LigneVente(int id, int idVente, int idProd, int qte, double prixVente) {
        this.id = id;
        this.idVente = idVente;
        this.idProd = idProd;
        this.qte = qte;
        this.prixVente = prixVente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVente() {
        return idVente;
    }

    public void setIdVente(int idVente) {
        this.idVente = idVente;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }
}

