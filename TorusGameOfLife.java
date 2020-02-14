public class TorusGameOfLife extends GameOfLife {

    //constructors
    public TorusGameOfLife() {
        super();
    }

    public TorusGameOfLife(int[][] previousBoard) {
        super(previousBoard);
    }

    public TorusGameOfLife(int size) {
        super(size);
    }

    @Override
    public int neighbors(int row, int col) {
        int count = 0;


        //Top Left
        count += previousBoard[(size + row - 1) % size][(size + col - 1) % size];

        //Top Center
        count += previousBoard[(size + row - 1) % size][col];

        //Top Right
        count += previousBoard[(size + row - 1) % size][(size + col + 1) % size];

        //Center Left
        count += previousBoard[row][(size + col - 1) % size];

        //Center Right
        count += previousBoard[row][(size + col + 1) % size];

        //Bottom Left
        count += previousBoard[(size + row + 1) % size][(size + col - 1) % size];

        //Bottom Center
        count += previousBoard[(size + row + 1) % size][col];

        //Bottom Right
        count += previousBoard[(size + row + 1) % size][(size + col + 1) % size];
        return count;
    }



}
