package bubblesort;

/**
 * @author Do Huynh Anh Vu CE171446
 */
public class BubbleSort {
    //============== THUOC TINH =================

    private int value;
    //=============== KHOI TAO ===================

    public BubbleSort(int value) {
        this.value = value;
    }

    public BubbleSort() {
    }
    //=============== GET & SET & toString ===========

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + value + "]";
    }

}
