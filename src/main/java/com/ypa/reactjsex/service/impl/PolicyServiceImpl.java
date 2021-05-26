package com.ypa.reactjsex.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ypa.reactjsex.exception.PolicyNotFoundException;
import com.ypa.reactjsex.model.PolicyBean;
import com.ypa.reactjsex.repo.PolicyRepository;
import com.ypa.reactjsex.service.IPolicyService;

@Service
public class PolicyServiceImpl implements IPolicyService {
	@Autowired
	
	private PolicyRepository prepo;

	@Override
	public Integer savePolicy(PolicyBean pb) {
		Integer count=prepo.save(pb).getPolicy_Number();
		return count;
		
	}

	@Override
	public List<PolicyBean> getAllPlicies() {
		List<PolicyBean> list = prepo.findAll();
		return list;
	}

	@Override
	public PolicyBean getOnePolicy(Integer id) {
Optional<PolicyBean> opt= prepo.findById(id);
		
		PolicyBean policy = opt.orElseThrow(
				()-> new PolicyNotFoundException("Employee Not Exist")
				);
		return policy;
	}

	@Override
	public void deletePolicy(Integer id) {
		PolicyBean pbean = getOnePolicy(id);
		prepo.delete(pbean);
		
	}
	
	
}
