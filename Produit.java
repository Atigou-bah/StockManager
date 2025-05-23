public class Produit {

    private int id; 
    private String nom; 
    private String type; 
    private int quantite; 
    private double prixAchat; 
    private double prixVente; 



    public Produit(int id, String nom, String type, int quantite, double prix_achat, double prix_vente){
        this.id = id; 
        this.nom = nom; 
        this.type = type; 
        this.quantite = quantite; 
        this.prixAchat = prix_achat; 
        this.prixVente = prix_vente; 

    }

    double calculerMarge(){
        return quantite*prixVente - quantite*prixAchat; 
    } 
    // getters 
    public int getId(){
        return id; 
    }
    public String getNom(){
        return nom; 
    }
    public String getType(){
        return type; 
    }
    public int getQuantite(){
        return quantite; 
    }
    public double getPrixAchat(){
        return prixAchat; 
    }
    public double getPrixVente(){
        return prixVente; 
    }

    // setters 
    public void setId(int newId){
        this.id = newId; 
    }
    public void setNom(String newNom){
        this.nom = newNom; 
    }
    public void setType(String newtype){
        this.type = newtype; 
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }
    
    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }
    
    public String toString(){
        return  "Id : " + getId() +  "\n" +
                "Nom du produit : " + getNom() + "\n" + 
                "Type : " + getType() + "\n" + 
                "Quantité : " + getQuantite() + "\n" + 
                "Prix d'achat : " + getPrixAchat() +" $ " + "\n" + 
                "Prix de vente : " + getPrixVente() + " $ " + "\n"; 

    }
    
}