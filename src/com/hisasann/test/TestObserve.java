/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.test;

import junit.framework.TestCase;

import com.hisasann.$;
import com.hisasann.util.Observer;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class TestObserve extends TestCase {

    /**
     * @param args
     */
    public void testObserve() {
        ObserveModel model = new ObserveModel();

        $.make(model)
            .observe(new Observer() {
                public void update() {
                    System.out.println("change1");
                }
            })
            .observe(new Observer() {
                public void update() {
                    System.out.println("change2");
                }
            });

        model.setMessage("hoge");
    }
}
