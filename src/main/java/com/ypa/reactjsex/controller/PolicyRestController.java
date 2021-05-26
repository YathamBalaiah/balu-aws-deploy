package com.ypa.reactjsex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ypa.reactjsex.model.PolicyBean;
import com.ypa.reactjsex.service.IPolicyService;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
@CrossOrigin(origins="http://localhost:8080")

@RequestMapping("/policies")
public class PolicyRestController {
	
	@Autowired
	private IPolicyService service;
	
	//1. save 
	@PostMapping("/save")
	public ResponseEntity<String> savePolicy(
			@RequestBody PolicyBean policyb
			) 
	{
		System.out.println("inside savePolicy");
		Integer id = service.savePolicy(policyb);
		
		return new ResponseEntity<String>(
				"PolicyBean '"+id+"' saved", 
				HttpStatus.OK);
	}

	//2. fetch all
	@GetMapping("/all") 
	public ResponseEntity<List<PolicyBean>> getAllPolicy() {
		System.out.println("inside get all policies ");
		
		List<PolicyBean> list = service.getAllPlicies();
		System.out.println("data from db "+list);
		
		return new ResponseEntity<List<PolicyBean>>(list,HttpStatus.OK);  
	}
	//3. fetch one
		@GetMapping("/one/{id}")
		public ResponseEntity<PolicyBean> getOnePolicy(
				@PathVariable Integer id
				) 
		{
			
			PolicyBean PolicyBean = service.getOnePolicy(id);
			
			return new ResponseEntity<PolicyBean>(PolicyBean,HttpStatus.OK);
		}
	
		//4. delete
		@DeleteMapping("/remove/{id}") 
		public ResponseEntity<String> deletePolicy(
				@PathVariable Integer id
				) 
		{
			service.deletePolicy(id);
			return new ResponseEntity<String>(
					"Policy is  '"+id+"' Deleted",
					HttpStatus.OK);
		}
		
		/*
		 * //5. update
		 * 
		 * @PutMapping("/modify/{id}") public ResponseEntity<String> updatePolicyBean(
		 * 
		 * @PathVariable Integer id,
		 * 
		 * @RequestBody PolicyBean PolicyBean ) { PolicyBean db =
		 * service.getOnePolicy(id)
		 * 
		 * db.setEmpName(PolicyBean.getEmpName()); db.setEmpSal(PolicyBean.getEmpSal());
		 * db.setEmpDept(PolicyBean.getEmpDept());
		 * 
		 * service.savePolicy(pb)
		 * 
		 * return new ResponseEntity<String>( "PolicyBean '"+id+"' Updated",
		 * HttpStatus.OK); }
		 */
		
		


}
