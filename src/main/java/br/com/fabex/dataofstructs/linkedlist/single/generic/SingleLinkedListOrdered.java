package br.com.fabex.dataofstructs.linkedlist.single.generic;

public class SingleLinkedListOrdered<T extends Comparable<T>> extends SingleLinkedList<T> {

    @Override
    public void insert(Element<T> pointer, Element<T> element) {
        throw new UnsupportedOperationException("Unsupported in Ordered LinkedList");
    }

    /**
     * Ordered insertion.
     *
     * @param element
     */
    @Override
    public void prepend(Element<T> element) {
        Element<T> pointer = head;

        // First element
        if (null == pointer) {
            super.prepend(element);
            return;
        }

        Element<T> prev = null;
        while (element.getKey().compareTo(pointer.getKey()) > 0 && pointer.next != null) {
            prev = pointer;
            pointer = pointer.next;
        }

        if (pointer.getKey().compareTo(element.getKey()) < 0) {
            super.insert(pointer, element);
        } else {
            if (null != prev && prev.getKey().compareTo(element.getKey()) < 0) {
                super.insert(prev, element);
            } else {
                super.prepend(element);
            }
        }
    }
}
