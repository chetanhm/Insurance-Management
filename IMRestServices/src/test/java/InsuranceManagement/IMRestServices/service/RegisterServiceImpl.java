package InsuranceManagement.IMRestServices.service;

import org.junit.Before;
import org.junit.Test;

import com.mongo.UserRegisterPojo;
import com.respository.RegisterRepository;

public class RegisterServiceImpl {
	
	UserRegisterPojo user;
	RegisterRepository registerRepo;
	@Before
	public void setUp()
	{
		
		user=new UserRegisterPojo("Kanak" ,"Soni","Sai Harmony","MH","Pune","8987845123","kanak@gmail.com",	"kanka","kanak");
		
	}

	
	@Test
	public void saveData()
	{
		registerRepo.save(user);
	}
}
