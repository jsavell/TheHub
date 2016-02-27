package com.shadowaterservices.thehub.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shadowaterservices.thehub.data.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}