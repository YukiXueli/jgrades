package org.jgrades.data.api.dao.accounts;

import org.jgrades.data.api.dao.RoleUserRepository;
import org.jgrades.data.api.entities.Administrator;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends RoleUserRepository<Administrator> {
}