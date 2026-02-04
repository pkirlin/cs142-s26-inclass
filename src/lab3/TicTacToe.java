package lab3;

import java.awt.*;

/** The three-in-a-row game for two human players. */
public class TicTacToe {

    /** Plays the game. */
    public static void main(String[] args) {
        // Set up the canvas, 300 by 300 pixels, and make it visible on the screen.
        SimpleCanvas canvas = new SimpleCanvas(300, 300);
        canvas.show();

        // Set up the board, represented as a 2-d grid of chars.
        // 'X' and 'O' are used for the two players, and a space char ' ' is used for an empty space on the board.
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }

        char currentPlayer = 'X';   // X player plays first.
        draw(canvas, board);        // Draw the board on the screen.
        while (!gameOver(board)) {
            handleMouseClick(canvas, board, currentPlayer);     // Let the user click a square.
            currentPlayer = opposite(currentPlayer);            // Switch to opposite player.
            draw(canvas, board);                                // Re-draw the board.
        }
    }

    /**
     * Draws the state of board on the canvas, including a game over message if applicable.
     */
    public static void draw(SimpleCanvas canvas, char[][] board) {
        canvas.clear();
        canvas.setPenColor(Color.BLACK);
        canvas.drawLine(0, 100, 300, 100);
        canvas.drawLine(0, 200, 300, 200);
        canvas.drawLine(100, 0, 100, 300);
        canvas.drawLine(200, 0, 200, 300);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int centerX = 100 * col + 50;
                int centerY = 100 * row + 50;
                if (board[row][col] == 'X') {
                    canvas.setPenColor(Color.RED);
                    canvas.drawFilledCircle(centerX, centerY, 50);
                }
                else if (board[row][col] == 'O') {
                    canvas.setPenColor(Color.BLUE);
                    canvas.drawFilledCircle(centerX, centerY, 50);
                }
            }
        }
        canvas.setPenColor(Color.BLACK);
        char whoWins = winner(board);
        if (whoWins != '-') {
            canvas.drawStringCentered(150, 150, whoWins + " wins!", 40);
        } else if (isFull(board)) {
            canvas.drawStringCentered(150, 150, "Tie game!", 40);
        }
        canvas.update(); // like .show(), but for when the canvas is already visible.
    }

    /** Returns true if the game is over. */
    public static boolean gameOver(char[][] board) {
        return (winner(board) != '-') || isFull(board);
    }

    /**
     * Waits for a mouse click on the screen, then places currentPlayer's mark in the square on which the
     * user clicks.
     */
    public static void handleMouseClick(SimpleCanvas canvas, char[][] board, char currentPlayer) {
        boolean madeValidMove = false;
        while (!madeValidMove) {
            canvas.waitForClick();

            int mouseX = canvas.getMouseClickX();
            int mouseY = canvas.getMouseClickY();

            int row = mouseY / 100;
            int col = mouseX / 100;

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                madeValidMove = true;
            }
        }
    }

    /** Returns true if board is full. */
    public static boolean isFull(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /** Returns the opposite player's character. */
    public static char opposite(char player) {
        if (player == 'X') {
            return 'O';
        } else {
            return 'X';
        }
    }

    /**
     * Returns the character ('X' or 'O') of the winning player, or '-' if there
     * is no winner.
     */
    public static char winner(char[][] board) {

        // Section A
        for (int row = 0; row < board.length; row++) {
            boolean allMatch = true;
            for (int col = 1; col < board[0].length; col++) {
                if (board[row][col] != board[row][0]) {
                    allMatch = false;
                    break;
                }
            }
            if (board[row][0] != ' ' && allMatch) {
                return board[row][0];
            }
        }

        // Section B
        for (int col = 0; col < board[0].length; col++) {
            boolean allMatch = true;
            for (int row = 1; row < board.length; row++) {
                if (board[row][col] != board[0][col]) {
                    allMatch = false;
                    break;
                }
            }
            if (board[0][col] != ' ' && allMatch) {
                return board[0][col];
            }
        }

        // Section C
        boolean allMatch = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][row] != board[0][0]) {
                allMatch = false;
                break;
            }
        }
        if (board[0][0] != ' ' && allMatch) {
            return board[0][0];
        }

        // Section D
        int col = board[0].length - 1;
        allMatch = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] != board[0][board[0].length-1]) {
                allMatch = false;
                break;
            }
            col--;
        }
        if (board[0][board[0].length-1] != ' ' && allMatch) {
            return board[0][board[0].length-1];
        }

        return '-';
    }

}