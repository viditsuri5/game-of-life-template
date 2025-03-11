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
    public void step() {
        int [][] nextGrid = new int[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int liveCells = countLiveNeighbors(x, y);
                if (grid[x][y] == 1) {
                    nextGrid [x][y] = (liveCells == 2 || liveCells == 3) ? 1 : 0;
                } else {
                    nextGrid[x][y] = (liveCells == 3) ? 1 : 0;
                }
            }
        }
        grid = nextGrid;
    }
    private int countLiveNeighbors(intx, int y) {
        int count = 0;
        int[] offsetX = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] offsetY = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i=0; i < 8; i++;){
            int newX = (x + offsetX[i] + width) % width;
            int newY = (y + offsetY[i] + height) % height;
            count += grid[newX][newY];
        }
        return count;
    }
    public void setCellState(int x, int y, int state) {
        
    }
}
