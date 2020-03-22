package com.ruifeng.subproject.entity;

import com.ruifeng.subproject.enums.TeamStatus;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "team")
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
