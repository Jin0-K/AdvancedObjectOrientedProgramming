import javax.swing.*;

public abstract class Display {
    protected int height;
    protected int width;

    public Display(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract JPanel create();
    public abstract void show();
}
