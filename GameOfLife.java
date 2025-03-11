import java.util.Random;

public class GameOfLife {
    private int[][] grid;
    private int width, height;

    public GameOfLife(int w, int h) {
        this.width = w;
        this.height = h;
        this.grid = new int[width][height];
    }

    public void run(int generations) {
        for int(i = 0; i < generations; i++) {
            step();
            display();
        }
    }
}
