package org.acme.elytron.security.jpa.controller;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/api/users")
public class UsersController {

    @GET
    @RolesAllowed("user")
    @Path("/me")
    public String me(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }

    @GET
    @RolesAllowed("riku")
    @Path("/riku")
    public String riku(@Context SecurityContext securityContext) {
        return securityContext.getUserPrincipal().getName();
    }
}