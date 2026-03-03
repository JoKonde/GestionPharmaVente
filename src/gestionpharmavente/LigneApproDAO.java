package gestionpharmavente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Accès aux données pour la table ligne_appro.
 * Inclut la date d'expiration du produit approvisionné.
 */
public class LigneApproDAO {

    public void ajouter(LigneAppro l) throws SQLException {
        String sql = "INSERT INTO ligne_appro (id_appro, id_prod, qte, prix_achat, date_expiration) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, l.getIdAppro());
            ps.setInt(2, l.getIdProd());
            ps.setInt(3, l.getQte());
            ps.setDouble(4, l.getPrixAchat());
            // date_expiration peut être null si non saisie
            if (l.getDateExpiration() != null && !l.getDateExpiration().isEmpty()) {
                ps.setDate(5, java.sql.Date.valueOf(l.getDateExpiration()));
            } else {
                ps.setNull(5, java.sql.Types.DATE);
            }
            ps.executeUpdate();
        }
    }

    public void supprimerLigne(int idLigne) throws SQLException {
        String sql = "DELETE FROM ligne_appro WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idLigne);
            ps.executeUpdate();
        }
    }

    public List<LigneAppro> listerParAppro(int idAppro) throws SQLException {
        String sql = "SELECT id, id_appro, id_prod, qte, prix_achat, date_expiration FROM ligne_appro WHERE id_appro = ?";
        List<LigneAppro> result = new ArrayList<>();
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAppro);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LigneAppro l = new LigneAppro();
                    l.setId(rs.getInt("id"));
                    l.setIdAppro(rs.getInt("id_appro"));
                    l.setIdProd(rs.getInt("id_prod"));
                    l.setQte(rs.getInt("qte"));
                    l.setPrixAchat(rs.getDouble("prix_achat"));
                    java.sql.Date d = rs.getDate("date_expiration");
                    l.setDateExpiration(d != null ? d.toString() : "");
                    result.add(l);
                }
            }
        }
        return result;
    }
}
