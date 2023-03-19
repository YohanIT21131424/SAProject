package inventorypublisher;

public interface VaccineService {
	public String publishService();
	public int addVaccine(int vaccID, String vacName, String vacPrice);
	public void displayVaccineStock();
	public void deleteVaccine(int vaccID);
	public int updateVaccine(int vaccID, String vacName, String vacPrice);
	public void searchVaccine(int vaccID);
}