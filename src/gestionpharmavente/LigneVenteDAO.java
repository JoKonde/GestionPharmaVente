package gestionpharmavente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Accès aux données pour la table ligne_vente.
 */
public class LigneVenteDAO {

    public void ajouter(LigneVente l) throws SQLException {
        String sql = "INSERT INTO ligne_vente (id_vente, id_prod, qte, prix_vente) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, l.getIdVente());
            ps.setInt(2, l.getIdProd());
            ps.setInt(3, l.getQte());
            ps.setDouble(4, l.getPrixVente());
            ps.executeUpdate();
        }
    }

    public List<LigneVente> listerParVente(int idVente) throws SQLException {
        String sql = "SELECT id, id_vente, id_prod, qte, prix_vente FROM ligne_vente WHERE id_vente = ?";
        List<LigneVente> result = new ArrayList<>();
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVente);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LigneVente l = new LigneVente(
                            rs.getInt("id"),
                            rs.getInt("id_vente"),
                            rs.getInt("id_prod"),
                            rs.getInt("qte"),
                            rs.getDouble("prix_vente")
                    );
                    result.add(l);
                }
            }
        }
        return result;
    }
}

