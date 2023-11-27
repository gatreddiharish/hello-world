package com.bofa.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bofa.bank.domain.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
