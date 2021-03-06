/*
 * Copyright (C) 2016 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.rest.api.admin.accounts;

import lombok.Getter;
import lombok.Setter;
import org.jgrades.admin.api.model.StudentMassCreatingSettings;

@Getter
@Setter
public class MassCreatorDTO {
    private String studentCsvData;

    private StudentMassCreatingSettings settings;
}
