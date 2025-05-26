import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SupProduit extends JFrame{
    public SupProduit(StockManager stock){
        setTitle("Suppression de produit");
        setSize(400, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // aligné à gauche, avec des marges
    
        panel.add(new JLabel("ID :"));
        JTextField idField = new JTextField(15); // 15 colonnes
        panel.add(idField);
    
        JButton valider = new JButton("Supprimer");
    
        valider.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (stock.idExiste(id)) {
                    stock.supprimerProduit(id);
                    JOptionPane.showMessageDialog(this, "Suppression réussie !");
                    dispose();
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
