package com.im.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.repository.TestRepository;

@Service
public class TestServiceImp implements TestService {
	@Autowired
	TestRepository registerRepository;
	
	public void TestMethod()
	{
		//System.out.println(registerRepository.findByName("chetan"));
	}
}
