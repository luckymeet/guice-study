package com.study.resource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

import javax.inject.Named;

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
    @Named(InjectionResolver.SYSTEM_RESOLVER_NAME)
    InjectionResolver<javax.inject.Inject> systemInjectionResolver;

    Injector injector = Guice.createInjector();


    public Object resolve(Injectee injectee, ServiceHandle<?> serviceHandle) {
        if (com.google.inject.Inject.class == injectee.getRequiredType()) {
//            return systemInjectionResolver.resolve(injectee, serviceHandle);
            return injector.getInstance(injectee.getInjecteeClass());
        }
        return null;
    }

    public boolean isConstructorParameterIndicator() {
        return false;
    }

    public boolean isMethodParameterIndicator() {
        return false;
    }
}
