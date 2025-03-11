public class GameOfLife {
    private final int width, height;
    private int[][] board, nextBoard;

    public GameOfLife(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[height][width];
        this.nextBoard = new int[height][width];
    }

    public void run(int steps) {
        for (int i = 0; i < steps; i++) {
            step();
        }
    }

    public void step() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int neighbors = countNeighbors(x, y);
                if (board[y][x] == 1) {
                    nextBoard[y][x] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    nextBoard[y][x] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
        int[][] temp = board;
        board = nextBoard;
        nextBoard = temp;
    }

    public int countNeighbors(int x, int y) {
        int count = 0;
        for (int dy = -1; dy <= 1; dy++) {
            for (int dx = -1; dx <= 1; dx++) {
                if (dx == 0 && dy == 0) continue;
                if (get(x + dx, y + dy) == 1) count++;
            }
        }
        return count;
    }

    public int get(int x, int y) {
        int wrappedX = (x + width) % width;
        int wrappedY = (y + height) % height;
        return board[wrappedY][wrappedX];
    }

    public void set(int x, int y, int[][] data) {
        for (int dy = 0; dy < data.length; dy++) {
            for (int dx = 0; dx < data[dy].length; dx++) {
                int newX = (x + dx) % width;
                int newY = (y + dy) % height;
                board[newY][newX] = data[dy][dx];
            }
        }
    }

    public void print() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "■ " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
