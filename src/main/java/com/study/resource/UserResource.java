package com.study.resource;

import com.google.inject.Inject;
import com.study.service.UserService;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author yuminjun yuminjun@lexiangbao.com
 * @version 1.00
 * @date 2020/9/17 15:54
 * @record <pre>
 * version  author      date      desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/9/17   新建
 * -------------------------------------------------
 * </pre>
 */
@Singleton
@Path("users")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser() {
        return userService.getUser();
    }

}
