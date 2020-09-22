package com.study.common.inject;

import com.google.inject.Injector;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;

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
