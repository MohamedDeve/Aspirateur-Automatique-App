public class Mission {
    private char[] cardinaleAnglaise = {'N', 'E', 'S', 'W'};
    private char[] listeInstructions = {};
    private int orientation = -1; // l'index de l'orientation de l'aspirateur (par rapport au tableau cardinaleAnglaise)
    private boolean estPremiereFois = false;
    private String grilleDesign = "";
    private String ligne = "";

    public Mission(char orientationInitiale, Grille grille, Aspirateur aspirateur) {
        // trouver l'index de l'orientation initiale entree (par rapport au tableau cardinaleAnglaise)
        for (int i = 0; i < cardinaleAnglaise.length; i++) {
            if (cardinaleAnglaise[i] == orientationInitiale) {
                this.orientation = i;
                break;
            }
        }

        // afficher la position initiale de l'aspirateur
        this.estPremiereFois = true;
        afficherDeplacement(grille, aspirateur);
        this.estPremiereFois = false;
    }

    public void setListeInstructions(String listeInstructions) {
        // transformer la chaîne de caractères en uppercase
        listeInstructions = listeInstructions.toUpperCase();

        // convertire la chaîne de caractères en un tableau de caractères
        this.listeInstructions = listeInstructions.toCharArray();
    }

    public char[] getListeInstructions() {
        return this.listeInstructions;
    }

    // fonction pour faire pivoter l'aspirateur
    public void pivoter(char instruction) {
        if(instruction == 'D') { // pivoter vers le droit
            this.orientation++;
            // verifier si l'aspirateur a fait une tour complet
            if(this.orientation > 3) {
                this.orientation = 0;
            }
        } else { // pivoter vers la gauche
            this.orientation--;
            // verifier si l'aspirateur a revenue en arriere vers le dernier element du tableau cardinaleAnglaise
            if(this.orientation < 0) {
                this.orientation = 3;
            }
        }
    }

    // fonction pour faire avancer l'aspirateur
    public void avancer(Aspirateur aspirateur) {
        int[] p = aspirateur.getPosition();

        switch(this.orientation) {
            case 0: // déplacement en haut
                p[1]++;
                break;
            case 1: // déplacement à droit
                p[0]++;
                break;
            case 2: // déplacement en bas
                p[1]--;
                break;
            case 3: // déplacement à gauche
                p[0]--;
                break;
            default:
                break;
        }

        aspirateur.setPosition(p);
    }

    // fonction pour executer la liste d'instruction de cette mission
    public void executerListeInstructions(Aspirateur aspirateur, Grille grille) {
        // executer les instruction
        for(char instruction : this.listeInstructions) {
            if(instruction == 'D' || instruction == 'G') {
                this.pivoter(instruction);
            } else {
                // avancer l'aspirateur
                this.avancer(aspirateur);
                // afficher la position de l'aspirateur apres le deplacement
                afficherDeplacement(grille, aspirateur);
            }
        }

        // afficher la derniere position et l'orientation
        aspirateur.setOrientation(cardinaleAnglaise[orientation]);
        System.out.println("la position finale est : ");
        System.out.println("x = " + aspirateur.getPosition()[0] + " y = " + aspirateur.getPosition()[1]);
        System.out.println("orientation : " + aspirateur.getOrientation());
    }

    // fonction pour afficher un simple design de deplacement de l'aspirateur dans la grille
    public void afficherDeplacement(Grille grille, Aspirateur aspirateur) {
        if(this.estPremiereFois == false) {
            // marker la position de l'aspirateur dans le design de la grille
            int y = grille.getY();
            int[] p = aspirateur.getPosition();
            int yIndex = (y-(p[1]+1)) * this.ligne.length();
            int xIndex = p[0] * 2;
            int index = yIndex + xIndex;
            char[] grilleDesignChar = this.grilleDesign.toCharArray();
            grilleDesignChar[index] = 'x';
            this.grilleDesign = new String(grilleDesignChar);
            System.out.println(this.grilleDesign);

        } else { // cela est execute lorsque l'aspirateur n'a pas encors fait aucun deplacement
            // prendre les dimensions de la grille
            int x = grille.getX();
            int y = grille.getY();

            // creer une chaine de caractere qui va representer une ligne de la grille
            for(int i=0; i<x; i++) {
                this.ligne = this.ligne + "# ";
            }
            this.ligne = this.ligne + "\n";

            // remplire le design de la grille par les chaines de caracteres crees
            for(int i=0; i<y; i++) {
                this.grilleDesign = this.grilleDesign + this.ligne;
            }

            // marker la position initiale de l'aspirateur dans le design de la grille
            int[] p = aspirateur.getPosition();
            int yIndex = (y-(p[1]+1)) * this.ligne.length();
            int xIndex = p[0] * 2;
            int index = yIndex + xIndex;
            char[] grilleDesignChar = this.grilleDesign.toCharArray();
            grilleDesignChar[index] = 'x';
            this.grilleDesign = new String(grilleDesignChar);
            System.out.println(this.grilleDesign);
        }
    }
}
