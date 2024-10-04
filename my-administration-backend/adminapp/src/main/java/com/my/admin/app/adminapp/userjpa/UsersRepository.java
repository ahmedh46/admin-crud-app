package com.my.admin.app.adminapp.userjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findByUserNameAndPassword(String userName, String password);

}