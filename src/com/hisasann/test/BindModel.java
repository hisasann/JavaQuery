/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.test;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class BindModel {

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

        System.out.println("setter do!!");
    }
}
