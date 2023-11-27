package com.bofa.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bofa.bank.domain.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer>{

}
