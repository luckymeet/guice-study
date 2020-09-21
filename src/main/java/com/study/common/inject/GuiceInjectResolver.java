package com.study.common.inject;

import com.google.inject.Injector;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

/**
 * @author yuminjun yuminjun@lexiangbao.com
 * @version 1.00
 * @date 2020/9/18 17:16
 * @record <pre>
 * version  author      date      desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/9/18   新建
 * -------------------------------------------------
 * </pre>
 */
@javax.inject.Singleton
public class GuiceInjectResolver implements InjectionResolver<com.google.inject.Inject> {

    @javax.inject.Inject
    Injector injector;


    @Override
    public Object resolve(Injectee injectee, ServiceHandle<?> serviceHandle) {
        try {
            return injector.getInstance(Class.forName(injectee.getRequiredType().getTypeName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isConstructorParameterIndicator() {
        return false;
    }

    @Override
    public boolean isMethodParameterIndicator() {
        return false;
    }
}
