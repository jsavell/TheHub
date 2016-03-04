package com.shadowaterservices.thehub.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shadowaterservices.thehub.data.entities.HubUser;

public interface HubUserRepository extends CrudRepository<HubUser, Long> {

}