package com.bofa.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bofa.bank.domain.Branch;
import com.bofa.bank.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@PostMapping("/create")
	public void createBranch(@RequestBody Branch branch) {
		branchService.createBranch(branch);
	}

	@GetMapping("/findById")
	public Branch findBranchById(@RequestParam int branchId) {
		Branch branch = branchService.findBranchById(branchId);
		return branch;
	}

}
