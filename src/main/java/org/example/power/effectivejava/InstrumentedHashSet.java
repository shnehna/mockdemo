package org.example.power.effectivejava;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author shenhan
 * @create 2020/1/16 14:13
 * @description
 */
public class InstrumentedHashSet extends HashSet {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(Collection c) {
        super(c);
    }

    public InstrumentedHashSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public boolean add(Object o) {
        addCount++;
        return super.add(o);
    }

    @Override
    public boolean addAll(Collection c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet instrumentedHashSet = new InstrumentedHashSet();
        instrumentedHashSet.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(instrumentedHashSet.getAddCount());
    }
}
