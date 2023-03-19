package inventorysubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import inventorypublisher.VaccineService;

public class VaccineServiceActivator implements BundleActivator {

	private ServiceReference vaccineRef;
	private ServiceRegistration vaccineReg;

	private VaccineService vaccineService;
	
	Scanner myScanner = new Scanner(System.in);
	Scanner add = new Scanner(System.in);
	
	public void start(BundleContext context) throws Exception {
		System.out.println("Vaccine Subscriber Service Started!");
		
		vaccineReg = context.registerService(this.getClass().getName(), this, null);

		vaccineRef = context.getServiceReference(VaccineService.class.getName());
	    vaccineService = (VaccineService)context.getService(vaccineRef); 
	}
	
	public void displayMenu() {		
	    int no;
		System.out.println("Welcome to Vaccine Service");
		System.out.println();
		System.out.println("1. Add New Vaccine");
		System.out.println("2. Display Vaccine Details");
		System.out.println("3. Update Vaccine");
		System.out.println("4. Delete Vaccine");
		System.out.println("5. Search Vaccine");
		System.out.println("6. Exit");
		System.out.println();		
		System.out.print("Enter Number: ");
		no = myScanner.nextInt();
		System.out.println();
		
		while(true) {
			if(no == 1||no == 01) {
					try {
							int vaccID;
							String vaccineName, vaccinePrice;
							
							System.out.print("Enter Vaccine ID:");
							vaccID = add.nextInt();
							add.nextLine();
							System.out.print("Enter Vaccine Name:");
							vaccineName = add.nextLine();
							System.out.print("Enter Vaccine Price:");
							vaccinePrice = add.nextLine();
							System.out.println();
							
							int status = vaccineService.addVaccine(vaccID, vaccineName, vaccinePrice);
							if(status == 1) {
								System.out.println("Vaccine added Successfully!");
								System.out.println();
						}
					} catch (Exception e) {
						System.out.println("Vaccine not added!");
						e.printStackTrace();
					}
									
				System.out.println("1. Add New Vaccine");
				System.out.println("2. Display Vaccine Details");
				System.out.println("3. Update Vaccine");
				System.out.println("4. Delete Vaccine");
				System.out.println("5. Search Vaccine");
				System.out.println("6. Exit");
				System.out.println();				
				System.out.print("Enter Number: ");
				no = myScanner.nextInt();
				System.out.println();
				
			}
			else if(no == 2||no == 02) {
				try {
					System.out.println("****Vaccine Details****");
					System.out.println();
					System.out.println("ID\tName\t\tPrice");
					System.out.println();
					vaccineService.displayVaccineStock();
					System.out.println();
					System.out.println("1. Add New Vaccine");
					System.out.println("2. Display Vaccine Details");
					System.out.println("3. Update Vaccine");
					System.out.println("4. Delete Vaccine");
					System.out.println("5. Search Vaccine");
					System.out.println("6. Exit");
					System.out.println();		
					System.out.print("Enter Number: ");
					no = myScanner.nextInt();
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			else if(no == 3||no == 03) {
				try {
					System.out.println();
					int vacID;
					String newVaccName, newVaccPrice;
					
					Scanner upd = new Scanner(System.in);
					
					System.out.println("Enter Vaccine ID: ");
					vacID = upd.nextInt();
					upd.nextLine();
					System.out.println("Enter New Vaccine Name: ");
					newVaccName = upd.nextLine();
				
					System.out.println("Enter New Vaccine Price: ");
					newVaccPrice = upd.nextLine();
					
					int status = vaccineService.updateVaccine(vacID, newVaccName, newVaccPrice);
					if(status == 1) {
						System.out.println("Vaccine Updated Successfully!");
						System.out.println();
					}
					
					System.out.println();
					System.out.println("1. Add New Vaccine");
					System.out.println("2. Display Vaccine Details");
					System.out.println("3. Update Vaccine");
					System.out.println("4. Delete Vaccine");
					System.out.println("5. Search Vaccine");
					System.out.println("6. Exit");
					System.out.println();		
					System.out.print("Enter Number: ");
					no = myScanner.nextInt();
					System.out.println();
				} catch (Exception e) {
					System.out.println("Vaccine Not Updated!");
					e.printStackTrace();
				}
			}
			else if(no == 4||no == 04) {
				try {
					System.out.println("Enter Vaccine ID");
					int vacID = myScanner.nextInt();
					System.out.println();
					System.out.println("Vaccine ID: "+vacID+" is deleted!");
					System.out.println();
					vaccineService.deleteVaccine(vacID);
					System.out.println("1. Add New Vaccine");
					System.out.println("2. Display Vaccine Details");
					System.out.println("3. Update Vaccine");
					System.out.println("4. Delete Vaccine");
					System.out.println("5. Search Vaccine");
					System.out.println("6. Exit");
					System.out.println();		
					System.out.print("Enter Number: ");
					no = myScanner.nextInt();
					System.out.println();
				} catch (Exception e) {
					System.out.println("Vaccine Was Not Delelted!");
					e.printStackTrace();
				}
			}
			else if (no == 5||no == 05) {
				try {
					System.out.println("Enter Vaccine ID");
					int vacID = myScanner.nextInt();
					System.out.println();
					System.out.println("****Vaccine Details****");
					System.out.println();
					System.out.println("ID\tName\t\tPrice");
					System.out.println();
					vaccineService.searchVaccine(vacID);
					System.out.println();
					System.out.println("1. Add New Vaccine");
					System.out.println("2. Display Vaccine Details");
					System.out.println("3. Update Vaccine");
					System.out.println("4. Delete Vaccine");
					System.out.println("5. Search Vaccine");
					System.out.println("6. Exit");
					System.out.println();		
					System.out.print("Enter Number: ");
					no = myScanner.nextInt();
					System.out.println();
				} catch (Exception e) {
					System.out.println("Invalid Vaccinatin ID");
					e.printStackTrace();
				}
			}
			else if(no == 6||no == 06) {
				System.out.println("Thank You For Using the Vaccine Service");
				break;
			}
			else {
					System.out.println("Enter a valid number!");
					System.out.println();
					System.out.println("1. Add New Vaccine");
					System.out.println("2. Display Vaccine Details");
					System.out.println("3. Update Vaccine");
					System.out.println("4. Delete Vaccine");
					System.out.println("5. Search Vaccine");
					System.out.println("6. Exit");
					System.out.println();		
					System.out.print("Enter Number: ");
					no = myScanner.nextInt();
					System.out.println();	
			}
		}
	}
	

	public void stop(BundleContext Context) throws Exception {
		try {
			System.out.println("Service ended!!!");
			Context.ungetService(vaccineRef);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
