/**
 * Copyright(c) team-lab</br>
 */
package com.hisasann;

import java.util.ArrayList;
import java.util.List;

import com.hisasann.constants.Bind;
import com.hisasann.exception.JavaQueryException;
import com.hisasann.util.Observer;

/**
 * New Wave Java - JavaQuery.<br>
 * @author hisasann
 */
public class $ extends JavaQuery{
    public static $ make(Object... target) {
        return new $(target);
    }

    private $(Object... target) {
        create(target);
    }

    private List<Object> _array = new ArrayList<Object>();

    public $ create(Object... target) {
        for (Object object : target) {
            _array.add(object);
        }

        return this;
    }

    public $ observe(Observer o) {
        JavaQuery.observe(_array, o);

        return this;
    }

    public Object bind(Bind type, Object fn) {
        if (_array.size() > 1) {
            throw new JavaQueryException("Please intercept one to one");
        }

        return JavaQuery.bind(_array.get(0), type, fn);
    }
}
