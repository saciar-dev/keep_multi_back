package com.vve.KeepSmilingBack.model.dto;

public class CreatePlayerRequest {

    private String name;
    private String phone;

    public CreatePlayerRequest() {
    }

    public CreatePlayerRequest(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
