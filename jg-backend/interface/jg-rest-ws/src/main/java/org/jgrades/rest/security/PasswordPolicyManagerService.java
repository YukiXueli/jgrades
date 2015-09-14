package org.jgrades.rest.security;

import org.jgrades.data.api.model.roles.JgRole;
import org.jgrades.logging.JgLogger;
import org.jgrades.logging.JgLoggerFactory;
import org.jgrades.monitor.api.aop.CheckSystemDependencies;
import org.jgrades.security.api.entities.PasswordPolicy;
import org.jgrades.security.api.service.PasswordPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/password/policy")
@CheckSystemDependencies
public class PasswordPolicyManagerService {
    private static final JgLogger LOGGER = JgLoggerFactory.getLogger(PasswordPolicyManagerService.class);

    @Autowired
    private PasswordPolicyService passwordPolicyService;

    @RequestMapping(value = "/{role}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    PasswordPolicy getForRole(@PathVariable JgRole role) {
        return passwordPolicyService.getForRole(role);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public
    @ResponseBody
    Set<PasswordPolicy> getAll() {
        return passwordPolicyService.getPasswordPolicies();
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setForRole(@RequestBody PasswordPolicy policy) {
        passwordPolicyService.putPasswordPolicy(policy);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
