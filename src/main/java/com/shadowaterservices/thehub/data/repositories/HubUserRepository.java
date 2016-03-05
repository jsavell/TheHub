package com.shadowaterservices.thehub.data.repositories;

import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.shadowaterservices.thehub.data.entities.HubUser;

@RepositoryRestResource(exported = false)
public interface HubUserRepository extends Repository<HubUser, Long> {

	Long count();
	HubUser save(HubUser hubUser);
	HubUser findByUsername(String username);

}