package com.solid.algolearning.javacode.algorithms.recursion.patterns.patterns_iterative;

public class Patterns {
    public static void main(String[] args) {
        pattern1(5);
        System.out.println();
        pattern2(4);
        System.out.println();
        pattern3(5);
        System.out.println();
        pattern4(5);
        System.out.println();
        pattern5(5);
        System.out.println();
        pattern5ShortVersion(5);
        System.out.println();
        pattern6(5);
        System.out.println();
        pattern12(5);
        System.out.println();
        pattern28(5);
        System.out.println();
        pattern30(5);
        System.out.println();
        pattern17(5);
        System.out.println();
        pattern31(4);
    }


    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            //when one row is printed, we need to add a new line
            System.out.println();
        }
    }


    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            //when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = n; row >= 1; row--) {
            //for every row, run the column
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            //when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row, run the column
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            //when one row is printed, we need to add a new line
            System.out.println();
        }
    }

    //    row = 2 * n - 1 and row-column relationship is: col = 2 * n - (row - n + 1)
    static void pattern5(int n) {
        for (int row = 1; row < 2 * n; row++) {
            //for every row, run the column
            int col = 0;
            if (row > n) {
                for (col = row - n; col <= row - (row - n + 1); col++) { // 8 - 5 = 3 //7 - (4) = 4   //
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (col = 1; col <= row; col++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    //    row = 2 * n - 1 and row-column relationship is: col = 2 * n - (row - n + 1)
    static void pattern5ShortVersion(int n) {
        for (int row = 1; row < 2 * n; row++) {
            //for every row, run the column
            int totalCols = row > n ? (2 * n - (row + 1)) : row;

            for (int col = 1; col <= totalCols; col++) { // 8 - 5 = 3 //7 - (4) = 4   //
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern6(int n) {
        for (int row = 1; row < n; row++) {
            //for every row, run the column
            int spaces = n - row;
            for (int i = spaces; i > 0; i--) {
                System.out.print(" ");
            }

            for (int col = 1; col <= row; col++) { // 8 - 5 = 3 //7 - (4) = 4   //
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern12(int n){
        int _n = 2 * n;
        for (int row = 0; row <= _n; row++) {
            int c = row < n ? n - row : row - n;
            int spaces = row < n ? row : _n - row;

            //2nd half
            for (int space = spaces; space > 0; space--) {
                System.out.print(" ");
            }

            for (int col = 1; col <= c; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern28(int n) {
        for (int row = 1; row < 2 * n; row++) {
            //for every row, run the column
            int totalCols = row > n ? (2 * n - (row + 1)) : row;

            //print the number of spaces
            int numOfSpaces = n - totalCols;
            for (int s = 0; s < numOfSpaces; s++){
                System.out.print(" ");
            }

            for (int col = 1; col <= totalCols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern17(int n){ //this pattern is the same with pattern 17.

        for(int row = 1; row <= 2 * n; row++){
            int c = row > n ? (2 * n - (row + 1)) : row;   //for the columns since it is changing at a point.
            //we calculate the number of spaces required: in this case, noOfSpaces = n - row
            for (int spaces = 0; spaces < n - c; spaces++) {
                System.out.print("  ");
            }

            for (int col = c; col >= 1 ; col--) { //
                System.out.print(col + " ");
            }

            for (int col = 2; col <= c ; col++) { //
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    //here column is running from row number to 1 and then from 2 to row number
    static void pattern30(int n){ //this pattern is the similar approach with pattern 17.

        for(int row = 1; row <= n; row++){
            //we calculate the number of spaces required: in this case, noOfSpaces = n - row
            for (int spaces = 0; spaces < n - row; spaces++) {
                System.out.print("  ");
            }

            for (int col = row; col >= 1 ; col--) { //
                System.out.print(col + " ");
            }

            for (int col = 2; col <= row ; col++) { //
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }



//    here the total number of rows is (2 * n) - 1, and the total number of columns is also (2 * n) - 1
//    what we need to figure out is: at each level what do we need to print
//    What we did was imagine a wall around the figures, and we checked for each cell in the pattern, the distance
//    from teh left, right top and bottom of the wall and took the minimum as the number to be in that cell
//    So we got that distances: right = col, down = row, up = n - row, left = n - col;
//    whatever these gives us, we pick the minimum and print it in that cell.
    static void pattern31(int n){
        int originalN = n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = originalN - Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
