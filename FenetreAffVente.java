import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;
public class FenetreAffVente extends JFrame {
    public FenetreAffVente(HistoriqueVente historique){
        ArrayList<Vente> ventes = historique.getVentes(); 

        String[] colonnes = {"Id produit", "Quantite vendue","Date de vente"};
        String[][] donnes = new String[ventes.size()][3]; 

        for(int i = 0; i< ventes.size();i++){
            Produit p = ventes.get(i).getProduit();  
            Vente v = ventes.get(i); 
            donnes[i][0] = String.valueOf(p.getId()); 
            donnes[i][1] = String.valueOf(v.getQuantiteVendue()); 
            donnes[i][2] = String.valueOf(v.getDateVente()); 
        }

        JTable table = new JTable(donnes,colonnes); 
        JScrollPane scrollPane = new JScrollPane(table);
    
        JFrame fenetreTable = new JFrame("Historique de vente");
        fenetreTable.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fenetreTable.setSize(500, 600);
        fenetreTable.add(scrollPane);
        fenetreTable.setLocationRelativeTo(null);
        fenetreTable.setVisible(true);

    }
}
