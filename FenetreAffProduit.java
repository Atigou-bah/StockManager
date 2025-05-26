import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class FenetreAffProduit extends JFrame{
    public FenetreAffProduit(StockManager stock){
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
        fenetreTable.setSize(500, 600);
        fenetreTable.add(scrollPane);
        fenetreTable.setLocationRelativeTo(null);
        fenetreTable.setVisible(true);
    }
}
