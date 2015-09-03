package org.jgrades.admin.api.accounts;

import org.jgrades.data.api.entities.User;
import org.jgrades.data.api.model.roles.Roles;
import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.Specification;

public interface UserSpecifications<U extends User> {
    Specification<U> withPhrase(String phrase);

    Specification<U> withLogin(String login);

    Specification<U> withName(String name);

    Specification<U> withSurname(String surname);

    Specification<U> withEmail(String email);

    Specification<U> onlyActive();

    Specification<U> onlyInactive();

    Specification<U> withRoles(Roles roles);

    Specification<U> lastVisitBetween(DateTime dateTime1, DateTime dateTime2);
}