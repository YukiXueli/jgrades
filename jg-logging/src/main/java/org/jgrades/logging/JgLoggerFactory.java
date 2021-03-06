/*
 * Copyright (C) 2016 the original author or authors.
 *
 * This file is part of jGrades Application Project.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  You may obtain a copy of the License at
 *        http://www.apache.org/licenses/LICENSE-2.0
 */

package org.jgrades.logging;

import org.jgrades.logging.dao.LoggingConfigurationDao;
import org.jgrades.logging.dao.LoggingConfigurationDaoFileImpl;
import org.jgrades.logging.job.JobsStarter;
import org.jgrades.logging.job.XmlConfigurationUpdater;

public final class JgLoggerFactory {
    private static final JgLogger LOGGER = JgLoggerFactory.getLogger(JgLoggerFactory.class);

    private static XmlConfigurationUpdater xmlUpdater;
    private static LoggingConfigurationDao configurationDao;
    private static JobsStarter jobsStarter;

    static {
        try {
            xmlUpdater = new XmlConfigurationUpdater();
            configurationDao = new LoggingConfigurationDaoFileImpl();
            jobsStarter = new JobsStarter();

            xmlUpdater.update(configurationDao.getCurrentConfiguration());
            jobsStarter.start();
        } catch (RuntimeException e) { //NOSONAR
            LOGGER.debug("Fail to correctly initialize JgLoggerFactory. Logging can work improperly", e);
        }
    }

    private JgLoggerFactory() {
    }

    public static JgLogger getLogger(Class clazz) {
        return new JgLogger(clazz);
    }

}
