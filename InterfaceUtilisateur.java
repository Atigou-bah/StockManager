import java.time.LocalDate;
import java.util.Scanner;
public class InterfaceUtilisateur {
    


    public void affichageMenuPrincipale(){
        System.out.println("Bonjour Bienvenue dans votre stock");
        System.out.println("1- Consultation/operation sur  le stock ");
        System.out.println("2- Vendre un produit ");
        System.out.println("3- Quitter ");
        System.out.println("**********************");
    }

    public static void ajouterProduitDepuisMenu(StockManager stock) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Ajout d’un produit au stock ===");
        System.out.println("1. Produit électronique");
        System.out.println("2. Produit alimentaire");
        System.out.println("3. Produit vestimentaire");
        System.out.print("Choisissez le type (1-3) : ");
        int choix = scanner.nextInt();
        scanner.nextLine(); // Consommer le \n

        // Infos communes
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix d’achat : ");
        int prixAchat = scanner.nextInt();
        System.out.print("Prix de vente : ");
        int prixVente = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                System.out.print("Durée de garantie (mois) : ");
                int garantie = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Marque : ");
                String marque = scanner.nextLine();
                ProduitElectronique pe = new ProduitElectronique(id, nom, "electronique", quantite, prixAchat, prixVente, garantie, marque);
                stock.ajouterProduit(pe);
                break;

            case 2:
                System.out.print("Date de péremption (aaaa-mm-jj) : ");
                String dateStr = scanner.nextLine();
                LocalDate dlc = LocalDate.parse(dateStr);
                ProduitAlimentaire pa = new ProduitAlimentaire(id, nom, "alimentaire", quantite, prixAchat, prixVente, dlc);
                stock.ajouterProduit(pa);
                break;

            case 3:
                System.out.print("Taille : ");
                String taille = scanner.nextLine();
                System.out.print("Couleur : ");
                String couleur = scanner.nextLine();
                System.out.print("Genre : ");
                String genre = scanner.nextLine();
                ProduitVestimentaire pv = new ProduitVestimentaire(id, nom, "vestimentaire", quantite, prixAchat, prixVente, taille, couleur, genre);
                stock.ajouterProduit(pv);
                break;

            default:
                System.out.println("Choix invalide.");
        }

        System.out.println("\n=== Produit ajouté ===");
    }


    public int optionUtilisateur(){
        affichageMenuPrincipale();
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Entrez un numero : ");
        int choix = scanner.nextInt(); 
        return choix; 

    }

    public void stock(StockManager stock, boolean running){
        while (running) {
            
        
        System.out.println("1- Afficher les produits");
        System.out.println("2- Supprimer un produit");
        System.out.println("3- Ajouter un produit");
        System.out.println("4- Chercher un produit");
        System.out.println("5- Connaitre la valeur du stock");
        System.out.println("6- Quitter");
        System.out.println("**********************");
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Entrez un numero");
        int choix = scanner.nextInt(); 
        switch (choix) {
            case 1:
                stock.afficherProduit();
                break;
            case 2: 
                Scanner scanner2 = new Scanner(System.in); 
                System.out.println("Donner l'id du produit");
                stock.supprimerProduit(scanner2.nextInt());
                break; 
            case 3: 
                ajouterProduitDepuisMenu(stock);

            case 4: 
                Scanner scanner3 = new Scanner(System.in); 
                System.out.println("Donner l'id du produit");
                Produit p = stock.chercherProduit(scanner3.nextInt());
                System.out.println(p);
                break; 
            case 5 : 
            
            System.out.println("Voici la valeur du stock: " + stock.calculerValeurStock());

            default:
            running = false; 
                break;
        }
    }
    }

    public Vente vente(StockManager stock, int id, int quantite){
        Produit p = stock.chercherProduit(id); 
        if (p.getQuantite() - quantite <= 0) {
            System.out.println("Impossible de vendre cette quantité vous disposez de : " + p.getQuantite());
            stock.supprimerProduit(id);
            Vente v =  new Vente(p,p.getQuantite(),LocalDate.now());
            return v ; 
        }
        p.setQuantite(p.getQuantite() - quantite);
        Vente v = new Vente(p, quantite, LocalDate.now()); 
        return v; 

    }

    public void facture(StockManager stock){
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Donnez l'id du produit que vous voulez vendre : ");
        int id = scanner.nextInt(); 

        Scanner scanner2 = new Scanner(System.in); 
        System.out.println("Donnez la quantité : ");
        int quantite = scanner2.nextInt(); 
        Vente v = vente(stock, id, quantite); 
        System.out.println(v.toString());

    }

    public void lancerMenu(StockManager stock){
        boolean running = true; 
        
        while (running) {
            int choix = optionUtilisateur();
            switch (choix) {
                case 1:
                    stock(stock, running);
                    break;
                case 2: 
                    facture(stock);
                    break; 

                default:
                running = false; 
                    break;
            }
        }
    }
}
