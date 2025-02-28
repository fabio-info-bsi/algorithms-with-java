package br.com.fabex.dataofstructs;

import static br.com.fabex.algorithms.sorting.Utils.printArray;

public class Heap {

    private int heapSize = 10;

    public Heap(int heapSize) {
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

    private void heapSort(int[] heap) {
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

}
