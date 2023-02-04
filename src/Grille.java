public class Grille {
    // Les dimensions de la grille à savoir le nombre de carrés sur l’axe x puis y
    private int x = 0;
    private int y = 0;

    public Grille(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
