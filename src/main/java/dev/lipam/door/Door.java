package dev.lipam.door;

public class Door {

    private final boolean hasWinBehind;
    private boolean isOpen = false;

    public Door(boolean hasWinBehind) {
        this.hasWinBehind = hasWinBehind;
    }

    public boolean hasWinBehind() {
        return hasWinBehind;
    }

    public boolean isNotOpen() {
        return !isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        assert !isOpen;
        isOpen = true;
    }

}
