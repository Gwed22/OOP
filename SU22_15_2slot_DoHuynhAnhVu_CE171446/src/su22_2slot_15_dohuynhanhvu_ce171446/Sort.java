package su22_2slot_15_dohuynhanhvu_ce171446;

/*
 * @author Do Huynh Anh Vu   CE171446
 */

public class Sort {

    //========== THUOC TINH ============
    private int[] Sort;

    //========== KHOI TAO ===============
    /**
     *
     * @param Sort
     */
    public Sort(int[] Sort) {
        this.Sort = Sort;
    }

    /**
     *
     */
    public Sort() {
    }
    //=========== GET & SET & toString

    /**
     *
     * @return array mang dang xu li
     */
    public int[] getSort() {
        return Sort;
    }

    /**
     *
     * @param gan gia tri moi cho mang Sort
     */
    public void setSort(int[] Sort) {
        this.Sort = Sort;
    }

    /*
    * Method to sort the array by insertion sort
     */
    public void InsertionSort() {
        System.out.print("Unsorted array: [");
        for (int i = 0; i < Sort.length-1; i++) {
            System.out.print(Sort[i] + ", ");
        }
        System.out.print(Sort[Sort.length-1]);
        System.out.println("]");
        for (int i = 1; i < Sort.length; i++) {
            int key = Sort[i];
            int j = i - 1;

            while (j >= 0 && Sort[j] > key) {  //Di chuyen phan tu > key cua mang, toi vi tri tiep theo
                Sort[j + 1] = Sort[j];       // Lap toi khi nao gia tri ben trai <= key
                j--;
            }
            Sort[j + 1] = key;
        }
    }

    /**
     * In ra mang da Sort theo format
     */
    public void display() {
        System.out.print("Sorted array: [");
        for (int i = 0; i < getSort().length - 1; i++) { //In tung phan tu cua mang
            System.out.print(getSort()[i] + ", ");
        }
        System.out.print(getSort()[getSort().length - 1]);
        System.out.print("]\n");
    }
}
