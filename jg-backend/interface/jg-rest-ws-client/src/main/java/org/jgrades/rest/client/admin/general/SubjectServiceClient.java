/*
 * Copyright (C) 2015 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.rest.client.admin.general;

import org.jgrades.data.api.entities.Subject;
import org.jgrades.rest.api.admin.general.ISubjectService;
import org.jgrades.rest.client.StatefullRestTemplate;
import org.jgrades.rest.client.common.RestCrudPagingServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SubjectServiceClient extends RestCrudPagingServiceClient<Subject, Long>
        implements ISubjectService {
    @Autowired
    public SubjectServiceClient(@Value("${rest.backend.base.url}") String backendBaseUrl,
                                StatefullRestTemplate restTemplate) {
        super(backendBaseUrl, "/subject", restTemplate);
    }
}