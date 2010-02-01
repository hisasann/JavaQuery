/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.util;

import java.util.Vector;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class Observable {
    private Vector<Observer> obs = new Vector<Observer>();

    public synchronized void addObserver(Observer o) {
        if (!obs.contains(o)) {
            obs.addElement(o);
        }
    }

    public synchronized void removeObserver(Observer o) {
        obs.removeElement(o);
    }

    public void change() {

        Object[] arrLocal;
        synchronized (this) {
            arrLocal = obs.toArray();
            for (int i = arrLocal.length - 1; i >= 0; i--) {
                ((Observer)arrLocal[i]).update();
            }
        }
    }
}
