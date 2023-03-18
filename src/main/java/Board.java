public class Board
{
    // TODO enum

    // 0 = empty
    // 1 = player 1
    // 2 = player 2
    private int[][] board;


    // Initialize Board with size `n`
    public Board(int size)
    {
        // TODO ensure size

        board = new int[size][size];
    }


    // player makes move
    public void makeMove(int row, int col, int player)
    {
        // TODO ensure index in bound

        if (board[row][col] == 0)
            board[row][col] = player;
    }


    // Checks for the entire board win status
    public int checkWin()
    {
        int winStatus;

        // check diagonals
        if ((winStatus = checkMainDiagonale()) != 0 ||
            (winStatus = checkReverseDiagonale()) != 0)
            return winStatus;

        // check rows/columns
        for (int i = 0; i < board.length; i++)
        {
            if ((winStatus = checkRow(i)) != 0 ||
                (winStatus = checkColumn(i)) != 0)
                return winStatus;
        }

        return 0;
    }


    // Checking helpers ------------------------------------------------------------------

    public int checkRow(int line)
    {
        for (int i = 1; i < board.length; i++)
        {
            if (board[line][i] == 0 || board[line][i-1] != board[line][i])
                return 0;
        }

        return board[line][0];
    }

    public int checkColumn(int col)
    {
        for (int i = 1; i < board.length; i++)
        {
            if (board[i][col] == 0 || board[i-1][col] != board[i][col])
                return 0;
        }

        return board[0][col];
    }

    public int checkMainDiagonale()
    {
        for (int i = 1; i < board.length; i++)
        {
            if (board[i][i] == 0 || board[i-1][i-1] != board[i][i])
                return 0;
        }

        return board[0][0];
    }

    public int checkReverseDiagonale()
    {
        for (int i = 1; i < board.length; i++)
        {
            if (
                board[i-1][board.length-i] == 0 ||
                board[i-1][board.length-i] != board[i][board.length-i-1]
            )
                return 0;
        }

        return board[board.length-1][0];
    }
}
