package com.study.common.config;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.study.common.inject.GuiceInjectResolver;
import com.study.module.PublicMoudle;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // 资源类所在的包路径
        packages("com.study.resource");

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(Guice.createInjector(new PublicMoudle())).to(Injector.class);
                bind(GuiceInjectResolver.class)
                        .to(new TypeLiteral<InjectionResolver<Inject>>(){})
                        .in(Singleton.class);

            }
        });
    }
}
