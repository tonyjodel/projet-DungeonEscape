public class Monde {
    private Salle[][] salles;
    private int largeur;
    private int hauteur;

    public Monde(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        salles = new Salle[hauteur][largeur];
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                salles[y][x] = new Salle(false, "Salle");
            }
        }
        salles[hauteur-1][largeur-1] = new Salle(true, "Sortie");
    }

    public int getLargeur() { return largeur; }
    public int getHauteur() { return hauteur; }

    public void setSalle(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            salles[y][x].setEnnemi(1);
        }
    }
    public Salle getSalle(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            return salles[y][x];
        }
        return null;
    }

    public void afficherCarte(int xJoueur, int yJoueur) {
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < largeur; x++) {
                if (x == xJoueur && y == yJoueur) {
                    System.out.print("P ");
                } else if (salles[y][x].estSortie()) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    public String[] getCarte (int xJoueur,int yJoueur){
    String[] res = new String[hauteur]; // Initialisation du tableau résultat

    for (int y = 0; y < hauteur; y++) {
        StringBuilder ligne = new StringBuilder();

        for (int x = 0; x < largeur; x++) {
            if (x == xJoueur && y == yJoueur) {
                ligne.append("@ "); // Joueur
            } else if (salles[y][x].estSortie()) {
                ligne.append("S "); // Sortie
            } else {
                ligne.append("  "); // Vide
            }
        }

        res[y] = ligne.toString(); // Enregistrer la ligne dans le tableau
    }

    return res;
}
}
