package gestionpharmavente;

/**
 * Représente une ligne d'approvisionnement.
 * Contient le produit, la quantité, le prix d'achat et la date d'expiration.
 */
public class LigneAppro {

    private int id;
    private int idAppro;
    private int idProd;
    private int qte;
    private double prixAchat;
    private String dateExpiration; // format "yyyy-MM-dd" ou null si non renseignée

    public LigneAppro() {
    }

    public LigneAppro(int idAppro, int idProd, int qte, double prixAchat, String dateExpiration) {
        this.idAppro = idAppro;
        this.idProd = idProd;
        this.qte = qte;
        this.prixAchat = prixAchat;
        this.dateExpiration = dateExpiration;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdAppro() { return idAppro; }
    public void setIdAppro(int idAppro) { this.idAppro = idAppro; }

    public int getIdProd() { return idProd; }
    public void setIdProd(int idProd) { this.idProd = idProd; }

    public int getQte() { return qte; }
    public void setQte(int qte) { this.qte = qte; }

    public double getPrixAchat() { return prixAchat; }
    public void setPrixAchat(double prixAchat) { this.prixAchat = prixAchat; }

    public String getDateExpiration() { return dateExpiration; }
    public void setDateExpiration(String dateExpiration) { this.dateExpiration = dateExpiration; }
}
