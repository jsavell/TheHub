package com.shadowaterservices.thehub.data.repositories;

import org.springframework.data.repository.CrudRepository;

import com.shadowaterservices.thehub.data.entities.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}