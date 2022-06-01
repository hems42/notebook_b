package com.notebook_b.org.controller.concrete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @GetMapping("/dene_user")
    @RolesAllowed({"ROLE_USER"})
    public Home deneUser() {
        return new Home("müstakil",4);
    }

    @GetMapping("/dene")
    @RolesAllowed({"ROLE_USER", "ROLE_ADMIN"})
    public String dene() {
        return"authsuz dene için geçerli";
    }

    @GetMapping("/dene_admin")
    @RolesAllowed({"ROLE_ADMIN"})
    public String deneAdmin() {
        return"admin için geçerli";
    }

}
