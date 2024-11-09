package model;

public class Flora extends Species {

    private boolean hasFlowers;
    private boolean hasFruits;
    private int maxHeight;

    public Flora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, int maxHeight) {
        super(name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }

    public boolean isHasFlowers() {
        return hasFlowers;
    }

    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    public boolean isHasFruits() {
        return hasFruits;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public int getmaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return "Flowers?= " + hasFlowers + ", Fruits?= " + hasFruits + ", Max Heith= " + maxHeight;
    }

}
