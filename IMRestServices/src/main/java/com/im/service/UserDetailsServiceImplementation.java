package com.im.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.im.collection.UserDetails;
import com.im.entity.Registration;
import com.im.repository.RegisterRepository;
import com.im.util.MailMail;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
ApplicationContext context;
	@Autowired
	private RegisterRepository registerRepository;

	public UserDetails insertUser(UserDetails register) {
		return registerRepository.insert(register);

	}

	public UserDetails getUserById(String id) {
		return registerRepository.findOne(id);

	}

	public UserDetails logoutUser(String id)
	{
		UserDetails userDetails = registerRepository.findOne(id);
		if(userDetails!=null)
		{
			userDetails.setLoginStatus("Logged Out");
			registerRepository.save(userDetails);
			return userDetails;
		}
		else
		{
			return null;
		}
		
	}
	public void deleteUser(String userName) {

		registerRepository.delete(userName);

	}

	public UserDetails saveUser(UserDetails userDetails) {
		return registerRepository.save(userDetails);
	}

	public UserDetails loginUser(String userName, String password) {

		UserDetails userDetails = registerRepository.findByUserName(userName);
		if (userDetails != null) {

			if (userDetails.getPassword().equals(password)) {
				userDetails.setLoginStatus("Logged In");
				registerRepository.save(userDetails);
				return userDetails;
			} else {
				return null;
			}
		} else {
			return null;

		}
	}

	public com.im.collection.UserDetails getUserByUsername(String userName) {

		UserDetails userDetails = registerRepository.findByUserName(userName);

		return userDetails;

	}

	public UserDetails getUserByEmail(String email) {
		return registerRepository.findByEmail(email);
	}


	public UserDetails registerManagedCustomer(Registration managedCustomer,String agentUserName) {
	UserDetails userDetails=new UserDetails(managedCustomer.getFirstName(),managedCustomer.getLastName(),managedCustomer.getAddress(),managedCustomer.getState(),managedCustomer.getCity(),managedCustomer.getContactNo(),managedCustomer.getEmail(),managedCustomer.getUserName(),managedCustomer.getPassword());	
	userDetails.setUserType("managed");
	userDetails.setAgentUserName(agentUserName);
	registerRepository.insert(userDetails);
	
	context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
	    	String emailId=userDetails.getEmail();
	    	MailMail mm = (MailMail) context.getBean("mailMail");
	        mm.sendMail("xorinsurancemanagement@gmail.com",emailId,"Worldwide Life Insurance","Hello "+userDetails.getFirstName()+"\nThank you for your interest. We are happy to have you as our customer. \n username: "+userDetails.getUserName()+" & password: "+userDetails.getPassword()+"\n\nRegards,\n"+userDetails.getAgentUserName()+"\nWorldwide Life Insurance");
		return userDetails;
	}

	public UserDetails setAgentStatus(String userName, String userType) {
		// TODO Auto-generated method stub
		UserDetails updateUserDetails = registerRepository.findByUserName(userName);
		updateUserDetails.setUserType(userType);
		registerRepository.save(updateUserDetails);
		return updateUserDetails;
	}

	public List<UserDetails> getUserByAgentName(String agentUserName) {
		return registerRepository.findByAgentUserName(agentUserName);
		
	}
}
