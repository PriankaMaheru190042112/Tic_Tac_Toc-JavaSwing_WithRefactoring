public class RandomAi extends TicTacToeAI{

    public RandomAi() {
        board = new int[3][3];
    }

    public int []randomAiMove(int token) {

        //random ai
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                i= (int)(Math.random()*(2-0+1)+0);
                j= (int)(Math.random()*(2-0+1)+0);

                if (getBoardValue(i, j) == EMPTY) {
                    return new int[]{i, j};
                }

            }
        }
        // if no move is available
        return null;
    }

}
