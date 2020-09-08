package model;

public class Employee {

	private int empId;
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String Age;
	private String DateofBirth;
	private String role;
	private String gender;
	private String Mobile;
	
	private String active;
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Employee() {
		
	}

	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/*@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId
				+ ", password=" + password + ", role=" + role + ", gender=" + gender + ", active=" + active + "]";
	}*/
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		this.Age = age;
	}
	public String getDateofBirth() {
		return DateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		this.DateofBirth = dateofBirth;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		this.Mobile = mobile;
	}
	/*public String getSkills() {
		return Skills;
	}
	public void setSkills(String skills) {
		this.Skills = skills;
	}*/
	public Employee(String firstName, String lastName, String userId, String password, String age, String dateofBirth,
			String role, String gender, String mobile, String active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.password = password;
		this.Age = age;
		this.DateofBirth = dateofBirth;
		this.role = role;
		this.gender = gender;
		this.Mobile = mobile;
		//this.Skills = skills;
		this.active = active;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId
				+ ", password=" + password + ", Age=" + Age + ", DateofBirth=" + DateofBirth + ", role=" + role
				+ ", gender=" + gender + ", Mobile=" + Mobile + ", active=" + active + "]";
	}
	
	
	
}