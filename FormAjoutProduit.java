import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class FormAjoutProduit extends JFrame {

    public FormAjoutProduit(StockManager stock) {

        setTitle("Ajout de produit");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        int fieldHeight = 30;

        // Création des champs
        JTextField idField = createTextField(fieldHeight);
        JTextField nomField = createTextField(fieldHeight);
        JTextField quantiteField = createTextField(fieldHeight);
        JTextField prixField = createTextField(fieldHeight);
        JTextField prixVenteField = createTextField(fieldHeight);
        JTextField champSpecifique = createTextField(fieldHeight);

        String[] types = {"Alimentaire", "Vestimentaire", "Électronique"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        typeBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, fieldHeight));

        JLabel labelSpecifique = new JLabel("Date d'expiration (YYYY-MM-DD):");

        // Ajout des composants
        panel.add(createLabeledField("Id:", idField));
        panel.add(createLabeledField("Nom:", nomField));
        panel.add(createLabeledField("Quantité:", quantiteField));
        panel.add(createLabeledField("Prix d'achat:", prixField));
        panel.add(createLabeledField("Prix de vente:", prixVenteField));
        panel.add(createLabeledField("Type de produit:", typeBox));
        panel.add(createLabeledField(labelSpecifique, champSpecifique));

        // Listener pour changer le champ spécifique
        typeBox.addActionListener(e -> {
            String type = (String) typeBox.getSelectedItem();
            switch (type) {
                case "Alimentaire" -> labelSpecifique.setText("Date d'expiration (YYYY-MM-DD):");
                case "Vestimentaire" -> labelSpecifique.setText("Taille:");
                case "Électronique" -> labelSpecifique.setText("Durée de garantie (mois):");
            }
        });

        // Bouton valider
        JButton valider = new JButton("Ajouter");
        valider.setAlignmentX(Component.CENTER_ALIGNMENT);
        valider.addActionListener(e -> {
            // Vérification des champs vides
            if (idField.getText().isEmpty() || nomField.getText().isEmpty() ||
                quantiteField.getText().isEmpty() || prixField.getText().isEmpty() ||
                prixVenteField.getText().isEmpty() || champSpecifique.getText().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
                return;
            }

            try {
                int id = Integer.parseInt(idField.getText());
                if (stock.idExiste(id)) {
                    JOptionPane.showMessageDialog(this, "L'ID existe déjà !");
                    return;
                }

                String nom = nomField.getText();
                int quantite = Integer.parseInt(quantiteField.getText());
                double prix = Double.parseDouble(prixField.getText());
                double prixVente = Double.parseDouble(prixVenteField.getText());
                String type = (String) typeBox.getSelectedItem();
                String spec = champSpecifique.getText();

                switch (type) {
                    case "Alimentaire" -> {
                        try {
                            LocalDate date = LocalDate.parse(spec);
                            stock.ajouterProduit(new ProduitAlimentaire(id, nom, type, quantite, prix, prixVente, date));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, "Date invalide (format attendu : YYYY-MM-DD)");
                            return;
                        }
                    }
                    case "Vestimentaire" -> {
                        if (spec.isBlank()) {
                            JOptionPane.showMessageDialog(this, "Veuillez indiquer une taille.");
                            return;
                        }
                        stock.ajouterProduit(new ProduitVestimentaire(id, nom, type, quantite, prix, prixVente, spec, null, null));
                    }
                    case "Électronique" -> {
                        try {
                            int garantie = Integer.parseInt(spec);
                            stock.ajouterProduit(new ProduitElectronique(id, nom, type, quantite, prix, prixVente, garantie, null));
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Durée de garantie invalide !");
                            return;
                        }
                    }
                }

                JOptionPane.showMessageDialog(this, "Produit ajouté !");
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer des valeurs numériques valides !");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(valider);

        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel createLabeledField(String label, JComponent field) {
        return createLabeledField(new JLabel(label), field);
    }

    private JPanel createLabeledField(JLabel label, JComponent field) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        p.add(label);
        p.add(Box.createVerticalStrut(5));
        p.add(field);
        p.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return p;
    }

    private JTextField createTextField(int height) {
        JTextField tf = new JTextField();
        tf.setMaximumSize(new Dimension(Integer.MAX_VALUE, height));
        return tf;
    }
}
