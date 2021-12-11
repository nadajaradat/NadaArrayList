package com.company;

import com.company.MyAbstractList;

public class MyArrayList<E> extends MyAbstractList {

        static final int capacity = 5;
        E[] arr = (E[]) new Object[capacity];

        @Override
        public void add(Object o) {
            ensureCap();
            arr[getSize()] = (E) o;
            setSize(getSize() + 1);
        }

        @Override
        public boolean add(int idx, Object el) {
            if (idx < 0 || idx > getSize()) {
                //throw new ArrayIndexOutOfBoundsException("index : " + idx);
                return false;
            } else {
                ensureCap();
                for (int i = getSize(); i > idx; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[idx] = (E) el;
                setSize(getSize() + 1);
            }
            return true;

        }

        @Override
        public boolean addall(Object[] c) {
            if (isEmpty()) {
                return false;
            } else {
                // c = (E[]) c;
                for (Object c1 : c) {
                    add(c1);
                }
            }
            return true;
        }

        @Override
        public boolean addall(int idx, Object[] c) {
            if (isEmpty()) {
                return false;
            } else {
                c = (E[]) c;
                for (Object c1 : c) {
                    add(idx, c1);
                    idx++;
                }
            }
            return true;
        }

        @Override
        public void clear() {
            setSize(0);
        }

        @Override
        public boolean equals(Object obj) {
            obj = (E) obj;

            return this == obj;

        }

        @Override
        public boolean equals(Object[] obj) {
            obj = (E[]) obj;

            if (this.getSize() != obj.length) {
                return false;
            }

            boolean b = true;
            for (int i = 0; i < getSize(); i++) {
                if (arr[i] != obj[i]) {
                    b = false;
                }
            }
            return b;
        }

        @Override
        public Object get(int idx) {
            if (idx < 0 || idx > getSize()) {
                throw new ArrayIndexOutOfBoundsException("index : " + idx);
            } else {
                return arr[idx];
            }
        }

        @Override
        public int indexOf(Object o) {
            o = (E) o;
            for (int i = 0; i < getSize(); i++) {
                if (arr[i] == o) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            o = (E) o;
            for (int i = getSize() - 1; i >= 0; i--) {
                if (arr[i] == o) {
                    return i;
                }
            }
            return -1;
        }

        @Override
        public Object remove(int idx) {
            E temp = arr[idx];
            if (isEmpty()) {
                throw new IndexOutOfBoundsException("Index " + idx + " out of bounds for length " + getSize());
            }
            if (idx < 0 || idx > getSize()) {
                throw new ArrayIndexOutOfBoundsException("index : " + idx);
            } else {
                ensureCap();
                for (int i = idx; i < getSize() - 1; i++) {
                    arr[i] = arr[i + 1];
                }
            }
            setSize(getSize() - 1);
            return temp;
        }

        @Override
        public Object[] removeRang(int fromIdx, int toIdx) {
            E[] o = (E[]) new Object[toIdx - fromIdx + 1];

            if (fromIdx < 0 || fromIdx >= getSize() || isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("index : " + fromIdx);
            } else if (toIdx < 0 || toIdx >= getSize()) {
                throw new ArrayIndexOutOfBoundsException("index : " + toIdx);
            } else {
                for (int i = fromIdx; i <= toIdx; i++) {
                    remove(fromIdx);
                    o[i] = arr[fromIdx];
                }
            }
            return o;

        }

        @Override
        public void set(int idx, Object el) {
            if (idx < 0 || idx >= getSize()) {
                throw new ArrayIndexOutOfBoundsException("index : " + idx);
            } else {
                arr[idx] = (E) el;
            }
        }

        @Override
        public Object[] subList(int fromIdx, int toIdx) {
            E[] o = (E[]) new Object[toIdx - fromIdx];

            if (fromIdx < 0 || fromIdx >= getSize() || isEmpty()) {
                throw new ArrayIndexOutOfBoundsException("index : " + fromIdx);
            } else if (toIdx < 0 || toIdx >= getSize()) {
                throw new ArrayIndexOutOfBoundsException("index : " + toIdx);
            } else {
                int j = 0;

                for (int i = fromIdx; i < toIdx; i++) {
                    o[j] = arr[i];
                    j++;
                }
            }
            return o;
        }

        //to resize array
        public void ensureCap() {
            if (getSize() == arr.length) {
                E temp[] = (E[]) new Object[capacity * 2];
                System.arraycopy(arr, 0, temp, 0, arr.length);
                arr = temp;
            }
        }

        @Override
        public boolean contains(Object o) {
            o = (E) o;
            for (int i = 0; i < getSize(); i++) {
                if (arr[i].equals(o)) {
                    return true;
                }
            }
            return false;
        }

        //to check if the array is empty
        @Override
        public boolean isEmpty() {
            return getSize() == 0;
        }

        @Override
        public void trimeToSize() {

            E temp[] = (E[]) new Object[getSize()];
            System.arraycopy(arr, 0, temp, 0, temp.length);
            arr = temp;

        }

        public int removeAll(Object val) {
            int cnt = 0;
            for (int i = 0; arr[i + 1] != null; i++) {

                if (arr[i] == val) {
                    cnt++;
                    int j;
                    for (j = i; arr[j + 1] != null; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[j] = null;

                }
            }
            return cnt;
        }

        //to print array
        @Override
        public String toString() {
            String s = "[";
            for (int i = 0; i < getSize(); i++) {
                s += arr[i];
                if (i != getSize() - 1) {
                    s += ", ";
                }
            }
            return s + "]";
        }

    }


