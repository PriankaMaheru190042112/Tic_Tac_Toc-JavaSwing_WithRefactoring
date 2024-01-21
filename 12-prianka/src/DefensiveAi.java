public class DefensiveAi extends TicTacToeAI{

    public DefensiveAi() {
        board = new int[3][3];
    }


    // calculate the winning move for current token
    public int []calculateNextWinningMove(int token) {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(getBoardValue(i, j)==EMPTY) {
                    board[i][j] = token;
                    boolean win = isWin(token);
                    board[i][j] = EMPTY;

                    if(win)
                        return new int[]{i,j};
                }

        return null;
    }





    public int[] defensiveAiMove(int token)
    {
        // lucky position in the center of board
        if(getBoardValue(1, 1)==EMPTY)
            return new int[]{1,1};

        // if we can move on the next turn


        // choose the move that prevent enemy to win
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(getBoardValue(i, j)==EMPTY)
                {
                    board[i][j] = token;
                    boolean ok = calculateNextWinningMove(inverse(token)) == null;
                    board[i][j] = EMPTY;


                    if(ok)
                        return new int[]{i,j};
                }

        //choose available move
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(getBoardValue(i, j)==EMPTY)
                    return new int[]{i,j};

        /* no move is available */
        return null;
    }

    public int inverse(int token) {
        return token==HUMAN ? COMPUTER : HUMAN;
    }




}
