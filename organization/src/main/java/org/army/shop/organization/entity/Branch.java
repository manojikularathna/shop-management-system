package org.army.shop.organization.entity;

import org.army.shop.common.entity.PrimaryContactInformation;

import javax.persistence.*;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long branchId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "root_id")
    private Root root;

    @Embedded
    private PrimaryContactInformation contactInformation;

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public PrimaryContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(PrimaryContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }
}