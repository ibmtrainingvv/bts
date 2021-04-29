package com.ibm.bug.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.entity.Bug;
import com.ibm.entity.STATUS;

public interface BugRepository extends MongoRepository<Bug, String> {
	@Query("{'name':?0}")
	List<Bug> findByNameIgnoreCase(String bugName);

	List<Bug> findByStatus(STATUS bugStatus);
	@Query("{status:?0,name:{$regex:?1}}")
	List<Bug> findByStatusAndNameIgnoreCase(STATUS bugStatus,String bugName);

	List<Bug> findByNameIgnoreCaseLike(String bugName);
	
}
