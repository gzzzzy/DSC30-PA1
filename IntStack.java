package DSC30.PA1;

/*
    Name: Zhiyu Gao
    PID:  A17245309
 */

import java.util.EmptyStackException;

/**
 * @author Zhiyu Gao
 * @since 8/4/2021
 * @version 1.0.0
 */
public class IntStack {

    /* instance variables, feel free to add more if you need */
    private int[] data;
    private int nElems = 0;
    private double loadFactor = 0.75;
    private double shrinkFactor = 0.25;
    private int initCapacity;
    private int capacity_;

    public IntStack(int capacity, double loadF, double shrinkF) {
        /*
         * Constructor
         * @throws IllegalArgumentException .
         * @param:
         *      capacity: int, set the initial capacity of stack.
         *      loadF: double, set the loadFactor of stack.
         *      shrinkF: double, set the shrinkFactor of stack.
         */
        if (capacity < 5 || loadF < 0.67 || loadF > 1 || shrinkF <= 0 || shrinkF > 0.33) {
            throw new IllegalArgumentException();
        }
        loadFactor = loadF;
        shrinkFactor = shrinkF;
        nElems = 0;
        initCapacity = capacity;
        capacity_ = capacity;
        data = new int[initCapacity];
    }

    public IntStack(int capacity, double loadF) {
        /**
         * Constructor that initializes a stack with the given initial capacity, 
         * the given load factor, and the default shrink factor (0.25). 
         */
        this(capacity, loadF, 0.25);
    }

    public IntStack(int capacity) {
        /**
         * Constructor that initializes a stack with the given initial capacity, 
         * the default load factor (0.75), and the default shrink factor (0.25). 
         */
        this(capacity, 0.75, 0.25);
    }

    public boolean isEmpty() {
        /**
         * Checks if the stack is empty.
         * @return: boolean, true if stack is empty, false otherwise.
         */
        if (nElems != 0) {
            return false;
        }
        return true;
    }

    public void clear() {
        /**
         * Clears all elements in the stack.
         */
        data = new int[initCapacity];
        capacity_ = initCapacity;
        nElems = 0;
    }

    public int size() {
        /**
         * @return: int, the number of elements currently stored in the stack.
         */
        return nElems;
    }

    public int capacity() {
        /**
         * @return: int, the maximum number of elements the stack currently can store.
         */
        return capacity_;
    }

    public int peek() {
        /**
         * @return: int, the top element of the stack.
         * @throws EmptyStackException if the stack is empty.
         */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data[nElems - 1];
    }

    public void push(int element) {
        /**
         * @param: 
         *      element: int, the element which is pushed into the stack.
         * Double the capacity of the stack before pushing the element if the condition meets.
         */
        if ((double) nElems / capacity_ >= loadFactor) {
            capacity_ *= 2;
            int[] new_data = new int[capacity_];
            System.arraycopy(data, 0, new_data, 0, nElems);
            data = new_data;
        }
        data[nElems++] = element;
    }

    public int pop() {
        /** 
         * @return: int, the element which is popped.
         * @throws EmptyStackException if the stack is empty.
         * Half the capacity of the stack after popping the element if the condition meets. 
         * If after shrinking, the stack will be smaller than the initial capacity, resize it to the initial capacity.
         */
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int ele = data[--nElems];
        if ((double) nElems / capacity_ <= shrinkFactor) {
            if (capacity_ / 2 >= initCapacity) {
                capacity_ /= 2;
                int[] new_data = new int[capacity_];
                System.arraycopy(data, 0, new_data, 0, nElems);
                data = new_data;
            }
        }
        return ele;
    }

    public void multiPush(int[] elements) {
        /** 
         * @param:
         *      elements: int[], an array is to be pushed into the stack.
         * @throws IllegalArgumentException.
         */
        if (elements.length == 0) {
            throw new IllegalArgumentException();
        }
        int len = elements.length;
        for (int i = 0; i < len; ++i) {
            push(elements[i]);
        }
    }

    public int[] multiPop(int amount) {
        /** 
         * @param:
         *      amount: int, the number of elements to be popped.
         * @return: int[], an array contains all the popped elements.
         * @throws IllegalArgumentException.
         * If the stack does not have the given amount of elements, pop all elements from the stack.
         */
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        int n = amount < nElems ? amount : nElems;
        int[] re = new int[n];
        for (int i = 0; i < n; ++i) {
            re[i] = pop();
        }
        return re;
    }
}
