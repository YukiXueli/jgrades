/*
 * Copyright (C) 2016 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.data.api.entities;

import lombok.Getter;
import lombok.Setter;
import org.jgrades.data.api.model.SchoolType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "JG_DATA_SCHOOL")
@Getter
@Setter
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String shortName;

    private String nameOnDiploma;

    private String nameOnGraduateDiploma;

    @Enumerated(EnumType.STRING)
    private SchoolType type;

    private String address;

    private String vatIdentificationNumber;

    private String webpage;

    private String email;

    private String contactPhone;
}
