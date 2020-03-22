package com.ruifeng.quickstart.entity;

import com.ruifeng.quickstart.enums.TeamStatus;

import javax.persistence.*;
import java.sql.Timestamp;

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TeamStatus status;

    @Column(
            name = "created_at"
    )
    protected Timestamp createdAt;

    @Column(
            name = "updated_at"
    )
    protected Timestamp updatedAt;

    @Column(
            name = "created_by"
    )
    protected String createdBy;

    @Column(
            name = "updated_by"
    )
    protected String updatedBy;
}
