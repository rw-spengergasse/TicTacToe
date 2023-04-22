import java.util.Random;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        String name;
        char symbol;

        Player player1, player2;
        Player[] players;

        int currentPlayer; // 1/2
        int gameStatus = 0;

        Board board = new Board(3);
        Scanner scanner = new Scanner(System.in);

        // Read player 1 name, char
        System.out.println("Player 1 Name: ");
        name = scanner.nextLine();

        System.out.println("Player 1 Symbol");
        symbol = scanner.nextLine().charAt(0);
        player1 = new Player(name, symbol);

        // Read player 2 name, char
        System.out.println("Player 2 Name: ");
        name = scanner.nextLine();

        System.out.println("Player 2 Symbol: ");
        symbol = scanner.nextLine().charAt(0);
        player2 = new Player(name, symbol);

        // Array of player 1/2
        players = new Player[] { player1, player2 };

        // currentPlayer = Random player1/2
        currentPlayer = new Random().nextInt(2);


        while (gameStatus == 0)
        {
            board.print();

            // Current Player
            System.out.printf("%s turn\n", players[currentPlayer].getName());

            System.out.println("row");
            int row = scanner.nextInt();

            System.out.println("column");
            int col = scanner.nextInt();

            gameStatus = board.makeMove(row, col, currentPlayer+1);

            // switchPlayer
            currentPlayer = (currentPlayer+1) % 2;
        }

        board.print();

        if (gameStatus == -1)
            System.out.println("Nobody won");
        else
            System.out.printf("Player %s won", players[gameStatus - 1].getName());
    }
}
