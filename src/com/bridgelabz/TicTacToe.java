package com.bridgelabz;

import java.util.Locale;
import java.util.Scanner;

public class TicTacToe {
    public static char playerChoice, computerChoice;
    public static final int WIN = 1, LOSE = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int toss = makeToss(scanner);
        if (toss == WIN)
            chooseLetter(scanner);
        else
            computerChoice = 'X';

        char[] boardCells = initialisingBoard();
        displayBoard(boardCells);
        makeMoveToDesireCell(scanner, boardCells);
    }

    public static char[] initialisingBoard() {
        char[] emptyBoardCells = new char[10];
        for (int i = 0; i < 10; i++)
            emptyBoardCells[i] = '-';

        return emptyBoardCells;
    }

    public static void chooseLetter(Scanner scanner) {
        System.out.println("Which one you want go with ?\n" +
                "'X' or 'O'");
        while (true) {
            char letter = scanner.next().toUpperCase(Locale.ROOT).charAt(0);
            if (letter == 'X' || letter == 'O') {
                playerChoice = letter;
                computerChoice = (letter == 'X') ? 'O' : 'X';
                break;
            } else
                System.out.println("INVALID INPUT!!!");
        }
    }

    public static void displayBoard(char[] boardCells) {
        System.out.println(boardCells[1] + "|" + boardCells[2] + "|" + boardCells[3]
                + "\n" + boardCells[4] + "|" + boardCells[5] + "|" + boardCells[6]
                + "\n" + boardCells[7] + "|" + boardCells[8] + "|" + boardCells[9]);
    }

    public static boolean isCellAvailable(char[] boardCells, int index) {
        return boardCells[index] == '-';
    }

    public static void makeMoveToDesireCell(Scanner scanner, char[] boardCells) {
        while (true) {
            System.out.println("Player's Turn : ");
            int movePlayer = scanner.nextInt();

            if (movePlayer == 0 || movePlayer > 10)
                System.out.println("INVALID INPUT!!!");
            else if (isCellAvailable(boardCells, movePlayer))
                boardCells[movePlayer] = playerChoice;
            else
                System.out.println("Position is taken");

            displayBoard(boardCells);
        }
    }

    public static int makeToss(Scanner scanner) {
        System.out.println("To make a Toss type H or T");
        String tossMade = scanner.next();
        int random = (int) (Math.random() * 2);

        if (WIN == random) {
            System.out.println("WON");
            return WIN;
        } else
            System.out.println("LOST");
        return LOSE;
    }
}