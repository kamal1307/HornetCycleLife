package esi.atl5.balde_elbejjati_kayani.hornet.model;

/**
 * represents a point in the Cartesian plane
 *
 * @author Alpha,Mohamed,Kamal
 */
public class Position {

    private int abs;
    private int ord;

    /**
     * the constructor, Initializes the coordinate of the point with the values
     * ​​passed in parameter
     *
     * @param abs The abscissa
     * @param ord the ordinate
     */
    public Position(int abs, int ord) {
        this.abs = abs;
        this.ord = ord;
    }

    /**
     * Constructor by copying
     *
     * @param p another point passed in parameter
     */
    public Position(Position p) {

        this(p.abs, p.ord);
    }

    /**
     * this method Moves the point from its initial position
     *
     * @param dx The value to be added to the abscissa
     * @param dy The value to be added to the ordonate
     */
    void move(double dx, double dy) {
        this.abs += dx;
        this.ord += dy;
    }

    /**
     * the getter for the abscissa
     *
     * @return x;
     */
    public int getAbs() {
        return abs;
    }

    /**
     * the getter for the ordonate
     *
     * @return ord
     */
    public int getOrd() {
        return ord;
    }

    /**
     * 
     * @return the hashCode
     */
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    /**
     * return true if the two object are equals
     * @param obj a other object
     * @return true if the two object are equals
     */
    @Override
    public boolean equals(Object obj) {

        if ((obj == null) || (obj.getClass() != Position.class)) {
            return false;
        }
        final Position other = (Position) obj;
        return this.abs == other.getAbs() && this.ord == other.getOrd();

    }

}
