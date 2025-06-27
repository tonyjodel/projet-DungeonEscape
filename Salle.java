import java.util.Random;

public class Salle {
    private boolean estSortie;
    private String description;
    private Arme arme;
    private Ennemi ennemi;

    public Salle(boolean estSortie, String description) {
        this.estSortie = estSortie;
        this.description = description;
        this.arme = null;
        this.ennemi = null;
    }

    public boolean estSortie() {
        return estSortie;
    }

    public void afficherDescription() {
        System.out.println(description);
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }
    public void setEnnemi(int x){
        if (x==0){
            this.ennemi=null;
        }else{
        Random rn = new Random();
        if (rn.nextBoolean()){
            this.ennemi = new Ennemi();
        }
    }
    }
    public Ennemi getEnnemi(){
        return this.ennemi;
    }
}

