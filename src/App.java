import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int grilleX, grilleY;
        int[] position = {0,0};
        char orientation;
        String instructions;

        // recuperer les donnees entrees par l'utilisateur
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Bonjours, entrez les donnees suivantes.");
            System.out.println("Dimension de la grille :");
            System.out.print("x = ");
            grilleX = userInput.nextInt();
            System.out.print("y = ");
            grilleY = userInput.nextInt();
            System.out.println("Position initiale de l'aspirateur :");
            System.out.print("x = ");
            position[0] = userInput.nextInt();
            System.out.print("y = ");
            position[1] = userInput.nextInt();
            System.out.print("Orientation = ");
            orientation = userInput.next().charAt(0);
            System.out.print("Instructions : ");
            instructions = userInput.next();
        }

        // creer un objet grille
        Grille grille = new Grille(grilleX, grilleY);
        // creer un objet aspirateur
        Aspirateur aspirateur = new Aspirateur(position, orientation);
        // creer un objet mission
        Mission mission = new Mission(orientation, grille, aspirateur);
        // recuperer et regler la list des instructions
        mission.setListeInstructions(instructions);
        // executer la liste des instructions et afficher la position finale de l'aspirateur 
        mission.executerListeInstructions(aspirateur, grille);

    }
}
