import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
public class Interface {
    public static void main(String[] args) {

        // ajoute de quelque produit 
        StockManager stock = new StockManager();
        HistoriqueVente historique = new HistoriqueVente(); 

        // Produits Electroniques
        ProduitElectronique Pe1 = new ProduitElectronique(1, "voiture", "électronique", 5, 2000, 3000, 24, "Mercedes");
        ProduitElectronique Pe2 = new ProduitElectronique(2, "télévision", "électronique", 10, 500, 700, 12, "Samsung");

        stock.ajouterProduit(Pe1);
        stock.ajouterProduit(Pe2);

        // Produits Alimentaires
        LocalDate dlc1 = LocalDate.of(2025, 4, 22);
        LocalDate dlc2 = LocalDate.of(2025, 6, 10);
        ProduitAlimentaire Pa1 = new ProduitAlimentaire(3, "viande", "alimentaire", 2, 15, 20, dlc1);
        ProduitAlimentaire Pa2 = new ProduitAlimentaire(4, "lait", "alimentaire", 6, 1, 1, dlc2);

        stock.ajouterProduit(Pa1);
        stock.ajouterProduit(Pa2);

        // Produits Vestimentaires
        ProduitVestimentaire Pv1 = new ProduitVestimentaire(5, "pull", "vestimentaire", 1, 30, 30, "L", "blanc", "homme");
        ProduitVestimentaire Pv2 = new ProduitVestimentaire(6, "robe", "vestimentaire", 3, 45, 60, "M", "rouge", "femme");

        stock.ajouterProduit(Pv1);
        stock.ajouterProduit(Pv2);

        // debut de la fenetre 
        JFrame frame = new JFrame("Menu principal");

        // Créer un panel avec BoxLayout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Centrer verticalement avec des "glue"
        panel.add(Box.createVerticalGlue());

        // Créer et centrer les boutons
        JButton bouton1 = new JButton("1 - Consultation/Opérations sur le stock");
        bouton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton1);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton2 = new JButton("2 - Vente");
        bouton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton2);
        panel.add(Box.createVerticalStrut(15));

        JButton bouton3 = new JButton("3 - Quitter");
        bouton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(bouton3);

        panel.add(Box.createVerticalGlue()); // colle vers le bas

        // Ajouter les actions
        bouton1.addActionListener(e -> {
            new FenetreStock(stock); // Ouvre une nouvelle fenêtre
            frame.dispose();    // Ferme l'ancienne (optionnel)
        });
        bouton2.addActionListener(e -> {
            new FenetreVente(historique,stock);
            frame.dispose();
        });
        bouton3.addActionListener(e -> System.exit(0));

        // Ajouter le panel à la frame avec un layout centré
        frame.getContentPane().setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null); // centrer la fenêtre à l'écran
        frame.setVisible(true);
    }
}
