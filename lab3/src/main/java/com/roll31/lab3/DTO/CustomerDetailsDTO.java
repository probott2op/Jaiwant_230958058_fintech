package com.roll31.lab3.DTO;

import java.sql.Date;
import java.util.List;

public class CustomerDetailsDTO {
    private String type;
    private List<NameTypeValue> customerFullName;
    private Date dob;
    private String status;
    private String contact;
    private String mobile;
    private String email;
    private String country;

    //Getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCustomerFullName(List<NameTypeValue> customerFullName)
    {
        this.customerFullName = customerFullName;
    }

    public List<NameTypeValue> getCustomerFullName()
    {
        return customerFullName;
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
}
