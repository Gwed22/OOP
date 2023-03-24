package su22_06_4slot_DoHuynhAnhVu_CE171446;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class SU22_06_4slot_DoHuynhAnhVu_CE171446 {

    private Scanner in = new Scanner(System.in);
    Manage mn = new Manage();

    /**
     * @param input gia tri min, max kiem tra lua chon cua nguoi dung
     * @return
     */
    public int checkChoice(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(in.nextLine());
                if (input < min || input > max) {
                    throw new NumberFormatException(); // Thong bao sai khi nguoi dung nhap so sai dinh dang (1 -> 3)
                } else if (input >= min && input < max) {
                    int[][] matrix1 = inputMatrix(1);
                    int[][] matrix2 = inputMatrix(2); //Chuc nang 1 -> 3 thi cho nhap ma tran
                    mn.setMatrix1(matrix1);
                    mn.setMatrix2(matrix2);
                }
                return input;
            } catch (NumberFormatException ex) {
                System.err.println("You must enter a number from 1 -> 4!");      // Thong bao sai khi nguoi dung nhap chu
            }
        }
    }

    /**
     *
     * @return
     */
    public int checkInt() {
        while (true) {          //Thoat vong lap khi nhap dung dinh dang
            try {
                int result = Integer.parseInt(in.nextLine()); // Nhap mot so integer
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("You must enter an integer!");
                System.out.println("====================================="); // Thong bao  loi va cho nhap lai
                System.out.print("Input again: ");
            }
        }

    }

    /**
     * @param Ham cho nhap ma tran
     * @return ham da nhap
     */
    public int[][] inputMatrix(int n) {
        System.out.print("Enter Row Matrix: ");        // Cho nhap dong va cot cua matrix
        int row = checkInt();                          // Kiem tra du lieu nhap
        System.out.print("Enter Column Matrix: ");
        int col = checkInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = checkInt();
            }
        }
        System.out.println("========================");
        return matrix;
    }

    /**
     * @param In ra ma tran truyen vao
     */
    public void display(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    /**
     * Thuc hien cong hai ma tran va in ket qua ra man hinh
     */
    public void Add() {
        int[][] matrix1 = mn.getMatrix1();
        int[][] matrix2 = mn.getMatrix2();
        display(matrix1);
        System.out.println("+");         // In ra hai ma tran cong nhau
        display(matrix2);
        System.out.println("=");
        int row = matrix1.length;        //Khoi tao so hang cho ma tran ket qua
        int col = matrix1[0].length;     // Khoi tao so cot cho ma tran ket qua
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] + matrix1[i][j]) + "]");   // In ma tran ket qua
            }
            System.out.println("");
        }
    }

    /**
     * Thuc hien tru hai ma tran va in ket qua ra man hinh
     */
    public void Sub() {
        int[][] matrix1 = mn.getMatrix1();
        int[][] matrix2 = mn.getMatrix2();
        display(matrix1);
        System.out.println("-");                 // In ra hai ma tran tru nhau
        display(matrix2);
        System.out.println("=");
        int row = matrix1.length;               //Khoi tao so hang cho ma tran ket qua 
        int col = matrix1[0].length;             //Khoi tao so cot cho ma tran ket qua
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");   // In ma tran ket qua
            }
            System.out.println("");
        }
    }

    /**
     * Thuc hien nhan hai ma tran va in ket qua ra man hinh
     */
    public void Mul() {
        int[][] matrix1 = mn.getMatrix1();
        int[][] matrix2 = mn.getMatrix2();
        int row1 = matrix1.length;                  //Khoi tao so hang cho ma tran 1
        int col1 = matrix1[0].length;               //Khoi tao so cot cho ma tran 1
        int row2 = matrix2.length;                  //Khoi tao so hang cho ma tran 2
        int col2 = matrix2[0].length;               //Khoi tao so cot cho ma tran 2
        if (col1 != row2) {
            System.err.println("Can't multiple"); // Kiem tra dieu kien so cot cua ma tran 1 co bang so hang ma tran 2(dieu kien nhan hai ma tran)
            return;
        }
        display(matrix1);
        System.out.println("*");
        display(matrix2);                          // In ra hai ma tran nhan nhau
        System.out.println("=");

        int[][] matrixResult = new int[row1][col2];    // Khoi tao ma tran ket qua
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];         // Thuc hien nhan hai ma tran
                }
            }
        }
        display(matrixResult);      // in ma tran ket qua
    }

    /**
     *
     */
    public void menu() {
        Manage mn = new Manage();
        while (true) {           // Hien thi menu cho nguoi dung den khi Exit (choice = 4)
            System.out.println("======= Calculator Program ======");
            System.out.println("1. Addition Matrix");
            System.out.println("2. Subtraction Matrix");
            System.out.println("3. Multiplication Matrix");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = checkChoice(1, 4);
            switch (choice) {
                case 1:
                    Add();
                    break;
                case 2:
                    Sub();
                    break;
                case 3:
                    Mul();
                    break;
                case 4:
                    return;
            }
        }
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        SU22_06_4slot_DoHuynhAnhVu_CE171446 su = new SU22_06_4slot_DoHuynhAnhVu_CE171446();
        su.menu();      // Khoi tao obj goi ham menu xu li chuong trinh
    }
}
