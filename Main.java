import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        StockManager stock = new StockManager();

        // Produits Electroniques
        ProduitElectronique Pe1 = new ProduitElectronique(1, "voiture", "electronique", 5, 2000, 3000, 24, "Mercedes");
        ProduitElectronique Pe2 = new ProduitElectronique(2, "télévision", "electronique", 10, 500, 700, 12, "Samsung");

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

        // Optionnel : afficher les produits
        stock.afficherProduit();
        //stock.supprimerProduit(1);
        //stock.afficherProduit();
        //stock.afficherParType("alimentaire");
        Vente vente = new Vente(Pv2, 1, dlc2); 
        System.out.println(vente);
    }
}
