package dao;

import domain.UserEntity;
import domain.base.GenericDAO;

// This interface will work with the data: it will save and call for the data from DB

public interface UserDAO extends GenericDAO<UserEntity, Long> {

	public UserEntity getUserByUserName(String username);

}