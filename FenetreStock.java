import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FenetreStock extends JFrame {

    public FenetreStock(StockManager stock){

        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());

        JButton bouton1 = new JButton("Afficher les produits");
        bouton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton1);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton2 = new JButton("Ajouter un produit");
        bouton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton2);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton3 = new JButton("Supprimer un produit");
        bouton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton3);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton4 = new JButton("Chercher un produit");
        bouton4.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton4);
        panel.add(Box.createVerticalStrut(15));


        JButton bouton5 = new JButton("Valeur du stock");
        bouton5.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton5);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton6 = new JButton("Quitter");
        bouton6.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton6);

        panel.add(Box.createVerticalGlue());


        bouton1.addActionListener(e ->{
            ArrayList<Produit> produits = stock.getProduits(); // recuperation de la liste de produits 


            String[] colonnes = {"Id", "Nom", "Type", "Quantité", "Prix d'achat", "Prix de vente"}; 
            String[][] donnees = new String[produits.size()][6];

            for (int i = 0; i < produits.size(); i++) {
                Produit p = produits.get(i);
                donnees[i][0] = String.valueOf(p.getId()); 
                donnees[i][1] = p.getNom();
                donnees[i][2] = p.getType(); 
                donnees[i][3] = String.valueOf(p.getQuantite()); 
                donnees[i][4] = String.valueOf(p.getPrixAchat()); 
                donnees[i][5] = String.valueOf(p.getPrixVente()); 
            }
            JTable table = new JTable(donnees, colonnes);
            JScrollPane scrollPane = new JScrollPane(table);
        
            JFrame fenetreTable = new JFrame("Produits en stock");
            fenetreTable.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            fenetreTable.setSize(500, 300);
            fenetreTable.add(scrollPane);
            fenetreTable.setLocationRelativeTo(null);
            fenetreTable.setVisible(true);
        });
        bouton2.addActionListener(e->{
            new FormAjoutProduit(stock);  
        });

        bouton3.addActionListener(e->{
            new SupProduit(stock); 
        });

        bouton4.addActionListener(e->{

        });








        bouton6.addActionListener(e->System.exit(0));

        // 🧩 Lignes manquantes
        add(panel);            // Ajouter le panel à la fenêtre
        setTitle("Stock");
        setSize(800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);      // Afficher la fenêtre
    }
}
