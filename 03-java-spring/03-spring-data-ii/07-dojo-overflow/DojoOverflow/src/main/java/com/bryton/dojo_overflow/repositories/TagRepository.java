package com.bryton.dojo_overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bryton.dojo_overflow.models.Tag;

public interface TagRepository extends CrudRepository <Tag, Long> {
	List <Tag> findAll();
}
