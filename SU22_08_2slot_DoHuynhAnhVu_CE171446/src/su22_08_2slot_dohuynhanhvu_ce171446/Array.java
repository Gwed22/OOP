package su22_08_2slot_dohuynhanhvu_ce171446;

import java.util.Random;

/**
 * @author Do Huynh Anh Vu - CE171446
 */
public class Array {

    //============ THUOC TINH ==============
    protected int[] Array;

    //============ KHOI TAO ===============
    public Array() {
    }

    public Array(int[] Array) {
        this.Array = Array;
    }

    //============= GET & SET & toString ============
    /**
     * @return array da duoc luu
     */
    public int[] getArray() {
        return Array;
    }

    /**
     * set array moi
     *
     * @param Array
     */
    public void setArray(int[] Array) {
        this.Array = Array;
    }

    //========= Sort & Search & Display =============
    /**
     * @param Sap xep mang theo selection sort
     */
    public void SelectionSort() {
        for (int i = 0; i < Array.length - 1; i++) {
            int idx = i;                                      //Khoi tao index de so sanh
            for (int j = i + 1; j < Array.length; j++) {
                if (Array[j] < Array[idx]) {              // so sanh de lay gia tri nho nhat
                    idx = j;
                }
            }
            int smallerNumber = Array[idx];
            Array[idx] = Array[i];               //doi vi tri hai phan tu
            Array[i] = smallerNumber;
        }
    }

    /**
     * Tim kiem vi tri cua phan tu can tim trong mang bang binary search
     */
    int BinarySearch(int[] array, int value, int left, int right) {
        if (left > right) {
            return -1;                     // left > rigth (khong ap dung duoc binary search)
        }
        int middle = (left + right) / 2;  // lay phan tu middle
        if (array[middle] == value) {           // middle = gia  tri can tim thi tra ve middle
            return middle;
        } else if (array[middle] > value) {
            return BinarySearch(array, value, left, middle - 1);  //middle > gia tri can tim thi de qui voi mang co idx tu 0 den middle
        } else {
            return BinarySearch(array, value, middle + 1, right);  //middle < gia tri can tim thi de qui voi mang co dai toi da cua mang den middle
        }
    }

    /**
     * @param Ham in cac phan tu trong mang dau vao
     */
    public void display() {
        System.out.print("[");
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i]);
            if (i < Array.length - 1) {          //In tat ca cac phan tu bang vong lap theo format 
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * @param gan gia tri random cho phan tu cua mang
     * @return array da duoc gan gia tri
     */
    public int[] inputValue(int n) {
        Random ran = new Random();
        int[] Array = new int[n];
        for (int i = 0; i < n; i++) {        // Gan gia tri random cho mang
            Array[i] = ran.nextInt(n);
            setArray(Array);        // Luu lai mang
        }
        return Array;
    }
}
