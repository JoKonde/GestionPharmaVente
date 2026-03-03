package gestionpharmavente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Accès aux données pour la table produit (sans prix_achat).
 */
public class ProduitDAO {

    public void ajouter(Produit p) throws SQLException {
        String sql = "INSERT INTO produit (nom, stock_actuel, stock_min, prix_vente) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getStockActuel());
            ps.setInt(3, p.getStockMin());
            ps.setDouble(4, p.getPrixVente());
            ps.executeUpdate();
        }
    }

    public void mettreAJour(Produit p) throws SQLException {
        String sql = "UPDATE produit SET nom = ?, stock_actuel = ?, stock_min = ?, prix_vente = ? WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getStockActuel());
            ps.setInt(3, p.getStockMin());
            ps.setDouble(4, p.getPrixVente());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        }
    }

    public void supprimerProduit(int idProduit) throws SQLException {
        String sql = "DELETE FROM produit WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idProduit);
            ps.executeUpdate();
        }
    }

    public Produit trouverParId(int id) throws SQLException {
        String sql = "SELECT id, nom, stock_actuel, stock_min, prix_vente FROM produit WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Produit p = new Produit();
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setStockActuel(rs.getInt("stock_actuel"));
                    p.setStockMin(rs.getInt("stock_min"));
                    p.setPrixVente(rs.getDouble("prix_vente"));
                    return p;
                }
            }
        }
        return null;
    }

    public List<Produit> trouverParNom(String nomRecherche) throws SQLException {
        String sql = "SELECT id, nom, stock_actuel, stock_min, prix_vente FROM produit WHERE nom LIKE ?";
        List<Produit> result = new ArrayList<>();
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nomRecherche + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produit p = new Produit();
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setStockActuel(rs.getInt("stock_actuel"));
                    p.setStockMin(rs.getInt("stock_min"));
                    p.setPrixVente(rs.getDouble("prix_vente"));
                    result.add(p);
                }
            }
        }
        return result;
    }

    public List<Produit> listerTous() throws SQLException {
        String sql = "SELECT id, nom, stock_actuel, stock_min, prix_vente FROM produit ORDER BY nom";
        List<Produit> result = new ArrayList<>();
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setStockActuel(rs.getInt("stock_actuel"));
                p.setStockMin(rs.getInt("stock_min"));
                p.setPrixVente(rs.getDouble("prix_vente"));
                result.add(p);
            }
        }
        return result;
    }

    /**
     * Ajoute deltaStock au stock actuel du produit.
     * Valeur positive = approvisionnement, négative = annulation.
     */
    public void mettreAJourStock(int idProduit, int deltaStock) throws SQLException {
        String sql = "UPDATE produit SET stock_actuel = stock_actuel + ? WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deltaStock);
            ps.setInt(2, idProduit);
            ps.executeUpdate();
        }
    }
}
