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
public class TestCapitalize extends TestCase{

    public void testCapitalize1() {
        String str = "test";
        str = JavaQuery.capitalize(str);
        
        System.out.println(str);
        assertEquals(str, "Test");
    }
}
