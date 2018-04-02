package second;

public class OrdArray {

    private double[] a;

    private int nElems;

    public OrdArray(int max) {

        a = new double[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    /**
     * 二分探索
     *
     * @param searchKey
     * @return
     */
    public int find(double searchKey) {

        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;
            } else {
                if (a[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    public void insert(double value) {
        int j;
        for (j = 0; j < nElems; j++)
            if (a[j] > value) break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k-1];
        a[j] = value;
        nElems++;
    }

    public boolean delete(double value) {

        int j = find(value);
        if (j == nElems) return false;

        for (int k = j; k < nElems - 1; k++) {
            a[k] = a[k + 1];
        }

        nElems--;
        return true;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.println(a[j] + " ");
        System.out.println("");
    }
}