package com.ibm.bug.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ibm.bug.repo.BugRepository;
import com.ibm.entity.Bug;
import com.ibm.entity.STATUS;

public class DummyBugRepository implements BugRepository {

	@Override
	public List<Bug> findAll() {
		Bug bug1 = new Bug();
		bug1.setId("24398t84gb32oi");
		Bug bug2 = new Bug();
		bug2.setId("67gfe88294u43y");
		List<Bug> bugList = new ArrayList<Bug>();
		bugList.add(bug1);
		bugList.add(bug2);
		return bugList;
	}

	@Override
	public List<Bug> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Bug> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Bug arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Bug> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Bug> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Bug> findById(String arg0) {
		Bug bug = new Bug();
		bug.setId("24398t84gb32oi");
		Optional<Bug> bugRecord = Optional.ofNullable(bug);
		return bugRecord;
	}

	@Override
	public Bug save(Bug bug) {
		bug.setId("24398t84gb32oi");
		return bug;
	}

	@Override
	public <S extends Bug> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Bug> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Bug> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Bug> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bug> findByName(String bugName) {
		Bug bug = new Bug();
		bug.setName("bug123");
		List<Bug> bugList = new ArrayList<Bug>();
		bugList.add(bug);
		return bugList;
	}

	@Override
	public List<Bug> findByStatus(STATUS status) {
		// TODO Auto-generated method stub
		return null;
	}

}
