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
 * Accès aux données pour la table appro (en-têtes d'approvisionnement).
 */
public class ApproDAO {

    /**
     * Ajoute un approvisionnement et retourne l'id généré.
     */
    public int ajouter(Appro appro) throws SQLException {
        String sql = "INSERT INTO appro (date_appro, ref) VALUES (?, ?)";
        
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            Date d = appro.getDateAppro();
            ps.setTimestamp(1, new Timestamp(d.getTime()));
            ps.setString(2, appro.getRef());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void supprimerAppro(int idAppro) throws SQLException {
        String sql = "DELETE FROM appro WHERE id = ?";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idAppro);
            ps.executeUpdate();
        }
    }

    public List<Appro> listerTous() throws SQLException {
        String sql = "SELECT id, date_appro, ref FROM appro ORDER BY date_appro DESC";
        List<Appro> result = new ArrayList<>();
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Appro a = new Appro();
                a.setId(rs.getInt("id"));
                a.setDateAppro(new Date(rs.getTimestamp("date_appro").getTime()));
                a.setRef(rs.getString("ref"));
                result.add(a);
            }
        }
        return result;
    }
}

