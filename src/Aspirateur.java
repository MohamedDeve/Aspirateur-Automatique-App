public class Aspirateur {
    // les coordonnées determinant la position de l'aspirateur
    private int[] position = {0,0};
    private char orientation = 'N';

    public Aspirateur(int[] position, char orientation) {
        this.position[0] = position[0];
        this.position[1] = position[1];
        this.orientation = orientation;
    }

    public void setPosition(int[] position) {
        this.position[0] = position[0];
        this.position[1] = position[1];
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    public int[] getPosition() {
        return this.position;
    }

    public char getOrientation() {
        return this.orientation;
    }

}
