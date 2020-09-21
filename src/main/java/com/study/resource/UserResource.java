package com.study.resource;

import com.google.inject.Inject;
import com.study.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
