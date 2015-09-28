package org.jgrades.rest.admin.general;

import org.jgrades.admin.api.general.ClassroomMgntService;
import org.jgrades.data.api.entities.Classroom;
import org.jgrades.logging.JgLogger;
import org.jgrades.logging.JgLoggerFactory;
import org.jgrades.monitor.api.aop.CheckSystemDependencies;
import org.jgrades.rest.PagingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/classroom", produces = MediaType.APPLICATION_JSON_VALUE)
@CheckSystemDependencies
public class ClassroomService {
    private static final JgLogger LOGGER = JgLoggerFactory.getLogger(ClassroomService.class);

    @Autowired
    private ClassroomMgntService classroomService;

    @Autowired
    private SchoolService schoolService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insertOrUpdate(@RequestBody Classroom classroom) {
        classroom.setSchool(schoolService.getGeneralData());
        classroomService.saveOrUpdate(classroom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> remove(@PathVariable Long id) {
        classroomService.remove(classroomService.getWithId(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    List<Classroom> getAll() {
        return classroomService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    Classroom getWithId(@PathVariable Long id) {
        return classroomService.getWithId(id);
    }

    @RequestMapping(value = "/page/{number}/{size}", method = RequestMethod.GET)
    public
    @ResponseBody
    Page<Classroom> getPage(@PathVariable Integer number, @PathVariable Integer size) {
        PagingInfo pagingInfo = new PagingInfo(number, size);
        return classroomService.getPage(pagingInfo.toPageable());
    }
}