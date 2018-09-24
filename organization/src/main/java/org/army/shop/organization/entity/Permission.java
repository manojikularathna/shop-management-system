package org.army.shop.organization.entity;

import org.army.shop.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Permission extends BaseEntity {

    @Id
    private String permissionCode;

    private String description;

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
