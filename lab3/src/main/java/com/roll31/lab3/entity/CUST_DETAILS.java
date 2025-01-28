package com.roll31.lab3.entity;

import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUST_DETAILS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CUST_DETAILS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String type;
    String fullName;
    Date dob;
    String status;
    String contact;
    String mobile;
    String email;
    String country;
    Date efctv_date;
    char crud_value;
    String user_id;
    String ws_id;
    String prgm_id;
    Timestamp host_ts;
    Timestamp local_ts;
    Timestamp acpt_ts;
    Timestamp acpt_ts_utc_ofst;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getFullName()
    {
        return fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getEfctv_date() {
        return efctv_date;
    }

    public void setEfctv_date(Date efctv_date) {
        this.efctv_date = efctv_date;
    }

    public char getCrud_value() {
        return crud_value;
    }

    public void setCrud_value(char crud_value) {
        this.crud_value = crud_value;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getWs_id() {
        return ws_id;
    }

    public void setWs_id(String ws_id) {
        this.ws_id = ws_id;
    }

    public String getPrgm_id() {
        return prgm_id;
    }

    public void setPrgm_id(String prgm_id) {
        this.prgm_id = prgm_id;
    }

    public Timestamp getHost_ts() {
        return host_ts;
    }

    public void setHost_ts(Timestamp host_ts) {
        this.host_ts = host_ts;
    }

    public Timestamp getLocal_ts() {
        return local_ts;
    }

    public void setLocal_ts(Timestamp local_ts) {
        this.local_ts = local_ts;
    }

    public Timestamp getAcpt_ts() {
        return acpt_ts;
    }

    public void setAcpt_ts(Timestamp acpt_ts) {
        this.acpt_ts = acpt_ts;
    }

    public Timestamp getAcpt_ts_utc_ofst() {
        return acpt_ts_utc_ofst;
    }

    public void setAcpt_ts_utc_ofst(Timestamp acpt_ts_utc_ofst) {
        this.acpt_ts_utc_ofst = acpt_ts_utc_ofst;
    }
}

