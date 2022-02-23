package com.notebook_b.org.dto.entity;

import java.time.LocalDateTime;

public class RoleDto {

    private Integer rolId;

    private String roleName;

    private String roleDescription;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;


    public RoleDto() {
    }

    public RoleDto(Integer rolId,
                   String roleName,
                   String roleDescription,
                   LocalDateTime createdDate,
                   LocalDateTime updatedDate) {
        this.rolId = rolId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }


    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
