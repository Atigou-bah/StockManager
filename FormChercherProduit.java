import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FormChercherProduit extends JFrame {
    

    public FormChercherProduit(StockManager stock){
        setTitle("Suppression de produit");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // aligné à gauche, avec des marges
    
        panel.add(new JLabel("ID :"));
        JTextField idField = new JTextField(15); // 15 colonnes
        panel.add(idField);
    
        JButton valider = new JButton("Chercher");
    
        valider.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (stock.idExiste(id)) {
                    Produit p = stock.chercherProduit(id); 
            
                    String[] colonnes = {"Id", "Nom", "Type", "Quantité", "Prix d'achat", "Prix de vente"}; 
                    String[][] donnees = new String[1][6];
            
                    donnees[0][0] = String.valueOf(p.getId());
                    donnees[0][1] = p.getNom();
                    donnees[0][2] = p.getType();
                    donnees[0][3] = String.valueOf(p.getQuantite());
                    donnees[0][4] = String.valueOf(p.getPrixAchat());
                    donnees[0][5] = String.valueOf(p.getPrixVente());
            
                    JTable table = new JTable(donnees, colonnes);
                    JScrollPane scrollPane = new JScrollPane(table);
                
                    JFrame fenetreTable = new JFrame("Produit trouvé");
                    fenetreTable.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    fenetreTable.setSize(500, 300);
                    fenetreTable.add(scrollPane);
                    fenetreTable.setLocationRelativeTo(null);
                    fenetreTable.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "L'ID n'existe pas !");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Veuillez entrer un ID valide !");
            }            
        });
    
        JPanel btnPanel = new JPanel();
        btnPanel.add(valider);
        add(panel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    
        setVisible(true);
    }
}
