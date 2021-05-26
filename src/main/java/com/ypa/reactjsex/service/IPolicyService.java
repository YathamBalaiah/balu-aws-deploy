package com.ypa.reactjsex.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ypa.reactjsex.model.PolicyBean;

public interface IPolicyService {

	Integer savePolicy(PolicyBean pb);

	List<PolicyBean> getAllPlicies();

	PolicyBean getOnePolicy(Integer id);

	void deletePolicy(Integer id);
	
}
