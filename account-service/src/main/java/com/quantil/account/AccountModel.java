package com.quantil.account;

import com.alibaba.fastjson.annotation.JSONField;
import com.zoe.snow.model.Model;
import com.zoe.snow.model.enums.IdStrategy;
import com.zoe.snow.model.support.UserAtBy;
import com.zoe.snow.model.support.ValidFlag;
import com.zoe.snow.model.support.user.BaseUserModel;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * AccountModel
 *
 * @author <a href="mailto:dwq676@126.com">daiwenqing</a>
 * @date 2017/4/26
 */
@Entity
@Table(name = "account")
@Component("quantil.account.model")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AccountModel implements Model, ValidFlag, UserAtBy, BaseUserModel {
    private static final String UUID = "uuid";
    @JSONField(name = Description.ID)
    @Column(name = Description.ID)
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = IdStrategy.Assigned)
    private String id;
    @Column(name = Description.USERNAME)
    @JSONField(name = Description.USERNAME)
    private String username;
    @JSONField(name = Description.PASSWORD)
    @Column(name = Description.PASSWORD)
    private String password;
    @Column(name = Description.STATUS)
    @JSONField(name = Description.STATUS)
    private int status;
    @JSONField(name = Description.LAST_LOGIN_AT)
    @Column(name = Description.LAST_LOGIN_AT)
    private Date lastLoginAt;
    @Column(name = Description.LAST_LOGIN_IP)
    @JSONField(name = Description.LAST_LOGIN_IP)
    private String lastLoginIp;
    @JSONField(name = Description.DESCRIPTION)
    @Column(name = Description.DESCRIPTION)
    private String description;
    @JSONField(name = Description.DELETED)
    @Column(name = Description.DELETED)
    private int deleted;
    @JSONField(name = Description.CREATED_AT)
    @Column(name = Description.CREATED_AT)
    private Date createdAt;
    @Column(name = Description.CREATED_BY)
    @JSONField(name = Description.CREATED_BY)
    private String createdBy;
    @JSONField(name = Description.UPDATED_AT)
    @Column(name = Description.UPDATED_AT)
    private Date updatedAt;
    @JSONField(name = Description.UPDATED_BY)
    @Column(name = Description.UPDATED_BY)
    private String updatedBy;

    @Column(name = Description.TENANT_ID)
    @JSONField(name = Description.APP_ID)
    private String appId;

    @Transient
    private String token;
    @Transient
    private boolean locked = false;
    /*@Transient
    private boolean rememberMe = false;

    @Override
    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
*/
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean getLocked() {
        return false;
    }

    @Override
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean getIsAdmin() {
        return false;
    }

    @Override
    public void setIsAdmin(boolean isAdmin) {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastLoginAt() {
        return lastLoginAt;
    }

    public void setLastLoginAt(Date lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public int getValidFlag() {
        return deleted;
    }

    @Override
    public void setValidFlag(int validFlag) {
        this.deleted = validFlag;
    }

    @Override
    public String getValidFlagName() {
        return "deleted";
    }

    @Override
    public String getDomain() {
        return this.appId;
    }

    @Override
    public void setDomain(String domain) {
        this.appId = domain;
    }

    @Override
    public String getDomainName() {
        return "appId";
    }
}
