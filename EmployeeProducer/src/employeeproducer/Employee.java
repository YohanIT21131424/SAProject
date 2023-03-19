package employeeproducer;

import java.util.List;

public class Employee {

	private int id;
	private String name;
	private String occupation;
	private String email;
	private String phone;
	private List<Certification> certifications;

	public Employee(int id, String name, String occupation, String email, String phone,
			List<Certification> certifications) {
		this.id = id;
		this.name = name;
		this.occupation = occupation;
		this.email = email;
		this.phone = phone;
		this.certifications = certifications;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}
}
