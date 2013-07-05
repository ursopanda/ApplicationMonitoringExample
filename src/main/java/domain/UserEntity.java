package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import domain.base.BaseEntity;

// Here I describe, how the data will be stored

@Entity
@Table(name = "UserData")
public class UserEntity extends BaseEntity {
	private static final long serialVersionUID = -2816373868776366762L;

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String personalNumber;
	private String birthDate;

	/**
	 * @return the firstName
	 */
	public String getfirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getlastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the username
	 */
	public String getusername() {
		return username;
	}

	/**
	 * @param username
	 *            the usernam to set
	 */
	public void setusername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getpassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setpassword(String password) {
		this.password = password;
	}

	/**
	 * @return the personalNumber
	 */
	public String getpersonalNumber() {
		return personalNumber;
	}

	/**
	 * @param personalNumber
	 *            the personalNumber to set
	 */
	public void setpersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

}
