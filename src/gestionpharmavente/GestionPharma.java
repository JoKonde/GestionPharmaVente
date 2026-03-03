/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestionpharmavente;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JEM'S KABE FILM
 */
public class GestionPharma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Initialise la base de données et les tables si nécessaire
            ConnexionDB.initializeDatabase();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
                    "Erreur lors de l'initialisation de la base de données, veuillez demarrer le serveur de base de données.",
                    "Erreur base de données",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lance ensuite la fenêtre de chargement
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Acceuil().setVisible(true);
                new Chargement().setVisible(true);
            }
        });
    }
    
}
