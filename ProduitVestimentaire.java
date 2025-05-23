public class ProduitVestimentaire extends Produit {
    



    private String taille; 
    private String couleur; 
    private String genre; 




    public ProduitVestimentaire(int id, String nom, String type, int quantite,double prix_achat,double prixVente,String taille, String couleur, String genre){
        super(id,nom,type,quantite,prix_achat,prixVente); 
        this.taille = taille; 
        this.couleur = couleur; 
        this.genre = genre; 
    }

        // Getter pour taille
    public String getTaille() {
        return taille;
    }

    // Setter pour taille
    public void setTaille(String taille) {
        this.taille = taille;
    }

    // Getter pour couleur
    public String getCouleur() {
        return couleur;
    }

    // Setter pour couleur
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    // Getter pour genre
    public String getGenre() {
        return genre;
    }

    // Setter pour genre
    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String toString() {
        return super.toString() +
            "Taille : " + taille + "\n" + 
            "Couleur : " + couleur + "\n" +
            "Genre : " + genre + "\n" + "******************";
    }



}
