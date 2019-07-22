package com.msa.converse.service;

import com.msa.converse.model.Role;
import com.msa.converse.model.RoleName;

import java.util.List;
import java.util.Optional;

public interface RoleService extends CrudService<Role> {

    Optional<Role> findByName(RoleName roleName);

    List<Role> listAll();
}
