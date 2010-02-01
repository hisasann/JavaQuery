/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.exception;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class JavaQueryException extends RuntimeException {

    /**
     * <code>serialVersionUID</code> のコメント
     */
    private static final long serialVersionUID = -1749959297920688317L;

    /**
     * デフォルトコンストラクタ
     */
    public JavaQueryException() {
        super();
    }

    /**
     * メッセージと根源の例外を指定するコンストラクタ。
     * @param message メッセージ
     * @param cause 根源の例外
     */
    public JavaQueryException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * メッセージを指定するコンストラクタ。
     * @param message メッセージ
     */
    public JavaQueryException(String message) {
        super(message);
    }

    /**
     * 根源の例外を指定するコンストラクタ。
     * @param cause 根源の例外
     */
    public JavaQueryException(Throwable cause) {
        super(cause);
    }
}
