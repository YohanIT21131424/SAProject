package employeeproducer;

import java.sql.Date;

public class Certification {
	private String name;

	public Certification(String name) {
		this.name = name;

	}

	public Certification(String name, Date issuedDate, Date expireDate) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
