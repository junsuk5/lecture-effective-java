package com.survivalcoding;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BigDecimalSetDemo {
    public static void main(String[] args) {
        Set<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(new BigDecimal("1.0"));
        hashSet.add(new BigDecimal("1.00"));

        Set<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(new BigDecimal("1.0"));
        treeSet.add(new BigDecimal("1.00"));

        System.out.println(hashSet.size());
        System.out.println(treeSet.size());
    }
}