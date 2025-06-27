public class Arme {
    private String nom;
    private String type;
    private int degats;
    private int munition;

    public Arme(String nom, String type, int degats, int munition) {
        this.nom = nom;
        this.type = type;
        this.degats = degats;
        this.munition = munition;
    }

    public String getNom() {
        return nom;
    }

    public void afficherDetails() {
        System.out.println(nom + " (" + type + ") - Dégâts : " + degats + ", Munitions : " + munition);
    }

    public void utiliser(Ennemi ennemi) {
        if (munition > 0) {
            munition--;
            System.out.println("Tu utilises " + nom + ". Il te reste " + munition + " munitions.");
        } else if (munition == 0) {
            System.out.println("Tu utilises " + nom + ".");
        } else {
            System.out.println("Cette arme ne nécessite pas de munitions.");
        }
        ennemi.takeDamage(degats);
    }
}

