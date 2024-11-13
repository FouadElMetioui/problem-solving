package com.letcode.java.medium;

import java.util.HashSet;
import java.util.Set;

public class isValidSudoku {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] grid1 = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] grid3 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };


        System.out.println(isValidSudoku(grid3));
    }

    public static boolean isValidSudoku(char[][] board) {
        // Vérification des lignes et colonnes
        for (int i = 0; i < 9; i++) {
            int countRow = 0, countCol = 0;
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    ++countRow;
                    row.add(Character.getNumericValue(board[i][j]));
                }
                if (board[j][i] != '.') {
                    ++countCol;
                    col.add(Character.getNumericValue(board[j][i]));
                }
            }
            if (row.size() != countRow || col.size() != countCol) {
                System.out.println("Erreur dans les lignes ou colonnes");
                return false;
            }
        }

        // Vérification des blocs 3x3
        for (int blockRow = 0; blockRow < 9; blockRow += 3) {
            for (int blockCol = 0; blockCol < 9; blockCol += 3) {
                Set<Integer> block = new HashSet<>();
                int count = 0;

                for (int i = blockRow; i < blockRow + 3; i++) {
                    for (int j = blockCol; j < blockCol + 3; j++) {
                        if (board[i][j] != '.') {
                            count++;
                            block.add(Character.getNumericValue(board[i][j]));
                        }
                    }
                }
                if (block.size() != count) {
                    System.out.println("Erreur dans le bloc 3x3");
                    return false;
                }
            }
        }

        return true;
    }

}
