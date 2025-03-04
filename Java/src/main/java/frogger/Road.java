package frogger;

/**
 * Refactor Task 1.
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Road {
    private final boolean[] occupied;

    public Road(boolean[] occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied(int position) {
        if (!isValidPosition(position)) {
            return false;
        }
        return this.occupied[position];
    }

    public boolean isValidPosition(int position) {
        return position >= 0 && position < occupied.length;
    }
}
