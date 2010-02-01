/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;

import com.hisasann.constants.Bind;
import com.hisasann.exception.JavaQueryException;
import com.hisasann.interceptor.Interceptor;
import com.hisasann.util.Function;
import com.hisasann.util.Observable;
import com.hisasann.util.Observer;

/**
 * JavaQuery.<br>
 * @author hisasann
 */
public class JavaQuery {
    private static String version = "0.0.1";

    /**
     * versionを取得する.
     * @return version を返します.
     */
    public static String getVersion() {
        return version;
    }

    /**
     * versionを設定します.
     * @param version version を設定.
     */
    public static void setVersion(String version) {
        JavaQuery.version = version;
    }

    /**
     * Bind.typeを元に要素に処理をインターセプトします
     * 対象のobjectは1つが基本です
     * 
     * @param elem インターセプト対象要素
     * @param type インターセプトの種類
     * @param fn インターセプト処理
     * @return インターセプト後のobject
     */
    public static Object bind(Object elem, Bind type, Object fn) {
        if (Bind.METHOD.equals(type)) {
            return JavaQuery.methodIntercept(elem, (Interceptor) fn);
        }

        return null;
    }

    /**
     * メソッドインターセプター
     * 
     * @param clazz クラス
     * @param fn インターセプト
     * @return インターセプト後object
     */
    public static Object methodIntercept(Object clazz, Interceptor fn) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass((Class) clazz);
        enhancer.setCallback(fn);

        return enhancer.create();
    }

    /**
     * 対象の要素にイベントを設定します
     * 
     * @param elems イベントを設定するobjects
     * @param o オブザーバー
     */
    public static void observe(List<Object> elems, Observer o) {
        try {
            for (Object element : elems) {
                ((Observable) element).addObserver(o);
            }
        } catch (ClassCastException e) {
            throw new JavaQueryException("Please observe them inherit");
        }
    }

    /**
     * each処理
     * 
     * @param list ループ対象のリスト
     * @param fn ループ時に実行するfunction
     */
    public static void each(List<?> list, Function fn) {
        if (isEmpty(list)) {
            return;
        }

        int i = 0;
        for (Object object : list) {
            fn.exec(i++, object);
        }
    }

    /**
     * each処理
     * 
     * @param array ループ対象配列
     * @param fn ループ時に実行するfunction
     */
    public static <T> void each(T[] array, Function fn) {
        if (isEmpty(array)) {
            return;
        }

        int i = 0;
        for (Object object : array) {
            fn.exec(i++, object);
        }
    }

    /**
     * 配列からnullの要素を除去します
     * 
     * @param o null除去対象配列
     * @return null除去後配列
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] compact(T[] o) {
        if (isEmpty(o)) {
            return null;
        }

        ArrayList<T> l = new ArrayList<T>() {
            private static final long serialVersionUID = -4340505804519901363L;

            @Override
            public boolean add(T o) {
                if (o != null) {
                    return super.add(o);
                } else {
                    return false;
                }
            }

        };
        Collections.addAll(l, o);

        Class arrayClass = o.getClass().getComponentType();

        return l.toArray((T[]) Array.newInstance(arrayClass, l.size()));
    }

    /**
     * ハイフン(-)区切りの文字列をキャメライズします
     * 
     * @param string 文字列
     * @return 文字列
     */
    public static String camelize(String string) {
        String[] parts = string.split("-");
        int len = parts.length;
        if (len == 1) {
            return parts[0];
        }
        String part = String.valueOf(parts[0].charAt(0));
        String camelized = "-".equals(part) ? part.toUpperCase()
                + parts[0].substring(1) : parts[0];

        for (int i = 1; i < len; i++) {
            camelized += String.valueOf(parts[i].charAt(0)).toUpperCase()
                    + parts[i].substring(1);
        }

        return camelized;
    }

    /**
     * 先頭を大文字にします
     * 
     * @see org.apache.commons.lang.StringUtils#capitalize(String)
     * @param string 変換前文字列
     * @return 変換後文字列
     */
    public static String capitalize(String string) {
        return org.apache.commons.lang.StringUtils.capitalize(string);
    }
    
    private static final String DEFAULT_ENC = "UTF-8";

    /**
     * URLデコード
     * 
     * @param string 文字列
     * @return デコード後文字列
     */
    public static String urlDecode(String string) {
        if (isEmpty(string)) {
            return "";
        }
        try {
            return URLDecoder.decode(string, DEFAULT_ENC);
        } catch (UnsupportedEncodingException e) {
            throw new JavaQueryException(e);
        }
    }

    /**
     * URLエンコード
     * 
     * @param string 文字列
     * @return エンコード後文字列
     */
    public static String urlEncode(String string) {
        if (isEmpty(string)) {
            return "";
        }
        try {
            return URLEncoder.encode(string, DEFAULT_ENC);
        } catch (UnsupportedEncodingException e) {
            throw new JavaQueryException(e);
        }
    }

    /**
     * Empty？
     * 
     * @param string 文字列
     * @return 判定値
     */
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * Empty？
     * 
     * @param list リスト
     * @return 判定値
     */
    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    /**
     * Empty？
     * 
     * @param array 配列
     * @return 判定値
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }
}
