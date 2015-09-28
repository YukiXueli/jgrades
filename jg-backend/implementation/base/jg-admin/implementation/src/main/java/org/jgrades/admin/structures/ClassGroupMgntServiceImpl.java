package org.jgrades.admin.structures;

import org.jgrades.admin.api.structures.ClassGroupMgntService;
import org.jgrades.data.api.dao.structures.ClassGroupRepository;
import org.jgrades.data.api.entities.ClassGroup;
import org.jgrades.data.api.entities.Division;
import org.jgrades.data.api.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ClassGroupMgntServiceImpl implements ClassGroupMgntService {
    @Autowired
    private ClassGroupRepository repository;

    @Override
    @Transactional("mainTransactionManager")
    public List<Division> getDivisions(ClassGroup classGroup) {
        return repository.findOne(classGroup.getId()).getDivisions();
    }

    @Override
    @Transactional("mainTransactionManager")//TODO
    public Set<Student> getStudents(ClassGroup classGroup) {
        return null;
    }

    @Override
    public void addStudent(ClassGroup classGroup, Student student) {

    }

    @Override
    public void saveOrUpdate(ClassGroup classGroup) {

    }

    @Override
    public void remove(ClassGroup classGroup) {

    }

    @Override
    public void remove(List<ClassGroup> classGroups) {

    }

    @Override
    public Page<ClassGroup> getPage(Pageable pageable) {
        return null;
    }

    @Override
    public List<ClassGroup> getAll() {
        return null;
    }

    @Override
    public ClassGroup getWithId(Long id) {
        return null;
    }
}