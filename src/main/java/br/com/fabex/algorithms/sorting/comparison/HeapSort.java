package br.com.fabex.algorithms.sorting.comparison;

public class HeapSort {

    int[] heapInternal;
    private int heapSizeInternal = 0;

    public HeapSort(int length) {
        this(length, 0);
    }

    public HeapSort(int[] heap) {
        this.heapInternal = new int[heap.length];
        System.arraycopy(heap, 0, this.heapInternal, 0, heap.length);
    }

    public HeapSort(int[] heap, int heapSizeInternal) {
        this.heapInternal = heap;
        this.heapSizeInternal = heapSizeInternal;
    }

    public HeapSort(int length, int heapSizeInternal) {
        this.heapInternal = new int[length];
        this.heapSizeInternal = heapSizeInternal;
    }

    private int parentIndex(int index) {
        return index > 0 ? (index - 1) / 2 : index / 2;
    }

    private int leftIndex(int index) {
        return (2 * index) + 1;
    }

    private int rightIndex(int index) {
        return (2 * index) + 2;
    }

    private int heapSize() {
        return heapSizeInternal != 0 ? heapSizeInternal - 1 : 0;
    }

    private void buildHeap(int[] heap) {
        heapSizeInternal = heap.length;
        for (int i = (heap.length / 2) - 1; i >= 0; i--) {
            heapify(heap, i);
        }
    }

    private void heapify(int[] heap, int index) {
        int indexLeft = leftIndex(index), indexRight = rightIndex(index), largest;

        if (indexLeft <= heapSize() && heap[indexLeft] > heap[index]) {
            largest = indexLeft;
        } else {
            largest = index;
        }

        if (indexRight <= heapSize() && heap[indexRight] > heap[largest]) {
            largest = indexRight;
        }

        if (largest != index) {
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapify(heap, largest);
        }
    }

    private void sortImpl(int[] heap) {
        buildHeap(heap);
        for (int i = heap.length - 1; i >= 1; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapSizeInternal--;
            heapify(heap, 0);
        }
    }

    private void heapInsert(int key) {
        heapSizeInternal++;
        int i = heapSize();
        while (i > 0 && heapInternal[parentIndex(i)] < key) {
            heapInternal[i] = heapInternal[parentIndex(i)];
            i = parentIndex(i);
        }
        heapInternal[i] = key;
    }

    public void heapInsert(int... keys) {
        for (int key : keys)
            heapInsert(key);
    }

    public int[] sort() {
        this.sortImpl(heapInternal);
        return this.heapInternal;
    }

    private int heapExtractMaxImpl(int[] heap) {
        if (heapSize() < 0) {
            throw new RuntimeException("Heap underflow");
        }
        int max = heap[0];
        heap[0] = heap[heapSize()];
        heapSizeInternal--;
        heapify(heap, 0);
        return max;
    }

    public static void sort(int[] heap) {
        new HeapSort(heap.length).sortImpl(heap);
    }

    public static int heapExtractMax(int[] heap) {
        HeapSort heapSort = new HeapSort(heap.length);
        heapSort.buildHeap(heap);
        return heapSort.heapExtractMaxImpl(heap);
    }
}
