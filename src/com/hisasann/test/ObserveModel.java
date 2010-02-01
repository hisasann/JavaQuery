/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.test;

import com.hisasann.util.Observable;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class ObserveModel extends Observable {

    String message = null;

    /**
     * messageを取得する.
     * @return message を返します.
     */
    public String getMessage() {
        return message;
    }

    /**
     * messageを設定します.
     * @param message message を設定.
     */
    public void setMessage(String message) {
        this.message = message;

        change();
    }
}
