public class ProduitElectronique extends Produit {
    

    private int garantie; 
    private String marque;


    public ProduitElectronique(int id, String nom, String type, int quantite, double prix_achat, double prixVente, int garantie, String marque){
        super(id,nom,  type,  quantite,prix_achat,prixVente); 
        this.garantie = garantie; 
        this.marque = marque; 
    }

        // Getter pour garantie
    public int getGarantie() {
        return garantie;
    }

    // Setter pour garantie
    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    // Getter pour marque
    public String getMarque() {
        return marque;
    }

    // Setter pour marque
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String toString() {
        return super.toString() +
               "Marque : " + getMarque() + "\n" + 
               "Garantie : " + getGarantie() + " mois" + "\n" + "******************";
    }

}
