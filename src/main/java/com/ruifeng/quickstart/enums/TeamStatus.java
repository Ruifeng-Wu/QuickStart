package com.ruifeng.quickstart.enums;

public enum TeamStatus {
    ACTIVE("can use in system"),
    INACTIVE("can not use in system"),
    ARCHIVE("deleted user");


    private String status;

    TeamStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return this.status;
    }
}
