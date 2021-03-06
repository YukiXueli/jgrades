/*
 * Copyright (C) 2016 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.data.api.entities.roles;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import org.jgrades.data.api.model.JgRole;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "JG_DATA_ADMINISTRATOR_DETAILS")
@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class AdministratorDetails extends RoleDetails {
    @Override
    public JgRole roleName() {
        return JgRole.ADMINISTRATOR;
    }
}
