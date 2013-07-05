package services;

import java.util.List;

import domain.UserEntity;

// Budet obrabativatj vse dannie

public interface UserService {

	public void createUser(UserEntity user) throws Exception;

	public void loginUser(UserEntity user) throws Exception;
	
	public List<UserEntity> getAllData();

}
