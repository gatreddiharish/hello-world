package com.bofa.bank.service;

import com.bofa.bank.domain.Branch;

public interface BranchService {

	public void createBranch(Branch branch);

	public Branch findBranchById(int branchId);

}
