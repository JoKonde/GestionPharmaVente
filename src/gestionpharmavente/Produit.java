package gestionpharmavente;

/**
 * Représente un produit pharmaceutique dans la base.
 */
public class Produit {

    private int id;
    private String nom;
    private int stockActuel;
    private int stockMin;
    // Prix de vente unitaire TTC (ou autre convention métier)
    private double prixVente;

    public Produit() {
    }

    public Produit(int id, String nom, int stockActuel, int stockMin, double prixVente) {
        this.id = id;
        this.nom = nom;
        this.stockActuel = stockActuel;
        this.stockMin = stockMin;
        this.prixVente = prixVente;
    }

    public Produit(String nom, int stockActuel, int stockMin, double prixVente) {
        this.nom = nom;
        this.stockActuel = stockActuel;
        this.stockMin = stockMin;
        this.prixVente = prixVente;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getStockActuel() { return stockActuel; }
    public void setStockActuel(int stockActuel) { this.stockActuel = stockActuel; }

    public int getStockMin() { return stockMin; }
    public void setStockMin(int stockMin) { this.stockMin = stockMin; }

    public double getPrixVente() { return prixVente; }
    public void setPrixVente(double prixVente) { this.prixVente = prixVente; }
}
