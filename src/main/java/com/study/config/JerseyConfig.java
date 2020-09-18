package com.study.config;

import com.google.inject.Inject;
import com.study.resource.GuiceInjectResolver;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Singleton;

/**
 * @author yuminjun yuminjun@lexiangbao.com
 * @version 1.00
 * @date 2020/9/17 16:35
 * @record <pre>
 * version  author      date      desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/9/17   新建
 * -------------------------------------------------
 * </pre>
 */
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        // 资源类所在的包路径
        packages("com.study.resource");

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(GuiceInjectResolver.class)
                        .to(new TypeLiteral<InjectionResolver<Inject>>(){})
                        .in(Singleton.class);

            }
        });
    }
}
