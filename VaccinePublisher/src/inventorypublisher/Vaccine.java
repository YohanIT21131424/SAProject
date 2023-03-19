package inventorypublisher;

public class Vaccine {
	public String vaccineName;
	private int vaccID;
	private String vaccinePrice;

	public Vaccine(int vaccID, String vaccineName, String vaccinePrice) {
		super();
		this.vaccID = vaccID;
		this.vaccineName = vaccineName;
		this.vaccinePrice = vaccinePrice;
	}
	
	public int getvaccID() {
		return vaccID;
	}

	public void setvaccID(int vaccID) {
		this.vaccID = vaccID;
	}

	public String getvaccineName() {
		return vaccineName;
	}

	public void setvaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	
	public String getvaccinePrice() {
		return vaccinePrice;
	}

	public void setvaccinePrice(String vaccinePrice) {
		this.vaccinePrice = vaccinePrice;
	}
	
}
