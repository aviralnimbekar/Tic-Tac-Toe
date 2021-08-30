package com.bridgelabz;

import java.util.Locale;
import java.util.Scanner;

public class TicTacToe {
    public static char playerChoice;
    public static char computerChoice;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public static void initialisingBoard() {
        char[] emptyBoardCells = new char[10];
        for (int i = 0; i < 10; i++) {
            emptyBoardCells[i] = ' ';
        }
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
}
