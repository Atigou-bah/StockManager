import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class FormVente extends JFrame {

    public FormVente(HistoriqueVente historique, StockManager stock) {
        setTitle("Vente de Produit");
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // === FORMULAIRE AVEC GRIDBAGLAYOUT ===
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Champs
        JTextField idField = new JTextField(15);
        JTextField quantiteField = new JTextField(15);

        // Ligne 1 : ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Id :"), gbc);
        gbc.gridx = 1;
        formPanel.add(idField, gbc);

        // Ligne 2 : Quantité
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Quantité :"), gbc);
        gbc.gridx = 1;
        formPanel.add(quantiteField, gbc);

        // === BOUTONS ===
        JButton valider = new JButton("Vendre");
        JButton annuler = new JButton("Annuler");

        JPanel boutonPanel = new JPanel();
        boutonPanel.add(valider);
        boutonPanel.add(annuler);

        // Action bouton Annuler
        annuler.addActionListener(e -> dispose());

        // Action bouton Vendre
        valider.addActionListener(e -> {
            if (idField.getText().isEmpty() || quantiteField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
                return;
            }

            try {
                int id = Integer.parseInt(idField.getText());
                int quantite = Integer.parseInt(quantiteField.getText());

                if (!stock.idExiste(id)) {
                    JOptionPane.showMessageDialog(this, "Produit non trouvé !");
                    return;
                }

                Produit p = stock.chercherProduit(id);

                if (quantite >= p.getQuantite()) {
                    // Vente de toute la quantité disponible
                    Vente v = new Vente(p, p.getQuantite(), LocalDate.now());
                    historique.ajouterVente(v);
                    stock.supprimerProduit(id);
                    JOptionPane.showMessageDialog(this, "Produit épuisé. Quantité vendue : " + p.getQuantite());
                } else {
                    // Vente partielle
                    p.setQuantite(p.getQuantite() - quantite);
                    Vente v = new Vente(p, quantite, LocalDate.now());
                    historique.ajouterVente(v);
                    JOptionPane.showMessageDialog(this, "Vente effectuée. Quantité vendue : " + quantite);
                }

                dispose(); // Fermer la fenêtre après vente

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des nombres valides !");
            }
        });

        // === STRUCTURE FINALE ===
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(formPanel, BorderLayout.CENTER);
        getContentPane().add(boutonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
