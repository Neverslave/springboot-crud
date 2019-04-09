package com.yuedanet.pojo;

import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    private Integer id;

    private String username;

    private String password;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 0正常，1冻结，2删除
     */
    private String status;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取0正常，1冻结，2删除
     *
     * @return status - 0正常，1冻结，2删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置0正常，1冻结，2删除
     *
     * @param status 0正常，1冻结，2删除
     */
    public void setStatus(String status) {
        this.status = status;
    }
}