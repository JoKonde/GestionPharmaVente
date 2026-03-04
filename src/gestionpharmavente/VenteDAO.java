package gestionpharmavente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Accès aux données pour la table vente.
 */
public class VenteDAO {

    public int ajouter(Vente v) throws SQLException {
        String sql = "INSERT INTO vente (date_vente, ref) VALUES (?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setTimestamp(1, new Timestamp(v.getDateVente().getTime()));
            ps.setString(2, v.getRef());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public List<Vente> listerTous() throws SQLException {
        String sql = "SELECT id, date_vente, ref FROM vente ORDER BY date_vente DESC";
        List<Vente> result = new ArrayList<>();
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Date d = new Date(rs.getTimestamp("date_vente").getTime());
                String ref = rs.getString("ref");
                result.add(new Vente(id, d, ref));
            }
        }
        return result;
    }

    public void supprimerVente(int idVente) throws SQLException {
        String sql = "DELETE FROM vente WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idVente);
            ps.executeUpdate();
        }
    }
}

