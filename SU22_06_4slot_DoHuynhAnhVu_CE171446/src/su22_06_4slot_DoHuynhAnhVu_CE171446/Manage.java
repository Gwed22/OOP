/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_06_4slot_DoHuynhAnhVu_CE171446;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class Manage {
//============= THUUOC TINH ===============
    private int matrix1[][];
    private int matrix2[][];
//============= KHOI TAO ================

    /**
     *
     */
    public Manage() {
    }

    /**
     * @param matrix1
     * @param matrix2
     */
    public Manage(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }
//================= GET & SET ============

    /**
     * @return Ma tran thu nhat
     */
    public int[][] getMatrix1() {
        return matrix1;
    }

    /**
     * @param Gan gia tri cho ma tran thu nhat
     */
    public void setMatrix1(int[][] matrix1) {
        this.matrix1 = matrix1;
    }

    /**
     * @return Ma tran thu 2
     */
    public int[][] getMatrix2() {
        return matrix2;
    }

    /**
     * @param Gan gia tri cho ma tran thu hai
     */
    public void setMatrix2(int[][] matrix2) {
        this.matrix2 = matrix2;
    }

}
