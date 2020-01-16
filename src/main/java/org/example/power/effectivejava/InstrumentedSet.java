package org.example.power.effectivejava;

import java.util.*;

/**
 * @author shenhan
 * @create 2020/1/16 14:23
 * @description
 */
public class InstrumentedSet implements Set {
    private final Set s;
    private int addCount = 0;

    public InstrumentedSet(Set s) {
        this.s = s;
    }

    @Override
    public boolean add(Object o) {
        addCount++;
        return s.add(o);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return s.addAll(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public int getCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedSet s1 = new InstrumentedSet(new TreeSet());
        s1.addAll(Arrays.asList("Spon", "Makkc", "Liiysa"));
        System.out.println(s1.getCount());
    }
}
