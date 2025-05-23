import java.util.ArrayList;
import java.util.Iterator;
public class StockManager {
    static public ArrayList<Produit> produits = new ArrayList<>(); 


    public void ajouterProduit(Produit p){
        this.produits.add(p); 
    }

    public void supprimerProduit(int id) {
        Iterator<Produit> it = produits.iterator();
        while (it.hasNext()) {
            Produit p = it.next();
            if (p.getId() == id) {
                it.remove();
            }
        }
    }

    public Produit chercherProduit(int id){
        Produit p_null = new Produit(0, null, null, 0, 0, 0);
        for(Produit p: produits){
            int id_p = p.getId(); 
            if (id ==  id_p) {
                return p; 
            }
        }
        return p_null; 
    }

    public void afficherProduit(){
        for(Produit p: produits){
            System.out.println(p);
            System.out.println("*****************"); 
        }
    }

    public void afficherParType(String type){
        for(Produit p: produits){
            String t = p.getType(); 
            if (t ==  type) {
                System.out.println(p);
                System.out.println("*****************"); 
            }
        }
    }

    public void updateQuantite(int id, int quantite){
        for(Produit p: produits){
            int id_p = p.getId(); 
            if (id ==  id_p) {
                p.setQuantite(quantite);
            }
        }
    }
     public double calculerValeurStock(){
        double valeur = 0 ; 
        for(Produit p: produits){
            valeur += p.getQuantite()*p.getPrixAchat(); 
        }
        return valeur; 
    }

}
