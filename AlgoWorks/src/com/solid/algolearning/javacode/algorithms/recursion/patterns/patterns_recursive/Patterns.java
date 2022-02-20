package com.solid.algolearning.javacode.algorithms.recursion.patterns.patterns_recursive;

public class Patterns {
    public static void main(String[] args) {
        pattern1(5, 0);
        System.out.println();
        pattern2(5, 0);
        System.out.println();
        System.out.println();
        printNRowsOfStarsIterative(5);
        System.out.println();
        System.out.println();
        printNRowsOfStarsRecursive(5, 0);
        System.out.println();
        System.out.println();
        printNRowsOfStarsRecursive2(5);
    }

    static void pattern1(int row, int col) {
        if (row == 0) return;

        if (col < row) {
            System.out.print("* ");
            pattern1(row, col + 1);
        } else {
            System.out.println();
            pattern1(row - 1, 0);
        }
    }

    static void pattern2(int row, int col) {
        if (row == 0) return;

        if (col < row) {
            pattern2(row, col + 1);
            System.out.print("* ");
        } else {
            pattern2(row - 1, 0);
            System.out.println();
        }
    }

    static void printNRowsOfStarsIterative(int n) {
        for (int row = 1; row <= n; row++) {
            for (int j = 1; j <= row; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void printNRowsOfStarsRecursive(int n, int current) {
        if (current == n) {
          return;
        }

        printNRowsOfStarsRecursive(n ,current + 1);

        for (int i = 0; i <= current; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    static void printNRowsOfStarsRecursive2(int n) {
        if (n == 0) {
            return;
        }

        printNRowsOfStarsRecursive2(n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
