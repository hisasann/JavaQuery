/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann.test;

import java.lang.reflect.Method;

import junit.framework.TestCase;
import net.sf.cglib.proxy.MethodProxy;

import com.hisasann.$;
import com.hisasann.constants.Bind;
import com.hisasann.interceptor.Interceptor;

/**
 * FIXME 機能説明をここに記述してください.<br>
 * @author hisasann
 */
public class TestBind extends TestCase {

    public void testBind() {

        BindModel model = (BindModel) $.make(BindModel.class).bind(Bind.METHOD,
                new Interceptor() {
                    public Object intercept(Object obj, Method method,
                            Object[] args, MethodProxy proxy) throws Throwable {

                        System.out.println("before");
                        proxy.invokeSuper(obj, args);
                        System.out.println("after");

                        return null;
                    }
                });

        model.setMessage("hoge");
    }
}
