package dao;

import java.util.List;

import javax.persistence.Query;

import domain.UserEntity;
import domain.base.GenericDAO;
import domain.base.GenericJPADAO;

//Realization of the UserDAO interface

@SuppressWarnings("unused")
public class UserJPADAO extends GenericJPADAO<UserEntity, Long> implements
		UserDAO {

	private static final String QUERY_USER = "select user from UserEntity user where user.username = :username";

	public UserJPADAO() {
		super(UserEntity.class);
	}

	// Here we get UserEntity with the same username (if this username already
	// exists)
	@Override
	public UserEntity getUserByUserName(String username) {

		Query query = getEntityManager().createQuery(QUERY_USER);
		query.setParameter("username", username);
		query.setMaxResults(1);

		@SuppressWarnings("unchecked")
		List<UserEntity> result = query.getResultList();
		if (result.size() == 0)
			return null;
		else
			return result.get(0);
	}

}
