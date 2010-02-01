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
public class TestCamelize extends TestCase{

    public void testCamelize1() {
        String str = "background-color";
        str = JavaQuery.camelize(str);
        
        System.out.println(str);
        assertEquals(str, "backgroundColor");
    }

    public void testCamelize2() {
        String str = "background-color-black";
        str = JavaQuery.camelize(str);
        
        System.out.println(str);
        assertEquals(str, "backgroundColorBlack");
    }
}
