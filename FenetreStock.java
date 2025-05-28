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
            new FenetreAffProduit(stock); 
        });
        bouton2.addActionListener(e->{
            new FormAjoutProduit(stock);  
        });

        bouton3.addActionListener(e->{
            new SupProduit(stock); 
        });

        bouton4.addActionListener(e->{
            new FormChercherProduit(stock); 
        });

        bouton5.addActionListener(e->{
            JOptionPane.showMessageDialog(this, "La valeur du stock est : " + String.valueOf(stock.calculerValeurStock()) + "$");
        });








        bouton6.addActionListener(e->dispose());

        // 🧩 Lignes manquantes
        add(panel);            // Ajouter le panel à la fenêtre
        setTitle("Stock");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);      // Afficher la fenêtre
    }
}
