package com.project.app.repositories;

import com.project.app.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by leandro on 11/07/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
