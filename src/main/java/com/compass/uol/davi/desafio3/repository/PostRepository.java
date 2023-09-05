package com.compass.uol.davi.desafio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.uol.davi.desafio3.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
