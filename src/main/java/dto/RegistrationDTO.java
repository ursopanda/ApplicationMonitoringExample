package dto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.acegisecurity.annotation.Secured;

import services.UserService;
import domain.UserEntity;

// This class will save the values from registration form into these variables!
@Secured(value = { "" })
public class RegistrationDTO {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String personalNumber;
	private String birthDate;
	private UserService userService;
	
	private List<UserEntity> users;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// This method will put all collected data into UserEntity and send it to DB
	//This method is also marked with annotation @Secured() for EIS monitoring
	@Secured(value = { "" })
	public void register(ActionEvent event) throws Exception {
		// Monitor mon=MonitorFactory.start("myFirstMonitor");;
		UserEntity user = new UserEntity();
		user.setfirstName(firstName);
		user.setlastName(lastName);
		user.setusername(username);
		user.setpassword(password);
		user.setpersonalNumber(personalNumber);
		try {
			userService.createUser(user);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Success!","Registration successful!"));
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error!", e.getMessage()));
		}
	}

	// This method will redirect the user, if the login is successful

	public void login(ActionEvent event) {
		UserEntity user = new UserEntity();
		user.setusername(this.username);
		user.setpassword(this.password);
		try {
			userService.loginUser(user);
			// here the redirect is done!
			FacesContext.getCurrentInstance().getExternalContext().redirect("/registration/app/account");
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Fail!",""));
		}
	}
	
	public void getAllUsers(ActionEvent event){
		users = userService.getAllData();
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	/**
	 * @return the users
	 */
	public List<UserEntity> getUsers() {
		return users;
	}

}