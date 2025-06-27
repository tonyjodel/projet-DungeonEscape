import java.util.Scanner;
public class Jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Choisir une difficulté: ");
            int nombre = scanner.nextInt();
            new MoteurDeJeu(nombre);
        }
}
