/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.interceptor;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodProxy;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public abstract class Interceptor implements MethodInterceptor{

    /**
     * interceptをオーバーライドします.
     * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
     */
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        return null;
    }
}
