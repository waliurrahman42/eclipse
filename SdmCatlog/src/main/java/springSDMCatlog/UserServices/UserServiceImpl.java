package springSDMCatlog.UserServices;

import java.util.List;

import springSDMCatlog.entity.User;

public class UserServiceImpl  implements UserService{

	
	List<User> list=List.of(
		new User(1231L,"wali","213443788"),
		new User(1232L,"wali rahman","2134434"),
		new User(1242L,"wali wali","2134")	
	);
	
	
	@Override
	public User getUser(Long id) {
		
		return null;
	}
	
	
}
