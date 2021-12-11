package com.company;

public abstract class MyAbstractList<E> {

        private int size = 0;

        //set & get size
        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public abstract void add(E e);

        public abstract boolean add(int idx, E el);

        public abstract boolean addall(E[] c);

        public abstract boolean addall(int idx, E[] c);

        public abstract void clear();

        public abstract boolean equals(Object o);

        public abstract boolean equals(Object[] o);

        public abstract E get(int idx);

        public abstract int indexOf(E o);

        public abstract int lastIndexOf(Object o);

        public abstract E remove(int idx);

        public abstract E[] removeRang(int fromIdx, int toIdx);

        public abstract void set(int idx, E el);

        public abstract E[] subList(int fromIdx, int toIdx);

        public abstract boolean contains(E e);

        public abstract boolean isEmpty();

        public abstract void trimeToSize();
    }


