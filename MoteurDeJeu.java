import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoteurDeJeu extends JFrame implements KeyListener {
    private Monde monde;
    private Joueur joueur;
    public MoteurDeJeu(int x) {
        joueur = new Joueur(1, 1, 50);
        monde = new Monde(x, x);
        monde.getSalle((int)(Math.random() * x),(int)(Math.random() * x)).setArme(new Arme("Couteau", "blanche", 100, 0));
        monde.getSalle((int)(Math.random() * x),(int)(Math.random() * x)).setArme(new Arme("Pistolet", "feu", 100, 6));
        setTitle("Dungeon Escape");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
        System.out.println("Bienvenue dans le Donjon !");
        System.out.println("Commandes : z,q,s,d (haut,gauche,bas,droite), f (Utiliser Arme à Feu), c (Utiliser Arme Blanche)");
        System.out.println("            e (examiner la salle), r (ramasser l'arme)");
        afficherEtat();
    }
    public void keyPressed(KeyEvent e) {
        char touche = e.getKeyChar();
        System.out.println("Touche appuyée : " + touche);
            if (joueur.getVie()==0){
                System.out.println("Vous etes mort, La partie est finie");
                System.exit(0);
            }

            else if (touche=='a') {
                System.out.println("Tu as choisi de quitter le jeu. À bientôt !");
                System.exit(0);
            } 

            else if (touche=='z') {
                if(joueur.getY() <= 0 ) {
                    System.out.println("Tu ne peux pas aller plus au nord.");
                }else{
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                Ennemi ennemi =salle.getEnnemi();
                if (ennemi!=null){  
                    if (ennemi.estArme()){
                        joueur.setVie(10);
                        System.out.println("Il y avait un ennemi dans la salle, vous avez désormais " + joueur.getVie() + " PV.");
                }}
                    joueur.deplacer(0, -1);
                    monde.setSalle(joueur.getX(), joueur.getY());
            }}

            else if (touche=='s') {
                if(joueur.getY()>= monde.getHauteur()-1){
                    System.out.println("Tu ne peux pas aller plus au sud.");
                }else{
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                Ennemi ennemi =salle.getEnnemi();
                if (ennemi!=null){  
                    if (ennemi.estArme()){
                        joueur.setVie(10);
                        System.out.println("Il y avait un ennemi dans la salle, vous avez désormais " + joueur.getVie() + " PV.");
                }}

                    joueur.deplacer(0, 1);
                    monde.setSalle(joueur.getX(), joueur.getY());                
            }}

            else if (touche=='d') {
                if (joueur.getX()>=monde.getHauteur()-1){
                    System.out.println("Tu ne peux pas aller plus à l'est.");
                }else{
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                Ennemi ennemi =salle.getEnnemi();
                if (ennemi!=null){  
                    if (ennemi.estArme()){
                        joueur.setVie(10);
                        System.out.println("Il y avait un ennemi dans la salle, vous avez désormais " + joueur.getVie() + " PV.");
                }}
                joueur.deplacer(1, 0);
                monde.setSalle(joueur.getX(), joueur.getY());
                }}

            else if (touche=='q') {
                if (joueur.getX() > 0) {
                System.out.println("Tu ne peux pas aller plus à l'ouest.");
                }else{
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                Ennemi ennemi =salle.getEnnemi();
                if (ennemi!=null){  
                    if (ennemi.estArme()){
                        joueur.setVie(10);
                        System.out.println("Il y avait un ennemi dans la salle, vous avez désormais " + joueur.getVie() + " PV.");
                }}
                    joueur.deplacer(-1, 0);
                    monde.setSalle(joueur.getX(), joueur.getY());

                }
            }

            else if (touche=='e') {
                examinerSalle();
                }

           else  if (touche=='r') {
                ramasserArme();
            }

            else if (touche=='f') {
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                Ennemi ennemi =salle.getEnnemi();
                if (ennemi==null){
                    System.out.println("Il n'y a pas d'ennemi ici."); 
                }else{
                joueur.utiliserArme("feu",ennemi);}
                if(ennemi.isAlive()){
                    System.out.println("L'ennemi est mort");
                    salle.setEnnemi(0);
                }
            }
            else if (touche=='c') {
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                Ennemi ennemi =salle.getEnnemi();
                if (ennemi==null){
                    System.out.println("Il n'y a pas d'ennemi ici."); 
                }else{
                    joueur.utiliserArme("blanche",ennemi);}
                if(ennemi.isAlive()){
                    System.out.println("L'ennemi est mort");
                    salle.setEnnemi(0);
                }
            }
            
            else if (touche=='v') {
                Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
                if (salle.estSortie()){
                    System.out.println("Felicitations, Vous avez fini le jeu !!!");
                System.exit(0);
                            }else{
                    System.out.println("Bah, vous n'y etes pas encore !!");
                }
            }else{

            System.out.println("Commande inconnue.");
            }
        afficherEtat();
    }

    private void afficherEtat() {
        System.out.println("\nTu es à la position : (" + joueur.getX() + ", " + joueur.getY() + ")");
        System.out.println("Points de vie du joueur : " + joueur.getVie());
        monde.afficherCarte(joueur.getX(), joueur.getY());
    }

    private void examinerSalle() {
        Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
        if (salle != null) {
            salle.afficherDescription();
            if (salle.getArme() != null) {
                System.out.println("Il y a une arme ici :");
                salle.getArme().afficherDetails();
            } else {
                System.out.println("Il n'y a pas d'arme ici.");
            }
            if (salle.getEnnemi()==null){
                System.out.println("Il n'y a pas d'ennemi ici.");
            }else{
                Ennemi e= salle.getEnnemi();
                e.afficherDescription();
            }
        }
    }

    private void ramasserArme() {
        Salle salle = monde.getSalle(joueur.getX(), joueur.getY());
        Arme arme = salle.getArme();

        if (arme != null) {
            joueur.ramasser(arme);
            salle.setArme(null);
        } else {
            System.out.println("Il n'y a pas d'arme à ramasser ici.");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
       }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
