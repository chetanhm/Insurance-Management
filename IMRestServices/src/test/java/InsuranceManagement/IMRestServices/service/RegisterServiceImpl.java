package InsuranceManagement.IMRestServices.service;

import org.junit.Before;
import org.junit.Test;

import com.im.collection.UserDetails;
import com.im.repository.RegisterRepository;

public class RegisterServiceImpl {
	
	UserDetails user;
	RegisterRepository registerRepo;
	@Before
	public void setUp()
	{
		
		user=new UserDetails("Kanak" ,"Soni","Sai Harmony","MH","Pune","8987845123","kanak@gmail.com",	"kanka","kanak");
		
	}

	
	@Test
	public void saveData()
	{
		registerRepo.save(user);
	}
}
