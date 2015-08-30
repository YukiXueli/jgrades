package org.jgrades.admin.general;

import com.google.common.collect.Sets;
import org.jgrades.admin.api.general.DaysMgntService;
import org.jgrades.admin.api.model.WorkingDays;
import org.jgrades.data.api.dao.SchoolDayRepository;
import org.jgrades.data.api.entities.SchoolDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;

@Service
public class DaysMgntServiceImpl implements DaysMgntService {
    @Autowired
    private SchoolDayRepository repository;

    @Override
    public WorkingDays getWorkingDays() {
        WorkingDays result = new WorkingDays();
        Iterable<SchoolDay> schoolDays = repository.findAll();
        for (SchoolDay schoolDay : schoolDays) {
            result.addDay(schoolDay.getDayOfWeek());
        }
        return result;
    }

    @Override
    @Transactional
    public void setWorkingDays(WorkingDays newWorkingDays) {
        WorkingDays actualWorkingDays = getWorkingDays();

        for (DayOfWeek newDay : Sets.difference(newWorkingDays.getDays(), actualWorkingDays.getDays())) {
            repository.save(new SchoolDay(newDay.getValue(), newDay));
        }

        for (DayOfWeek toRemoveDay : Sets.difference(actualWorkingDays.getDays(), newWorkingDays.getDays())) {
            repository.delete(toRemoveDay.getValue());
        }
    }
}
