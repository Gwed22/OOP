package su22_06_2slot_dohuynhanhvu_ce171446;

/*
 * @author Do Huynh Anh Vu   CE171446
 */
/**
 *
 * @author Dell
 */
public class Sort {

    //========== THUOC TINH ============
    private int[] Sort;
    private int Size;

    //========== KHOI TAO ===============
    /**
     *
     * @param Sort
     * @param Size
     */
    public Sort(int[] Sort, int Size) {
        this.Sort = Sort;
        this.Size = Size;
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

    /**
     *
     * @return lay gia tri do dai cua mang
     */
    public int getSize() {
        return Size;
    }

    /**
     *
     * @param gan gia tri Size cho mang
     */
    public void setSize(int Size) {
        this.Size = Size;
    }

    public void SelectionSort(int [] Sort) {
        System.out.print("Unsorted array: ");
        System.out.print("{");
        for (int i = 0; i < Sort.length - 1; i++) {    //In mang chua sort ra man hinh
            System.out.print(Sort[i] + ", ");
        }
        System.out.print(Sort[Sort.length - 1]);
        System.out.print("}\n");
        for (int i = 0; i < Sort.length - 1; i++) {
            int idx = i;                                      //Khoi tao index de so sanh
            for (int j = i + 1; j < Sort.length; j++) {
                if (Sort[j] < Sort[idx]) {              // so sanh de lay gia tri nho nhat
                    idx = j;
                }
            }
            int smallerNumber = Sort[idx];
            Sort[idx] = Sort[i];               //doi vi tri hai phan tu
            Sort[i] = smallerNumber;
        }
    }

    @Override
    public String toString() {
        return "Sort{" + "Sort=" + Sort + '}';
    }
}
