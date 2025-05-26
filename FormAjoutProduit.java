import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class FormAjoutProduit extends JFrame {
    
    public FormAjoutProduit(StockManager stock){

        setTitle("Ajout de produit");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 10, 10));

        // Champs communs
        JTextField idField = new JTextField();
        JTextField nomField = new JTextField();
        JTextField quantiteField = new JTextField();
        JTextField prixField = new JTextField();
        JTextField prixVenteField= new JTextField();

        // Type de produit
        String[] types = {"Alimentaire", "Vestimentaire", "Électronique"};
        JComboBox<String> typeBox = new JComboBox<>(types);

        // Champs spécifiques
        JTextField champSpecifique = new JTextField();

        panel.add(new JLabel("Id:"));
        panel.add(idField);

        panel.add(new JLabel("Nom:"));
        panel.add(nomField);

        panel.add(new JLabel("Quantité:"));
        panel.add(quantiteField);

        panel.add(new JLabel("Prix Achat:"));
        panel.add(prixField);


        panel.add(new JLabel("Prix de vente:"));
        panel.add(prixVenteField);

        panel.add(new JLabel("Type de produit:"));
        panel.add(typeBox);

        JLabel labelSpecifique = new JLabel("Date d'expiration:");
        panel.add(labelSpecifique);
        panel.add(champSpecifique);

        // Change label selon type sélectionné
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
        valider.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText()); 
                String nom = nomField.getText();
                int quantite = Integer.parseInt(quantiteField.getText());
                double prix = Double.parseDouble(prixField.getText());
                double prixVente = Double.parseDouble(prixVenteField.getText()); 
                String type = (String) typeBox.getSelectedItem();
                String spec = champSpecifique.getText();

                switch (type) {
                    case "Alimentaire" -> stock.ajouterProduit(new ProduitAlimentaire(id,nom, type, quantite, prix, prixVente, LocalDate.parse(spec)));
                    case "Vestimentaire" -> stock.ajouterProduit(new ProduitVestimentaire(id, nom, type, quantite,prix,prixVente,spec,null,null));
                    case "Électronique" -> stock.ajouterProduit(new ProduitElectronique(id, nom, type, quantite,prix,prixVente,Integer.parseInt(spec),null));
                }

                JOptionPane.showMessageDialog(this, "Produit ajouté !");
                dispose(); // Fermer le formulaire
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.add(valider);

        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
