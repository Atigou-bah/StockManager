import java.time.LocalDate;

public class ProduitAlimentaire extends Produit {
    private LocalDate datePerremption; 


    public ProduitAlimentaire(int id, String nom, String type, int quantite, double prix_achat, double prixVente, LocalDate dlc){
        super(id, nom, type,quantite,prix_achat,prixVente); 
        this.datePerremption = dlc; 
    }
    public LocalDate getDatePerremption() {
        return datePerremption;
    }
    
    public void setDatePerremption(LocalDate datePerremption) {
        this.datePerremption = datePerremption;
    }

    public String toString(){
        return super.toString() +  
            "Date de perremption : " + getDatePerremption() + "\n" + "******************";
            
        }

}
