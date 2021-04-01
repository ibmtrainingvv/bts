package com.ibm.bug.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ibm.bug.repo.BugRepository;
import com.ibm.entity.Bug;

public class DummyBugRepository implements BugRepository {

	public List<Bug> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Bug> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Bug> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Bug> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Bug> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Bug> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Bug> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Bug> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Bug arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	public void deleteAll(Iterable<? extends Bug> arg0) {
		// TODO Auto-generated method stub

	}

	public void deleteById(String arg0) {
		// TODO Auto-generated method stub

	}

	public boolean existsById(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<Bug> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Bug> findById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bug save(Bug bug) {
		bug.setId("24398t84gb32oi");
		return bug;
	}

	public <S extends Bug> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public <S extends Bug> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <S extends Bug> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Bug> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
