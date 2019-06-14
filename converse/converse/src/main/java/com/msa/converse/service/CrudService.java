package com.msa.converse.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    List<?> listAll();

    Optional<T> getById(Long id);
}
