import javax.swing.*;
import java.awt.*;
public class FenetreVente extends JFrame {

     public FenetreVente(HistoriqueVente historique){

        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalGlue());

        JButton bouton1 = new JButton("Afficher l'historique");
        bouton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton1);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton2 = new JButton(" Vendre un produit ");
        bouton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton2);
        panel.add(Box.createVerticalStrut(15));


        JButton bouton5 = new JButton("Quitter");
        bouton5.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton5);

        panel.add(Box.createVerticalGlue());

        bouton1.addActionListener(e->{
            new FenetreAffVente(historique); 
        });

        // 🧩 Lignes manquantes
        add(panel);            // Ajouter le panel à la fenêtre
        setTitle("Stock");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);   
     }
}