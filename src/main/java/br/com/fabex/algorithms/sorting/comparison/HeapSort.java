package br.com.fabex.algorithms.sorting.comparison;

import static br.com.fabex.util.ArrayUtils.printArray;

public class HeapSort {

    private int heapSize;

    public HeapSort(int heapSize) {
        this.heapSize = heapSize;
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
        return heapSize != 0 ? heapSize - 1 : 0;
    }

    private void buildHeap(int[] heap) {
        heapSize = heap.length;
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

    public void sort(int[] heap) {
        buildHeap(heap);
        for (int i = heap.length - 1; i >= 1; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            heapSize--;
            heapify(heap, 0);
        }
    }

    private void heapInsert(int[] heap, int key) {
        heapSize++;
        int i = heapSize();
        while (i > 0 && heap[parentIndex(i)] < key) {
            heap[i] = heap[parentIndex(i)];
            i = parentIndex(i);
        }
        heap[i] = key;
    }

    private void heapInsert(int[] heap, int... keys) {
        for (int key : keys)
            heapInsert(heap, key);
    }

    private int heapExtractMax(int[] heap) {
        if (heapSize() < 0) {
            throw new RuntimeException("Heap underflow");
        }
        int max = heap[0];
        heap[0] = heap[heapSize()];
        heapSize--;
        heapify(heap, 0);
        return max;
    }

    public static void main(String[] args) {
        HeapSort heapSort;
        int[] ints;
        //ints = new int[]{31, 26, 36, 38, 12, 1, 2, 10, 11, 8}; //38 31 36 26 12 1 2 10 11 8
        ints = new int[]{31, 26, 36, 38, 12}; //38 31 36 26 12
        //ints = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1}; //16 14 10 8 7 9 3 2 4 1
        //printArray(ints);
        new HeapSort(ints.length).buildHeap(ints);
        printArray(ints);
        new HeapSort(ints.length).sort(ints);
        printArray(ints);

        System.out.println(" - - - - - - - ");
        ints = new int[10];
        printArray(new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1});
        new HeapSort(0).heapInsert(ints, 16, 4, 10, 14, 7, 9, 3, 2, 8, 1);
        printArray(ints);
        new HeapSort(ints.length).sort(ints);
        System.out.println(" - - - - - - - ");
        ints = new int[5];
        heapSort = new HeapSort(0);
        heapSort.heapInsert(ints, 31);
        heapSort.heapInsert(ints, 26);
        heapSort.heapInsert(ints, 36);
        heapSort.heapInsert(ints, 38);
        heapSort.heapInsert(ints, 12);
        printArray(ints);
        new HeapSort(ints.length).sort(ints);
        printArray(ints);
        System.out.println(" - - - - - - - ");
        ints = new int[]{31, 26, 36, 38, 12};
        heapSort = new HeapSort(ints.length);
        printArray(ints);
        heapSort.buildHeap(ints);
        System.out.println("Max: " + heapSort.heapExtractMax(ints));
        printArray(ints, heapSort.heapSize());
    }
}
