/*
 * Copyright (C) 2016 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.lic.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "version", "validFrom", "validTo"})
@XmlJavaTypeAdapter(type = LocalDateTime.class, value = LicenceDateTimeAdapter.class)
@Data
@EqualsAndHashCode(exclude = {"validFrom", "validTo"})
public final class Product {

    @XmlElement(name = "name", required = true)
    private String name;

    @XmlElement(name = "version", required = true)
    private String version;

    @XmlElement(name = "valid_from", required = true)
    private LocalDateTime validFrom;

    @XmlElement(name = "valid_to", required = true)
    private LocalDateTime validTo;
}
