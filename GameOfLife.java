public class GameOfLife {

    //attributes
    int size;
    int[][] currentBoard;
    int[][] previousBoard;

    //constructors
    public GameOfLife() {}

    public GameOfLife(int size) {
        this.size = size;
        this.currentBoard = new int[size][size];
        this.previousBoard = new int[size][size];
    }

    public GameOfLife(int[][] board) {
        this.size = board.length;
        this.currentBoard = new int[size][size];
        this.previousBoard = new int[size][size];
        copyArray(board, this.previousBoard);
        copyArray(board, this.currentBoard);
    }

    //Getter
    public int[][] getCurrentBoard() {
        return currentBoard;
    }

    //Main Methods
    public void oneStep() {
        for(int row = 0; row < this.size; row++){

            for(int col = 0; col < this.size; col++){

                int neighborNumber = neighbors(row,col);
                if(previousBoard[row][col] == 0){

                    if(neighborNumber == 3){
                        this.currentBoard[row][col] = 1;
                    }
                    else{
                        this.currentBoard[row][col] = 0;
                    }

                }
                else{
                    if(neighborNumber == 2 || neighborNumber == 3){
                        this.currentBoard[row][col] = 1;
                    }
                    else {
                        this.currentBoard[row][col] = 0;
                    }
                }
            }

        }
        //printArray();

    }

    public int neighbors(int row, int col) {

        //Counter for the number of neighbors that are alive
        int count = 0;

        //Top Left Corner
        if(row - 1 >= 0 && col -1 >= 0)
            count += previousBoard[row - 1][col - 1];
        //Top Center
        if(row - 1 >= 0)
            count += previousBoard[row - 1][col];
        //Top Right Corner
        if(row - 1 >= 0 && col + 1 < this.size)
            count += previousBoard[row - 1][col + 1];
        //Left Center
        if(col - 1 >= 0)
            count += previousBoard[row][col - 1];
        //Right Center
        if(col + 1 < this.size)
            count += previousBoard[row][col + 1];
        //Bottom Left Corner
        if(row + 1 < this.size && col - 1 >= 0)
            count += previousBoard[row + 1][col - 1];
        //Bottom Center
        if(row + 1 < this.size)
            count += previousBoard[row + 1][col];
        //Bottom Right Corner
        if(row + 1 < this.size && col + 1 < this.size)
            count += previousBoard[row + 1][col + 1];

        return count;
    }

    public void evolution(int steps) {

        //System.out.println("Original:");
        //printArray();
        for(int i = 0; i < steps; i++){


            copyArray(currentBoard,previousBoard);
            oneStep();
            //System.out.println("Generation" + (i + 2) + ": ");
            //printArray();

        }

    }

    //Helper Methods
    public void copyArray(int[][] board, int[][] copy){
        for (int i = 0; i < board.length; i++) {

            for(int j = 0; j < board[i].length; j++){

                copy[i][j] = board[i][j];
            }
        }
    }

    public void printArray(){

        for(int i = 0; i < this.currentBoard.length; i++) {

            for(int j = 0; j < this.currentBoard[i].length; j++){

                System.out.print(this.currentBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

}
