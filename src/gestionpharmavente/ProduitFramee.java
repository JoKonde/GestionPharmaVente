/*
 * Fenêtre de gestion des produits (form créé par l'utilisateur, logique branchée comme ProduitFrame).
 */
package gestionpharmavente;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Gestion des produits : CRUD avec tableau, champs ID, Nom, Stock actuel (lecture seule), Stock min.
 */
public class ProduitFramee extends javax.swing.JFrame {

    private final ProduitDAO produitDAO = new ProduitDAO();

    public ProduitFramee() {
        initComponents();
        setLocationRelativeTo(null);
        chargerTableProduits();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduits = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtStockActuel = new javax.swing.JTextField();
        txtStockMin = new javax.swing.JTextField();
        jLabelPrixVente = new javax.swing.JLabel();
        txtPrixVente = new javax.swing.JTextField();
        btnNouveau = new javax.swing.JButton();
        btnEnregistrer = new javax.swing.JButton();
        btnSupprimer = new javax.swing.JButton();
        btnRafraichir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion des produits");

        tableProduits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Stock actuel", "Stock min", "Prix vente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProduitsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduits);

        jLabel1.setText("ID :");

        jLabel2.setText("Nom :");

        jLabel3.setText("Stock actuel :");

        jLabel4.setText("Stock min :");

        jLabel6.setText("(stock actuel alimenté par les approvisionnements)");

        txtId.setEditable(false);

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        txtStockActuel.setEditable(false);
        txtStockActuel.setText("0");

        jLabelPrixVente.setText("Prix vente :");

        btnNouveau.setText("Nouveau");
        btnNouveau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNouveauMouseClicked(evt);
            }
        });

        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnregistrerMouseClicked(evt);
            }
        });

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupprimerMouseClicked(evt);
            }
        });

        btnRafraichir.setText("Rafraîchir");
        btnRafraichir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRafraichirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNouveau)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnregistrer)
                                .addGap(40, 40, 40)
                                .addComponent(btnSupprimer)
                                .addGap(26, 26, 26)
                                .addComponent(btnRafraichir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStockMin)
                                    .addComponent(txtStockActuel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                                .addGap(112, 112, 112)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 907, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStockActuel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNouveau)
                    .addComponent(btnEnregistrer)
                    .addComponent(btnSupprimer)
                    .addComponent(btnRafraichir))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chargerTableProduits() {
        try {
            List<Produit> produits = produitDAO.listerTous();
            DefaultTableModel model = (DefaultTableModel) tableProduits.getModel();
            model.setRowCount(0);
            for (Produit p : produits) {
                model.addRow(new Object[]{
                    p.getId(), p.getNom(), p.getStockActuel(), p.getStockMin(), p.getPrixVente()
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur chargement produits : " + ex.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viderChamps() {
        txtId.setText("");
        txtNom.setText("");
        txtStockActuel.setText("0");
        txtStockMin.setText("");
        txtPrixVente.setText("");
    }

    private void tableProduitsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProduitsMouseClicked
        int row = tableProduits.getSelectedRow();
        if (row >= 0) {
            txtId.setText(tableProduits.getValueAt(row, 0).toString());
            txtNom.setText(tableProduits.getValueAt(row, 1).toString());
            txtStockActuel.setText(tableProduits.getValueAt(row, 2).toString());
            txtStockMin.setText(tableProduits.getValueAt(row, 3).toString());
            txtPrixVente.setText(tableProduits.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_tableProduitsMouseClicked

    private void btnNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauActionPerformed
        //viderChamps();
    }//GEN-LAST:event_btnNouveauActionPerformed

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
        
    }//GEN-LAST:event_btnSupprimerActionPerformed

    private void btnRafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRafraichirActionPerformed
        
    }//GEN-LAST:event_btnRafraichirActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void btnNouveauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauMouseClicked
        // TODO add your handling code here:
        viderChamps();
    }//GEN-LAST:event_btnNouveauMouseClicked

    private void btnEnregistrerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnregistrerMouseClicked
        // TODO add your handling code here:
        String nom = txtNom.getText().trim();
        String stockMinTxt = txtStockMin.getText().trim();
        String prixVenteTxt = txtPrixVente.getText().trim();
        if (nom.isEmpty() || stockMinTxt.isEmpty() || prixVenteTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir le nom, le stock minimum et le prix de vente.",
                    "Champs manquants", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            int stockMin = Integer.parseInt(stockMinTxt);
            int stockActuel = txtStockActuel.getText().trim().isEmpty() ? 0
                    : Integer.parseInt(txtStockActuel.getText().trim());

            double prixVente = Double.parseDouble(prixVenteTxt.replace(',', '.'));

            Produit p = new Produit(nom, stockActuel, stockMin, prixVente);
            String idTxt = txtId.getText().trim();
            if (idTxt.isEmpty()) {
                produitDAO.ajouter(p);
                JOptionPane.showMessageDialog(this, "Produit ajouté avec succès.");
            } else {
                p.setId(Integer.parseInt(idTxt));
                produitDAO.mettreAJour(p);
                JOptionPane.showMessageDialog(this, "Produit mis à jour avec succès.");
            }
            chargerTableProduits();
            viderChamps();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vérifiez les valeurs numériques (stock, prix de vente).",
                    "Erreur de saisie", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement : " + ex.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEnregistrerMouseClicked

    private void btnSupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupprimerMouseClicked
        // TODO add your handling code here:
        String idTxt = txtId.getText().trim();
        if (idTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sélectionnez d'abord un produit dans le tableau.",
                    "Aucun produit sélectionné", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this,
                "Supprimer ce produit ? Toutes les lignes d'appro correspondantes seront aussi supprimées (cascade).",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;
        try {
            produitDAO.supprimerProduit(Integer.parseInt(idTxt));
            chargerTableProduits();
            viderChamps();
            JOptionPane.showMessageDialog(this, "Produit supprimé.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur lors de la suppression : " + ex.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSupprimerMouseClicked

    private void btnRafraichirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRafraichirMouseClicked
        // TODO add your handling code here:
        chargerTableProduits();
    }//GEN-LAST:event_btnRafraichirMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JButton btnNouveau;
    private javax.swing.JButton btnRafraichir;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelPrixVente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableProduits;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrixVente;
    private javax.swing.JTextField txtStockActuel;
    private javax.swing.JTextField txtStockMin;
    // End of variables declaration//GEN-END:variables
}
