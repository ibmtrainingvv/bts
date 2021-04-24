package com.ibm.bug.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.entity.Bug;
import com.ibm.entity.STATUS;

public interface BugRepository extends MongoRepository<Bug, String> {
	@Query("{name: {$regex : ?0, '$options' :'i'}}")
	List<Bug> findByNameIgnoreCase(String name);

	List<Bug> findByStatus(STATUS status);

	@Query("{status: ?0, name : {$regex : ?1, '$options' : 'i'}}")
	List<Bug> findByStatusAndNameIgnoreCase(STATUS status, String name);

}
