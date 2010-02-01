/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.hisasann.JavaQuery;
import com.hisasann.util.Function;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class TestEach extends TestCase {

    public void testEach() {

        final List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");

        JavaQuery.each(list, new Function() {
            public void exec(int index, Object elem) {
                System.out.println(list.get(0)); // 上のスコープもみえちゃうよ、そのときはfinal必須
                System.out.println(index + " : " + elem);
            }
        });
    }

    public void testEach2() {

        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);

        JavaQuery.each(list, new Function() {
            public void exec(int index, Object elem) {
                System.out.println(index + " : " + elem);
            }
        });
    }

    public void testEach3() {

        String[] list = { "a", "b", "c" };

        JavaQuery.each(list, new Function() {
            public void exec(int index, Object elem) {
                System.out.println(index + " : " + elem);
            }
        });
    }

    public void testEach4() {

        Integer[] list = { 10, 20, 30 };

        JavaQuery.each(list, new Function() {
            public void exec(int index, Object elem) {
                System.out.println(index + " : " + elem);
            }
        });
    }
}
