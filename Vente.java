import java.time.LocalDate;
public class Vente {
    private Produit produit; 
    private int quantiteVendue; 
    private LocalDate dateVente; 

    public Vente(Produit p, int quantite, LocalDate date){
        this.produit = p; 
        this.quantiteVendue = quantite; 
        this.dateVente = date; 
    }

    // Getter pour produit
    public Produit getProduit() {
        return produit;
    }

    // Setter pour produit
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    // Getter pour quantiteVendue
    public int getQuantiteVendue() {
        return quantiteVendue;
    }

    // Setter pour quantiteVendue
    public void setQuantiteVendue(int quantiteVendue) {
        this.quantiteVendue = quantiteVendue;
    }

    // Getter pour dateVente
    public LocalDate getDateVente() {
        return dateVente;
    }

    // Setter pour dateVente
    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }

    public double getMontant(){
        Produit p = getProduit();
        return p.getPrixVente() * getQuantiteVendue();  
    }

    public String toString(){
        return "************* Facture ***************\n" + 
                "Nom : " + getProduit().getNom() + "\n" + 
                "Prix de vente : " + getProduit().getPrixVente() + "\n" + 
                "Quantite vendue : " + getQuantiteVendue() + "\n" + 
                "Date de vendue : " + getDateVente() + "\n" + 
                "Montant : " + getMontant(); 
    }


}
