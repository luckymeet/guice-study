package com.study.resource;

import com.google.inject.Inject;
import com.study.entity.User;
import com.study.service.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("users")
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> selectUser() {
        return userService.selectUser();
    }

}
