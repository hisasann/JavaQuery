/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.test;

import junit.framework.TestCase;

import com.hisasann.JavaQuery;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class TestCompact extends TestCase{

    public void testCompact() {
        String[] obj = { "a", "b", null, "c" };
        String[] obj2 = JavaQuery.compact(obj);
        System.out.println(obj2[0]);
        System.out.println(obj2[1]);
        System.out.println(obj2[2]);
    }
}

