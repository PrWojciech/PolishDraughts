package board;
import java.util.Scanner;

import pawn.Color;
import pawn.Pawn;

import static java.lang.Integer.parseInt;

public class Board {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int size;
    private Pawn[][] gameBoard;


    public void setGameBoard() {
        System.out.println("Please provide board size");
        Scanner scan = new Scanner(System.in);
        boolean flag = true;
        int size = 0;
        while (flag) {
            size = scan.nextInt();
            if (10 <= size && size <= 20) {
                flag = false;
            } else {
                System.out.println("Invalid value");
            }
        }

        // initialize the board
        Pawn[][] gameboard = new Pawn[size][size];

        // set pawns for player 0
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < gameboard[0].length; x++) {
                if ((x + y) % 2 == 0) { // pawn on even/odd positions
                    gameboard[y][x] = new Pawn(x, y, 0);
                }
            }
        }

        // set pawns for player 1
        int y_offset = gameboard.length - 2;
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < gameboard[0].length; x++) {
                if ((1+x + y) % 2 == 0) { //shifting +1 spot to the right to mirrow upper pawn rows
                    gameboard[y + y_offset][x] = new Pawn(x, y + y_offset, 1);
                }
            }
        }
        this.gameBoard = gameboard;
    }

    public void displayBoard()
    {
        // display header
        for (int x = 0; x < gameBoard[0].length; x++) {
            char col_symbol = (char)('A'+x);
            System.out.print("  "+col_symbol+" ");
        }
        System.out.println("");
        for (int x = 0; x < gameBoard[0].length; x++) {
            System.out.print("----");
        }
        System.out.println("-");


        for (int y = 0; y < gameBoard.length; y++) {
            for (int x = 0; x < gameBoard[0].length; x++) {
                String pawn_symbol = " ";
                if (gameBoard[y][x] != null && gameBoard[y][x].getColor() == Color.BLACK)
                    pawn_symbol = "B";
                if (gameBoard[y][x] != null && gameBoard[y][x].getColor() == Color.WHITE)
                    pawn_symbol = "W";
                System.out.print("| "+pawn_symbol+" ");
            }
            System.out.println("|");
        }
        System.out.println(gameBoard[0][0]);
        System.out.println(gameBoard[9][0]);
        movePawn(1);
    }

    public static void movePawn(int playerID){
        Scanner scan = new Scanner(System.in);
        System.out.println("Specify pawn");
        String pawnPos = scan.next().toUpperCase();
        char posXChar = pawnPos.charAt(0);
        int posXInt = posXChar - 65;
        int posY = parseInt(pawnPos.substring(1))-1;
        System.out.println(posXChar);
        System.out.println(posXInt);
        System.out.println(posY);






    }




}
