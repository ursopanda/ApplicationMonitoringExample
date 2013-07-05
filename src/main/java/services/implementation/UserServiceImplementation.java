package services.implementation;

import java.util.List;

import dao.UserDAO;
import domain.UserEntity;
import services.UserService;

//Realization of the UserService Interface

public class UserServiceImplementation implements UserService {

	UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	// This method gives us a chance to check, if the following user already
	// exists! If no, then we save the user into DB
	@Override
	public void createUser(UserEntity user) throws Exception {
		UserEntity userCheck = userDAO.getUserByUserName(user.getusername());
		if (userCheck != null) {
			throw new Exception("User with this username already exist!");
		}
		userDAO.save(user);
	}

	// This method checks if the login/password during login procedure is not
	// correct. If everything is ok, then we redirect user to his profile
	// page
	@Override
	public void loginUser(UserEntity user) throws Exception {
		UserEntity loginUser = userDAO.getUserByUserName(user.getusername());

		if ((!loginUser.getusername().equals(user.getusername()))
				|| (!loginUser.getpassword().equals(user.getpassword()))) {
			throw new Exception("Wrong login/pasword");
		}
	}
	
	public List<UserEntity> getAllData() {
		return userDAO.findAll();
	}

}