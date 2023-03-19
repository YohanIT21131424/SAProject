package inventorypublisher;

import java.util.ArrayList;

public class VaccineServiceImpl implements VaccineService{
	private ArrayList<Vaccine> VaccineList = new ArrayList<Vaccine>();

	@Override
	public String publishService() {
		return "inventory publisher";
	}
	@Override
	public int addVaccine(int vaccID, String vaccName, String vaccPrice) {
		Vaccine vaccine = new Vaccine(vaccID, vaccName, vaccPrice);
		VaccineList.add(vaccine);
		return 1;
	}
	
	@Override
	public int updateVaccine(int vaccID, String vaccName, String vaccPrice) {
		try {
			for(Vaccine vacc : VaccineList) {
				if(vacc.getvaccID() == vaccID) {
					vacc.setvaccineName(vaccName);
					vacc.setvaccinePrice(vaccPrice);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	@Override
	public void displayVaccineStock() {
		int index = 0;
		for(Vaccine vaccine:VaccineList ) {
			index = index + 1;
			System.out.println(vaccine.getvaccID()+"\t"+vaccine.getvaccineName()+"\t\t"+vaccine.getvaccinePrice());	
		}
		if(index == 0) {
			System.out.println();
			System.out.println("No Vaccine Records Available");
		}
		
	}
	@Override
	public void deleteVaccine(int vaccID) {
		
		int index = vaccID - 1;
		VaccineList.remove(index);
	}
	@Override
	public void searchVaccine(int vaccID) {
		int index = 0;
		for(Vaccine vacc : VaccineList) {
			index = index + 1;
			if(vacc.getvaccID() == vaccID) {
				System.out.println(vacc.getvaccID()+"\t"+vacc.getvaccineName()+"\t\t"+vacc.getvaccinePrice());
			}
		}	
		if(index == 0) {
			System.out.println();
			System.out.println("No Vaccine Records Available");
		}
	}
}
