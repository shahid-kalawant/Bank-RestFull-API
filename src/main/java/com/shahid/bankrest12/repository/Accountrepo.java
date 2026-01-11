package com.shahid.bankrest12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shahid.bankrest12.entities.Account;

@Repository
public interface Accountrepo extends JpaRepository<Account, Integer>{
	
	List<Account> findByAcctype(String acctype);

}
