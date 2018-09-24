package org.army.shop.organization.entity;

import org.army.shop.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Root extends BaseEntity {

    @Id
    private Long rootId;

    private String name;

    @OneToMany(mappedBy = "root", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Branch> branches;

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}