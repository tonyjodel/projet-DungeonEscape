import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private int x;
    private int y;
    private int vie;
    private List<Arme> inventaire;

    public Joueur(int x, int y, int vie) {
        this.x = x;
        this.y = y;
        this.vie = vie;
        this.inventaire = new ArrayList<>();
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getVie() { return vie; }
    public void setVie(int dgt) { this.vie=this.vie-dgt; }

    public void deplacer(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void ramasser(Arme arme) {
        inventaire.add(arme);
        System.out.println("Tu as ramassé : " + arme.getNom());
    }

    public void utiliserArme(String nom, Ennemi ennemi) {
        for (Arme arme : inventaire) {
            if (arme.getNom().equalsIgnoreCase(nom)) {
                arme.utiliser(ennemi);
                return;
            }
        if (inventaire.contains (arme) ){
        System.out.println("Tu utilise : " + nom +" sur un ennemi.");
        }else{
        System.out.println("Tu n'as pas cette arme : " + nom);
    }}}
}
