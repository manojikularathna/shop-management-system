package org.army.shop.organization.entity;

import org.army.shop.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role extends BaseEntity {

    @Id
    private String roleCode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn( name = "role_code"),
            inverseJoinColumns = @JoinColumn (name = "permission_code"))
    private List<Permission> permissions;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}