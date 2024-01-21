

public class TicTacToeAI {

    public int board[][];
    public static final int EMPTY = 0;
    public static final int HUMAN = 1;
    public static final int COMPUTER = 2;

    //TicTacToeUI ticTacToeUI = null;

    public TicTacToeAI() {
        board = new int[3][3];
    }

    // get the board value for position (i,j)
    public int getBoardValue(int i,int j) {
        if(i < 0 || i >= 3)
            return EMPTY;
        if(j < 0 || j >= 3)
            return EMPTY;

        return board[i][j];
    }

    // set the board value for position (i,j)
    public void setBoardValue(int i,int j,int token) {
        if(i < 0 || i >= 3)
            return;
        if(j < 0 || j >= 3)
            return;
        board[i][j] = token;
    }





    // determine who won the game
    public boolean isWin(int token) {

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {

                /* we skip if the token in position(i,j) not equal current token */
                if (getBoardValue(i, j) != token)
                    continue;

                else {
                    if (getBoardValue(0, 0) != ' ' && getBoardValue(0, 1) != ' ' && getBoardValue(0, 2) != ' ') {
                        if (getBoardValue(0, 0) == token && getBoardValue(0, 1) == token && getBoardValue(0, 2) == token) {
                            return true;
                        }

                    }
                    if (getBoardValue(2, 0) != ' ' && getBoardValue(2, 1) != ' ' && getBoardValue(2, 2) != ' ') {
                        if (getBoardValue(2, 0) == token && getBoardValue(2, 1) == token && getBoardValue(2, 2) == token) {
                            return true;
                        }

                    }

                    if (getBoardValue(1, 0) != ' ' && getBoardValue(1, 1) != ' ' && getBoardValue(1, 2) != ' ') {
                        if (getBoardValue(1, 0) == token && getBoardValue(1, 1) == token && getBoardValue(1, 2) == token) {
                            return true;
                        }

                    }


                    if (getBoardValue(0, 0) != ' ' && getBoardValue(1, 0) != ' ' && getBoardValue(2, 0) != ' ') {
                        if (getBoardValue(0, 0) == token && getBoardValue(1, 0) == token && getBoardValue(2, 0) == token) {
                            return true;
                        }

                    }
                    if (getBoardValue(0, 1) != ' ' && getBoardValue(1, 1) != ' ' && getBoardValue(2, 1) != ' ') {
                        if (getBoardValue(0, 1) == token && getBoardValue(1, 1) == token && getBoardValue(2, 1) == token) {
                            return true;
                        }

                    }
                    if (getBoardValue(0, 2) != ' ' && getBoardValue(1, 2) != ' ' && getBoardValue(2, 2) != ' ') {
                        if (getBoardValue(0, 2) == token && getBoardValue(1, 2) == token && getBoardValue(2, 2) == token) {
                            return true;
                        }

                    }
                    if (getBoardValue(0, 0) != ' ' && getBoardValue(1, 1) != ' ' && getBoardValue(2, 2) != ' ') {
                        if (getBoardValue(0, 0) == token && getBoardValue(1, 1) == token && getBoardValue(2, 2) == token) {
                            return true;
                        }

                    }

                    if (getBoardValue(0, 2) != ' ' && getBoardValue(1, 1) != ' ' && getBoardValue(2, 0) != ' ') {
                        if (getBoardValue(0, 2) == token && getBoardValue(1, 1) == token && getBoardValue(2, 0) == token) {
                            return true;
                        }

                    }


                }

            }
        }
        return false;
    }


}




