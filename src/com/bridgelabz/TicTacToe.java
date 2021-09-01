package com.bridgelabz;

import java.util.Locale;
import java.util.Scanner;

public class TicTacToe {
    public static char playerChoice, computerChoice;
    public static final int WIN = 1, LOSE = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe");

        Scanner scanner = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Do you want to play Tic Tac Toe (Y/N)");
            String play = scanner.next().toUpperCase(Locale.ROOT);
            switch (play) {
                case "Y":
                    char[] boardCells = initialisingBoard();
                    int toss = makeToss(scanner);
                    displayBoard(boardCells);
                    if (toss == WIN) {
                        chooseLetter(scanner);
                        playersTurn(scanner, boardCells);
                    } else {
                        computerChoice = 'X';
                        computersTurn(scanner, boardCells);
                    }
                    break;
                case "N":
                    playAgain = false;
                    break;
            }
        }
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

    public static void playersTurn(Scanner scanner, char[] boardCells) {
        while (true) {
            while (true) {
                System.out.println("Player's Turn (1-9): ");
                int movePlayer = scanner.nextInt();

                if (movePlayer == 0 || movePlayer > 10)
                    System.out.println("INVALID INPUT!!!");
                else if (isCellAvailable(boardCells, movePlayer)) {
                    boardCells[movePlayer] = playerChoice;
                    break;

                } else
                    System.out.println("Position is taken");
            }
            displayBoard(boardCells);
            if (gameStatus(boardCells, playerChoice))
                break;

            System.out.println("Computer's Turn : ");

            while (true) {
                if (computerPlayToWin(boardCells))
                    break;
                else if (computerPlayToBlock(boardCells))
                    break;
                else if (noOneWinning(boardCells)) {
                    break;
                }
            }
            displayBoard(boardCells);
            if (gameStatus(boardCells, computerChoice))
                break;
        }
    }

    public static void computersTurn(Scanner scanner, char[] boardCells) {
        while (true) {
            System.out.println("Computer's Turn : ");
            while (true) {
                if (computerPlayToWin(boardCells))
                    break;
                else if (computerPlayToBlock(boardCells))
                    break;
                else if (noOneWinning(boardCells))
                    break;
            }

            displayBoard(boardCells);
            if (gameStatus(boardCells, computerChoice))
                break;

            while (true) {
                System.out.println("Player's Turn (1-9): ");
                int movePlayer = scanner.nextInt();

                if (movePlayer == 0 || movePlayer > 10)
                    System.out.println("INVALID INPUT!!!");

                else if (isCellAvailable(boardCells, movePlayer)) {
                    boardCells[movePlayer] = playerChoice;
                    break;

                } else
                    System.out.println("Position is taken");
            }
            displayBoard(boardCells);
            if (gameStatus(boardCells, playerChoice))
                break;
        }
    }

    public static int makeToss(Scanner scanner) {
        System.out.println("To make a Toss type H or T");
        String tossMade = scanner.next();
        int random = (int) (Math.random() * 2);

        if (WIN == random) {
            System.out.println("YOU WON THE TOSS");
            return WIN;
        } else
            System.out.println("YOU LOST THE TOSS");
        return LOSE;
    }

    public static boolean gameStatus(char[] boardCells, char currentPlayer) {
        return winningCondition(boardCells, currentPlayer) || tieCondition(boardCells);
    }

    private static boolean winningCondition(char[] boardCells, char currentPlayer) {
        if (boardCells[1] != '-' && boardCells[1] == boardCells[2] && boardCells[2] == boardCells[3]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[4] != '-' && boardCells[4] == boardCells[5] && boardCells[5] == boardCells[6]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[7] != '-' && boardCells[7] == boardCells[8] && boardCells[8] == boardCells[9]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[1] != '-' && boardCells[1] == boardCells[4] && boardCells[4] == boardCells[7]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[2] != '-' && boardCells[2] == boardCells[5] && boardCells[5] == boardCells[8]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[3] != '-' && boardCells[3] == boardCells[6] && boardCells[6] == boardCells[9]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[1] != '-' && boardCells[1] == boardCells[5] && boardCells[5] == boardCells[9]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }

        if (boardCells[7] != '-' && boardCells[7] == boardCells[5] && boardCells[5] == boardCells[3]) {
            if (currentPlayer == playerChoice)
                System.out.println("Player Won the game");
            else
                System.out.println("Player LOST the game");
            return true;
        }
        return false;
    }

    private static boolean tieCondition(char[] boardCells) {
        int counter = 0;
        for (int i = 1; i < 10; i++) {
            if (boardCells[i] == 'X' || boardCells[i] == 'O')
                counter++;
        }
        if (counter == 9)
            System.out.println("**TIE**");
        return counter == 9;
    }

    public static boolean computerPlayToWin(char[] boardCells) {
        if (boardCells[1] == '-' && boardCells[2] == computerChoice && boardCells[3] == computerChoice ||
                boardCells[1] == '-' && boardCells[4] == computerChoice && boardCells[7] == computerChoice ||
                boardCells[1] == '-' && boardCells[5] == computerChoice && boardCells[9] == computerChoice) {
            boardCells[1] = computerChoice;
            return true;

        } else if (boardCells[2] == '-' && boardCells[1] == computerChoice && boardCells[3] == computerChoice ||
                boardCells[2] == '-' && boardCells[5] == computerChoice && boardCells[8] == computerChoice) {
            boardCells[2] = computerChoice;
            return true;

        } else if (boardCells[3] == '-' && boardCells[1] == computerChoice && boardCells[2] == computerChoice ||
                boardCells[3] == '-' && boardCells[6] == computerChoice && boardCells[9] == computerChoice ||
                boardCells[3] == '-' && boardCells[5] == computerChoice && boardCells[7] == computerChoice) {
            boardCells[3] = computerChoice;
            return true;

        } else if (boardCells[4] == '-' && boardCells[1] == computerChoice && boardCells[7] == computerChoice ||
                boardCells[4] == '-' && boardCells[5] == computerChoice && boardCells[6] == computerChoice) {
            boardCells[4] = computerChoice;
            return true;

        } else if (boardCells[5] == '-' && boardCells[1] == computerChoice && boardCells[9] == computerChoice ||
                boardCells[5] == '-' && boardCells[2] == computerChoice && boardCells[8] == computerChoice ||
                boardCells[5] == '-' && boardCells[3] == computerChoice && boardCells[7] == computerChoice ||
                boardCells[5] == '-' && boardCells[4] == computerChoice && boardCells[6] == computerChoice) {
            boardCells[5] = computerChoice;
            return true;

        } else if (boardCells[6] == '-' && boardCells[3] == computerChoice && boardCells[9] == computerChoice ||
                boardCells[6] == '-' && boardCells[4] == computerChoice && boardCells[5] == computerChoice) {
            boardCells[6] = computerChoice;
            return true;

        } else if (boardCells[7] == '-' && boardCells[1] == computerChoice && boardCells[4] == computerChoice ||
                boardCells[7] == '-' && boardCells[8] == computerChoice && boardCells[9] == computerChoice ||
                boardCells[7] == '-' && boardCells[5] == computerChoice && boardCells[3] == computerChoice) {
            boardCells[7] = computerChoice;
            return true;

        } else if (boardCells[8] == '-' && boardCells[2] == computerChoice && boardCells[5] == computerChoice ||
                boardCells[8] == '-' && boardCells[7] == computerChoice && boardCells[9] == computerChoice) {
            boardCells[8] = computerChoice;
            return true;

        } else if (boardCells[9] == '-' && boardCells[1] == computerChoice && boardCells[5] == computerChoice ||
                boardCells[9] == '-' && boardCells[3] == computerChoice && boardCells[6] == computerChoice ||
                boardCells[9] == '-' && boardCells[7] == computerChoice && boardCells[8] == computerChoice) {
            boardCells[9] = computerChoice;
            return true;
        }
        return false;
    }

    public static boolean computerPlayToBlock(char[] boardCells) {
        if (boardCells[1] == '-' && boardCells[2] == playerChoice && boardCells[3] == playerChoice ||
                boardCells[1] == '-' && boardCells[4] == playerChoice && boardCells[7] == playerChoice ||
                boardCells[1] == '-' && boardCells[5] == playerChoice && boardCells[9] == playerChoice) {
            boardCells[1] = computerChoice;
            return true;

        } else if (boardCells[2] == '-' && boardCells[1] == playerChoice && boardCells[3] == playerChoice ||
                boardCells[2] == '-' && boardCells[5] == playerChoice && boardCells[8] == playerChoice) {
            boardCells[2] = computerChoice;
            return true;

        } else if (boardCells[3] == '-' && boardCells[1] == playerChoice && boardCells[2] == playerChoice ||
                boardCells[3] == '-' && boardCells[6] == playerChoice && boardCells[9] == playerChoice ||
                boardCells[3] == '-' && boardCells[7] == playerChoice && boardCells[5] == playerChoice) {
            boardCells[3] = computerChoice;
            return true;

        } else if (boardCells[4] == '-' && boardCells[1] == playerChoice && boardCells[7] == playerChoice ||
                boardCells[4] == '-' && boardCells[5] == playerChoice && boardCells[6] == playerChoice) {
            boardCells[4] = computerChoice;
            return true;

        } else if (boardCells[5] == '-' && boardCells[1] == playerChoice && boardCells[9] == playerChoice ||
                boardCells[5] == '-' && boardCells[2] == playerChoice && boardCells[8] == playerChoice ||
                boardCells[5] == '-' && boardCells[3] == playerChoice && boardCells[7] == playerChoice ||
                boardCells[5] == '-' && boardCells[4] == playerChoice && boardCells[6] == playerChoice) {
            boardCells[5] = computerChoice;
            return true;

        } else if (boardCells[6] == '-' && boardCells[3] == playerChoice && boardCells[9] == playerChoice ||
                boardCells[6] == '-' && boardCells[4] == playerChoice && boardCells[5] == playerChoice) {
            boardCells[6] = computerChoice;
            return true;

        } else if (boardCells[7] == '-' && boardCells[1] == playerChoice && boardCells[4] == playerChoice ||
                boardCells[7] == '-' && boardCells[8] == playerChoice && boardCells[9] == playerChoice ||
                boardCells[7] == '-' && boardCells[5] == playerChoice && boardCells[3] == playerChoice) {
            boardCells[7] = computerChoice;
            return true;

        } else if (boardCells[8] == '-' && boardCells[2] == playerChoice && boardCells[5] == playerChoice ||
                boardCells[8] == '-' && boardCells[7] == playerChoice && boardCells[9] == playerChoice) {
            boardCells[8] = computerChoice;
            return true;

        } else if (boardCells[9] == '-' && boardCells[1] == playerChoice && boardCells[5] == playerChoice ||
                boardCells[9] == '-' && boardCells[3] == playerChoice && boardCells[6] == playerChoice ||
                boardCells[9] == '-' && boardCells[7] == playerChoice && boardCells[8] == playerChoice) {
            boardCells[9] = computerChoice;
            return true;
        }
        return false;
    }

    public static boolean noOneWinning(char[] boardCells) {
        if (boardCells[1] == '-') {
            boardCells[1] = computerChoice;
            return true;

        } else if (boardCells[3] == '-') {
            boardCells[3] = computerChoice;
            return true;

        } else if (boardCells[7] == '-') {
            boardCells[7] = computerChoice;
            return true;

        } else if (boardCells[9] == '-') {
            boardCells[9] = computerChoice;
            return true;

        } else if (boardCells[5] == '-') {
            boardCells[5] = computerChoice;
            return true;

        } else if (boardCells[2] == '-') {
            boardCells[2] = computerChoice;
            return true;

        } else if (boardCells[4] == '-') {
            boardCells[4] = computerChoice;
            return true;

        } else if (boardCells[6] == '-') {
            boardCells[6] = computerChoice;
            return true;

        } else if (boardCells[8] == '-') {
            boardCells[8] = computerChoice;
            return true;
        }

        return false;
    }
}