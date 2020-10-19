package 排序.sort;

import 排序.assist.CountingSort;
import 排序.assist.RadixSort;

import java.text.DecimalFormat;
import java.util.Comparator;

public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {
    protected T[] array;
    private Comparator<T> comparator;
    private int cmpCount;
    private int swapCount;
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(T[] arr) {
        if (arr == null || arr.length < 2) return;
        this.array = arr;

        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    @Override
    public int compareTo(Sort<T> o) {
        int result = (int) (time - o.time);
        if (result != 0) return result;

        result = cmpCount - o.cmpCount;
        if (result != 0) return result;

        return swapCount - o.swapCount;
    }

    protected abstract void sort();

    protected int cmp(T o1, T o2) {
        cmpCount++;
        if (comparator != null) return comparator.compare(o1, o2);
            //否则，默认传入的对象实现了可比较
        else return ((Comparable<T>) o1).compareTo(o2);
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        T temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }

    private boolean isStable() {
        if (this instanceof RadixSort) return true;
        if (this instanceof CountingSort) return true;
//        if (this instanceof ShellSort) return false;
        if (this instanceof SelectionSort) return false;
        if (this instanceof HeapSort) return false;
//        Student[] students = new Student[20];
//        for (int i = 0; i < students.length; i++) {
//            students[i] = new Student(i * 10, 10);
//        }
//        sort((T[]) students);
//        for (int i = 1; i < students.length; i++) {
//            int score = students[i].score;
//            int prevScore = students[i - 1].score;
//            if (score != prevScore + 10) return false;
//        }
        return true;
    }
}
