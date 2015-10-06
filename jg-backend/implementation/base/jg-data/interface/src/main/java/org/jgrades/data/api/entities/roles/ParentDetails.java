/*
 * Copyright (C) 2015 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.data.api.entities.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.jgrades.data.api.entities.User;
import org.jgrades.data.api.model.JgRole;

import javax.persistence.*;

@Entity
@Table(name = "JG_DATA_PARENT_DETAILS")
@Data
@ToString(exclude = "student")
public class ParentDetails implements RoleDetails {
    @GenericGenerator(name = "generator", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "user"))
    @Id
    @GeneratedValue(generator = "generator")
    @JsonIgnore
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private User user;

    private String contactPhone;

    private String address;

    @OneToOne
    @JoinColumn(name = "student_user_id")
    @JsonIgnore
    private StudentDetails student;

    @Override
    public JgRole roleName() {
        return JgRole.PARENT;
    }
}