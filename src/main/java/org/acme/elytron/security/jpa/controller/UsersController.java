package org.acme.elytron.security.jpa.controller;

import io.vertx.core.json.JsonObject;
import org.acme.elytron.security.jpa.model.User;

import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Map;

@Path("/api/users")
public class UsersController {

    @POST
    @RolesAllowed("admin")
    @Path("/create")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(JsonObject request) {

        User.add(
                request.getString("username"),
                request.getString("password"),
                request.getString("role"));

        return "ok";

    }

    @GET
    @RolesAllowed("user")
    @Path("/me")
    public String me(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }

    @GET
    @RolesAllowed("john")
    @Path("/john")
    public String john(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }
}