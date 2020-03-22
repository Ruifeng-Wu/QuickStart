package com.ruifeng.quickstart.entity;

import com.ruifeng.quickstart.enums.TeamStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Team {

    private Integer id;

    private String name;

    private TeamStatus status;

    protected Timestamp createdAt;

    protected Timestamp updatedAt;

    protected String createdBy;

    protected String updatedBy;
}
