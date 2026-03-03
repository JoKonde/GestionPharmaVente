package gestionpharmavente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Gère la connexion à MySQL et l'initialisation automatique
 * de la base de données et des tables au démarrage.
 */
public class ConnexionDB {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;

    // Base dédiée au projet GestionPharmaVente pour ne pas mélanger avec GestionPharma
    private static final String DB_NAME = "gestionpharmavente";
    private static final String URL_SERVER = "jdbc:mysql://" + HOST + ":" + PORT + "/";
    private static final String URL_DB = URL_SERVER + DB_NAME;

    public static void initializeDatabase() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver MySQL introuvable.", ex);
        }
        createDatabaseIfNotExists();
        createTablesIfNotExists();
        migrateTablesIfNeeded();
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL_DB, USER, PASSWORD);
    }

    private static void createDatabaseIfNotExists() throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL_SERVER, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
        }
    }

    private static void createTablesIfNotExists() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Table produit avec prix_vente (le prix d'achat est géré dans ligne_appro)
            String createProduit = "CREATE TABLE IF NOT EXISTS produit ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "nom VARCHAR(150) NOT NULL,"
                    + "stock_actuel INT NOT NULL DEFAULT 0,"
                    + "stock_min INT NOT NULL DEFAULT 0,"
                    + "prix_vente DECIMAL(10,2) NOT NULL DEFAULT 0"
                    + ") ENGINE=InnoDB";

            String createAppro = "CREATE TABLE IF NOT EXISTS appro ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "date_appro DATETIME NOT NULL,"
                    + "ref VARCHAR(100) NULL"
                    + ") ENGINE=InnoDB";

            // Table ligne_appro avec date_expiration et prix_achat
            String createLigneAppro = "CREATE TABLE IF NOT EXISTS ligne_appro ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "id_appro INT NOT NULL,"
                    + "id_prod INT NOT NULL,"
                    + "qte INT NOT NULL,"
                    + "prix_achat DECIMAL(10,2) NOT NULL,"
                    + "date_expiration DATE NULL,"
                    + "CONSTRAINT fk_ligne_appro_appro FOREIGN KEY (id_appro) "
                    + "REFERENCES appro(id) ON DELETE CASCADE,"
                    + "CONSTRAINT fk_ligne_appro_produit FOREIGN KEY (id_prod) "
                    + "REFERENCES produit(id) ON DELETE CASCADE"
                    + ") ENGINE=InnoDB";

            stmt.executeUpdate(createProduit);
            stmt.executeUpdate(createAppro);
            stmt.executeUpdate(createLigneAppro);
        }
    }

    /**
     * Applique les migrations nécessaires sur les tables existantes:
     * - Supprime la colonne prix_achat de produit si elle existe encore.
     * - Ajoute la colonne date_expiration dans ligne_appro si elle n'existe pas encore.
     */
    private static void migrateTablesIfNeeded() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            // Supprime prix_achat de produit si elle existe encore (héritage de l'ancien schéma)
            try {
                stmt.executeUpdate("ALTER TABLE produit DROP COLUMN prix_achat");
            } catch (SQLException ignored) {
                // La colonne n'existe pas ou a déjà été supprimée: on ignore
            }

            // Ajoute prix_vente dans produit si elle n'existe pas encore
            try {
                stmt.executeUpdate("ALTER TABLE produit ADD COLUMN prix_vente DECIMAL(10,2) NOT NULL DEFAULT 0");
            } catch (SQLException ignored) {
                // La colonne existe déjà: on ignore
            }

            // Ajoute date_expiration dans ligne_appro si elle n'existe pas encore
            try {
                stmt.executeUpdate("ALTER TABLE ligne_appro ADD COLUMN date_expiration DATE NULL");
            } catch (SQLException ignored) {
                // La colonne existe déjà: on ignore
            }
        }
    }
}
