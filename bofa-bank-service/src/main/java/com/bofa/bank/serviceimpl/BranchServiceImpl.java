package com.bofa.bank.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bofa.bank.domain.Branch;
import com.bofa.bank.repository.BranchRepository;
import com.bofa.bank.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService{
	
	@Autowired
	private BranchRepository branchRepository;

	@Override
	public void createBranch(Branch branch) {
		branchRepository.save(branch);
		
	}

	@Override
	public Branch findBranchById(int branchId) {
	   Optional<Branch> optionalBranch=branchRepository.findById(branchId);
	   Branch branch = new Branch();
	   if(optionalBranch.isPresent()) {
		   branch = optionalBranch.get();
	   }
		return branch;
	}

}
