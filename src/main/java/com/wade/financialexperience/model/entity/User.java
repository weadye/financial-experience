package com.wade.financialexperience.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "users")
public class User {
    @Column(name = "id")
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "created_by")
    private String createdby;

    @Column(name = "created_at")
    private Date createdat;

    @Column(name = "changed_by")
    private String changedby;

    @Column(name = "changed_at")
    private Date changedat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby == null ? null : createdby.trim();
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public String getChangedby() {
        return changedby;
    }

    public void setChangedby(String changedby) {
        this.changedby = changedby == null ? null : changedby.trim();
    }

    public Date getChangedat() {
        return changedat;
    }

    public void setChangedat(Date changedat) {
        this.changedat = changedat;
    }
}