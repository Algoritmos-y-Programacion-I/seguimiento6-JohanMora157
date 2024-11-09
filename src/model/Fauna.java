package model;

public class Fauna extends Species {

    private boolean isMigratory;
    private int maxWeight;

    public Fauna(String name, String scientificName, boolean isMigratory, int maxWeight) {
        super(name, scientificName);
        this.isMigratory = isMigratory;
        this.maxWeight = maxWeight;
    }

    public boolean getIsMigratory() {
        return isMigratory;
    }

    public void setIsMigratory(boolean isMigratory) {
        this.isMigratory = isMigratory;
    }

    public int getmaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public String toString() {
        return "Migratory?= " + isMigratory + ", Max Weigth= " + maxWeight;
    }
}
