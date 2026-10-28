package com.survivalcoding;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CountingUnitSet {
    private final Set<String> set = new HashSet<>();
    private int addCount = 0;

    public boolean add(String unitName) {
        addCount++;
        return set.add(unitName);
    }

    public boolean addAll(Collection<? extends String> unitNames) {
        addCount += unitNames.size();
        return set.addAll(unitNames);
    }

    public int getAddCount() {
        return addCount;
    }
}