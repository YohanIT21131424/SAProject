package com.lab.LabTestProducer;

import java.util.ArrayList;
import java.util.Scanner;

public class LabTestProducerIMP implements LabTestProducer{
   
private ArrayList<LabTestModel> tests = new ArrayList<LabTestModel>();
	
	Scanner scan = new Scanner(System.in);
	
	
	//double array for store the existing tests
	private String[][] existingtests = {
			{"Sugar","This test check the sugar percentage","Rs.500.00"},
			{"Cholestrol","This test check the cholestrol percentage","Rs.1000.00"},
			{"PCR","This test check the covid-19 results","Rs.6500.00"},
			{"Blood","This test check the blood pressure","Rs.1500.00"},
			
	};
	
	//Adding data to ArrayList when program started
	public LabTestProducerIMP() {
		
		
		//tests = new ArrayList<LabTestModel>();
		
		// i refers to rows and 0,1,2 refers to columns
		for(int i = 0; i < 4;i++) {
			LabTestModel appModel = new LabTestModel(existingtests[i][0],existingtests[i][1],existingtests[i][2]);
			tests.add(appModel);
		}
		
		
		
		
	}
	
	
	// add new test to the existing tests
	@Override
	public void addnewTest() {
		
		char next = 'y';
		 
		//while user press yes
		while(next == 'Y' || next == 'y') {
			
			LabTestModel test = new LabTestModel();
			
			System.out.println("Enter lab test name : ");
			test.setTname(scan.nextLine());
			
			System.out.println("Enter lab test description : ");
			test.setDescription(scan.nextLine());
			
			System.out.println("Enter lab test price : ");
			test.setPrice(scan.nextLine());
			
			
			
			try {
				
				tests.add(test);
				System.out.println("////Test Added\\\\"); //new test added
				
			}catch(Exception t) {
				
				t.printStackTrace();
				System.out.println("Couldn't add this lab test");
				
			}
			
			
			
			do {
				
				System.out.println("Add another lab test? (Y/N) : ");
				next = scan.nextLine().charAt(0);
				
				if(next != 'n' && next != 'N' && next != 'y' && next != 'Y') {
					
					System.out.println("Invalid Input.");
				}
				
				}while(next != 'n' && next != 'N' && next != 'y' && next != 'Y');
		}
		
		
	}

	//display all lab Tests
	@Override
	public void viewAllTest() {
		
		System.out.println("========All details of lab tests========");
		 
		for(LabTestModel test: tests) {
			
			System.out.println("----------------------------------------");
			System.out.println("  Lab Test Name: "+test.getTname());
			System.out.println("  Lab Test Description: "+test.getDescription());
			System.out.println("  Lab Test Price: "+test.getPrice());
			System.out.println("----------------------------------------"); 
			
		}
		
		System.out.println("========================================");
		
	}

	//search test by test name
	@Override
	public void searchTest() {
		
		int status = 0;
		String name;
		int found = 0;
		char next = '1';
		
		LabTestProducerIMP newTmp = new LabTestProducerIMP();
		
		
		do {
		
		System.out.print("To find details, type the name of the lab test:  ");
		name = scan.nextLine();
		
	
		System.out.println("/////////Details of entered lab test\\\\\\\\\\");
		for(LabTestModel test: tests) {
			
			if(test.getTname().equalsIgnoreCase(name)) { //to ignore case-sensitive
				
				System.out.println("----------------------------------------");
				System.out.println("	Lab test name: "+ test.getTname());
				System.out.println("	Lab test description: "+ test.getDescription());
				System.out.println("	LAB test price: "+ test.getPrice());
				System.out.println("----------------------------------------");
				
				found =0;
				break;
				
				
			}else {
				
				
				found = 1;
			
			}
			
		}
		
		
		
		if(found == 0) {
			
			System.out.println("========================================");
			break;
		
		}
		
		if (found ==1) {
			
			System.out.println("\n\n\nLab test cannot find ... Please try again.");
			
			
			
			do {
				
				System.out.println("\n1.Search again\n" + "3.Exit *(Select 1-2)*\n");
				System.out.println("========================================");
				next = scan.nextLine().charAt(0);
				
				
				
				if(next != '1' && next != '2') {
					
					System.out.println("Return back");
				}
				
				
				if(next == '1'){
					
					newTmp.searchTest();
					
				}
				 
				if(next == '2'){
					status = 1;
					break;
					
				}
				
				
				}while(next != '1' && next != '2' );
			
			
			if(status == 1) {
				break;
				
				
				
			}

			
		}	
		
		}while(next == '1' && found == 0 );
		
		
	}
	
	//update test Details
	public void updateTest() {
		String upTestName, update,number;
		
		
		System.out.println("/////////////Update Lab Test Details\\\\\\\\\\\\\\ "+"\n"); 

		System.out.println("1. Update test name " + "\n" + "2. Update test description " + "\n" +"3. Update test price *(Select 1-3)*");
		number = scan.nextLine();

		System.out.println("Enter the name of the lab test to update:  ");
		upTestName = scan.nextLine();
		
		int status=0;

		switch (number) {
		case "1":
			
            //update test name
			for (LabTestModel t : tests) {

				try {
					if (t.getTname().equalsIgnoreCase(upTestName)) {
						
						status=1;

						System.out.println("Enter new test name: ");
						update = scan.nextLine();
						t.setTname(update);
						System.out.println("");
						System.out.println("***Details Updated***"+"\n");

					}
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Not able to change the test name. Please try again! ");
				}

			}
			break;

		case "2":
			
			//update test description
			for (LabTestModel t : tests) {

				try {
					if (t.getTname().equalsIgnoreCase(upTestName)) {
						
						status=1;

						System.out.println("Add new description about test: ");
						update = scan.nextLine();
						t.setDescription(update);
						System.out.println("**Details Updated**");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Not able to change the description. Please again! ");
				}
			}
			break;
		case "3":
			
			//update test price
			for (LabTestModel t : tests) {

				try {
					if (t.getTname().equalsIgnoreCase(upTestName)) {
						
						status=1;

						System.out.println("Enter new price: ");
						update = scan.nextLine();
						t.setDescription(update);
						System.out.println("**Details Updated**");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					System.out.println("Not able to change the description. Please try again!");
				}
			}
			break;

		default: {
			System.out.println("Invalid");
			break;
		}
		}if(status==0) {
			System.out.println("Cannot find lab test to update! Try a different name"+"\n");
		}

	}

	
}
