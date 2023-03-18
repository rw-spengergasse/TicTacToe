import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest
{
    @BeforeEach
    public void setup()
    {

    }

    @Test
    void checkWin()
    {
    }



    // row --------------------------------------------------------------------------------

    @Test
    void checkRow_returnsNoWinningPlayer_onEmptyBoard()
    {
        // Given
        // 0 0 0
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);

        // When
        int winStatus = board.checkRow(0);

        // Then
        assertEquals(0, winStatus);
    }

    @Test
    void checkRow_returnsWinningPlayer()
    {
        // Given
        // 1 1 1
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(0, 1, 1);
        board.makeMove(0, 2, 1);

        // When
        int winStatus = board.checkRow(0);

        // Then
        assertEquals(1, winStatus);
    }

    @Test
    void checkRow_returnsNoWinningPlayer_onMixedBoard()
    {
        // Given
        // 1 0 1
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(0, 2, 1);

        // When
        int winStatus = board.checkRow(0);

        // Then
        assertEquals(0, winStatus);
    }



    // column --------------------------------------------------------------------------------

    @Test
    void checkColumn_returnsNoWinningPlayer_onEmptyBoard()
    {
        // Given
        // 0 0 0
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);

        // When
        int winStatus = board.checkColumn(0);

        // Then
        assertEquals(0, winStatus);
    }

    @Test
    void checkColumn_returnsWinningPlayer()
    {
        // Given
        // 1 0 0
        // 1 0 0
        // 1 0 0
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(1, 0, 1);
        board.makeMove(2, 0, 1);

        // When
        int winStatus = board.checkColumn(0);

        // Then
        assertEquals(1, winStatus);
    }

    @Test
    void checkColumn_returnsNoWinningPlayer_onMixedBoard()
    {
        // Given
        // 1 0 0
        // 0 0 0
        // 1 0 0
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(2, 0, 1);

        // When
        int winStatus = board.checkColumn(0);

        // Then
        assertEquals(0, winStatus);
    }



    // main diagonale --------------------------------------------------------------------------------

    @Test
    void checkMainDiagonale_returnsNoWinningPlayer_onEmptyBoard()
    {
        // Given
        // 0 0 0
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);

        // When
        int winStatus = board.checkMainDiagonale();

        // Then
        assertEquals(0, winStatus);
    }

    @Test
    void checkMainDiagonale_returnsWinningPlayer()
    {
        // Given
        // 1 0 0
        // 0 1 0
        // 0 0 1
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(1, 1, 1);
        board.makeMove(2, 2, 1);

        // When
        int winStatus = board.checkMainDiagonale();

        // Then
        assertEquals(1, winStatus);
    }

    @Test
    void checkMainDiagonale_returnsNoWinningPlayer_onMixedBoard()
    {
        // Given
        // 1 0 0
        // 0 0 0
        // 0 0 1
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(2, 2, 1);

        // When
        int winStatus = board.checkMainDiagonale();

        // Then
        assertEquals(0, winStatus);
    }



    // reverse diagonale --------------------------------------------------------------------------------

    @Test
    void checkReverseDiagonale_returnsNoWinningPlayer_onEmptyBoard()
    {
        // Given
        // 0 0 0
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);

        // When
        int winStatus = board.checkReverseDiagonale();

        // Then
        assertEquals(0, winStatus);
    }

    @Test
    void checkReverseDiagonale_returnsWinningPlayer()
    {
        // Given
        // 0 0 1
        // 0 1 0
        // 1 0 0
        Board board = new Board(3);
        board.makeMove(0, 2, 1);
        board.makeMove(1, 1, 1);
        board.makeMove(2, 0, 1);

        // When
        int winStatus = board.checkReverseDiagonale();

        // Then
        assertEquals(1, winStatus);
    }

    @Test
    void checkReverseDiagonale_returnsNoWinningPlayer_onMixedBoard()
    {
        // Given
        // 0 0 1
        // 0 0 0
        // 1 0 0
        Board board = new Board(3);
        board.makeMove(0, 2, 1);
        board.makeMove(2, 0, 1);

        // When
        int winStatus = board.checkReverseDiagonale();

        // Then
        assertEquals(0, winStatus);
    }


    // check win --------------------------------------------------------------------------------

    @Test
    void checkWin_returnsWinningPlayer()
    {
        // Given
        // 1 1 1
        // 0 0 0
        // 0 0 0
        Board board = new Board(3);
        board.makeMove(0, 0, 1);
        board.makeMove(0, 1, 1);
        board.makeMove(0, 2, 1);

        // When
        int winStatus = board.checkWin();

        // Then
        assertEquals(1, winStatus);
    }
}