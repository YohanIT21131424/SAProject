package com.lab.TestReportProducer;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;  

public class TestReportProducerIMP implements TestReportProducer {
	
	private ArrayList<TestReportModel> testrep;
	BufferedReader buffin  = new BufferedReader(new InputStreamReader(System.in));
	
	Scanner tst =new Scanner(System.in);

	//store data in double string array
	private String[][] exhistingTestReports = {
			{"1","Sugar Test","Emily Reynolds","350mg/dL","Your sugar level is high","11/03/2022"},
			{"2","Lipid Test","Michael Thompson","150 mg/dL","Your test result is normal","15/02/2022"},
			{"3","Creatinine Test","Olivia Cooper","40mm/Hg","You have to contact a doctor immediately","07/01/2022"},
			{"4","Blood Test","David Hughes","4.1 hpf","You have to drink more water","18/01/2022"},
			{"5","PCR Test","Sophia Patel","Negative","You got negative results","25/02/2022"}
			};
	
	//add string array data to array list
	public TestReportProducerIMP(){
				
		
		testrep = new ArrayList<TestReportModel>();
		
		//i refers to rows
		for(int i = 0; i < 5;i++) {
			TestReportModel testrepo = new TestReportModel(exhistingTestReports[i][0],exhistingTestReports[i][1],exhistingTestReports[i][2],exhistingTestReports[i][3],exhistingTestReports[i][4],exhistingTestReports[i][5]);
			testrep.add(testrepo);
		}
		
	}
	
	// add new test report 
	@Override
	public void addTestReport() {
		
		char check = 'y';
		int id = 6;
		
		System.out.println("====== Generate Test Report ======");
		
		while(check == 'y' || check == 'Y') {
			TestReportModel tstrpt = new TestReportModel();
			
			String nID = String.valueOf(id);
			
			tstrpt.setId(nID);
			
			System.out.print("Enter the name of the test that have been done : ");
			try {
				
				tstrpt.setTestName(buffin.readLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			System.out.print("Enter patient name : ");
            try {
				
            	tstrpt.setPatientName(buffin.readLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			System.out.print("Enter the final output of the test : ");
			 try {
					
				 tstrpt.setTestStatus(buffin.readLine());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			
			
			System.out.print("Enter a description about the test result : ");
			try {
				tstrpt.setDescription(buffin.readLine());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now(); //system time
			tstrpt.setDate(dtf.format(now));
			
			try {
				
				testrep.add(tstrpt);
				
			}catch(Exception e) {
				
				e.printStackTrace();
				System.out.println("Error occured while generating the test report. Please try again.");
			}
			
			System.out.println("Do you want to create another test report?(Y/N) : ");
			try {
				
				check = (char) buffin.read();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			id = id + 1;
		}
		
	}
     
	//display test reports
	@Override
	public void viewTestReports() {
		
		System.out.println("1. View selected test report"); //to view the selected test report
		System.out.println("2. View all test reports"); //to view all test report
		System.out.println("Select option : ");
		int input = tst.nextInt();
		
		if (input == 1) { //if input == 1
			
			String searchName;
				
			System.out.println("Enter test report ID or patient name: ");
			searchName = tst.next();
			
			
			
			//display specific testReport details
			for(TestReportModel testreport: testrep) {
				
				if((testreport.getId().equalsIgnoreCase(searchName)) || (testreport.getPatientName().equalsIgnoreCase(searchName))) {
					
					System.out.println("Details about the selected test report");
					System.out.println("================================");
					System.out.println("                                ");
					System.out.println("Test Id: " + testreport.getId()); //id of the report
					System.out.println("Test Name: " + testreport.getTestName()); //test type name
					System.out.println("Patient Name: " + testreport.getPatientName()); //patient name
					System.out.println("Test Status: " + testreport.getTestStatus()); //status about the test
					System.out.println("Description: " + testreport.getDescription()); //brief description 
					System.out.println("Test Date: " + testreport.getDate()); //date
					System.out.println("                                ");
					System.out.println("---------------------------------");
					
				}
				
			}
		
			}
			
		else {
		
		//it will display all test reports
		System.out.println("All the test reports");
		System.out.println("-----------------------------");
		
		for(TestReportModel testreport: testrep) {
			System.out.println("                                ");
			System.out.println("Test ID: " + testreport.getId());
			System.out.println("Test Name: " + testreport.getTestName());
			System.out.println("Patient Name: " + testreport.getPatientName());
			System.out.println("Test Status: " + testreport.getTestStatus());
			System.out.println("Description: " + testreport.getDescription());
			System.out.println("Test Date: " + testreport.getDate());
			
			System.out.println("================================");
			
		}
		
	}
}
}