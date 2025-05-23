import java.util.ArrayList;

public class HistoriqueVente {
    private ArrayList<Vente> ventes; 

    public HistoriqueVente(){
        this.ventes = new ArrayList<>(); 
    }

    public void ajouterVente(Vente v){
        ventes.add(v); 
    }

    public double getChiffreAffaires(){
        double chiffre = 0; 
        for(Vente v: ventes){
            chiffre += v.getMontant();
        }
        return chiffre; 
    }

    public void afficherVentes(){
        if (ventes.isEmpty()) {
            System.out.println("il n'y a eu aucune vente");
            System.out.println("****************");
            return; 
        }
        System.out.println("Voici toutes les factures ");
        for(Vente v : ventes){
            System.out.println(v); // appelle la methode toString de la classe ventes
        }
    }

    public void filtreParProduit(int id){
        for(Vente v: ventes){
            if (v.getProduit().getId() == id) {
                System.out.println(v);
            }
        }
    }
}
