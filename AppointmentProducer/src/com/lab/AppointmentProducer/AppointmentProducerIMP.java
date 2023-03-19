package com.lab.AppointmentProducer;

import java.util.ArrayList;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;  

public class AppointmentProducerIMP implements AppointmentProducer {
	
	
	private ArrayList<AppointmentModel> allAppointments;
	Scanner scn = new Scanner(System.in);
	
	//Get current date and TIME
	DateTimeFormatter formatter1  = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	DateTimeFormatter formatter2  = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime currentDateTime  = LocalDateTime.now();
	
	
	private String[][] existingAppointments = {
			{"Emily_Reynolds","I need to check my blod pressue ","2022/03/01","Female","sugar","2.00 P.M.","22","Emily_12:38:05"},
			{"Michael_Thompson","I would like to have my cholesterol levels checked.","2022/03/02","Male","cholestrol","3.00 P.M.","23","Michael_9:38:05"},
			{"Olivia_Cooper","I would like to undergo a rapid antigen test.  ","2022/03/02","Female","PCR","4.00 P.M.","26","Olivia_12:38:05"},
			{"David_Hughes","I prefer to schedule my appointment in the afternoon.","2022/03/03","Male","sugar","3.00 P.M.","26","David_9:38:05"},
			{"Sophia_Patel","I would like to schedule my appointment in the morning.","2022/03/03","Female","sugar","1.00 P.M.","25","Sophia_12:38:05"},
			{"Ethan_Walker","I wish to review my previous medical report.","2022/03/05","Male","","5.00 P.M.","21","Ethan_10:28:05"},
			{"Charlotte_Green","I want to have my blood pressure checked.","2022/03/03","Female","blood pressure","3.00 P.M.","23","Charlotte_10:02:05"},
			
	};
	
	//Adding data to ArrayList when program started
	public AppointmentProducerIMP() {
		
		
		allAppointments = new ArrayList<AppointmentModel>();
		
		for(int k = 0; k < 7;k++) {
			AppointmentModel appModel = new AppointmentModel(existingAppointments[k][0],existingAppointments[k][1],existingAppointments[k][2],existingAppointments[k][3],existingAppointments[k][4],existingAppointments[k][5],existingAppointments[k][6],existingAppointments[k][7]);
			allAppointments.add(appModel);
		}
		
		
	}
	
    // Add new Appointment 
	@Override
	public void addAppointment() {
		
		   
		   BufferedReader buffin  = new BufferedReader(new InputStreamReader(System.in));
		    	
		
			AppointmentModel newappoint = new AppointmentModel();
			
			System.out.println(" ");
			System.out.print(" Enter your name : ");
			
			try {
			      newappoint.setName(buffin.readLine());
			      
			}catch (IOException e) {
				 e.printStackTrace();
				
			}
			
			System.out.println(" ");
			System.out.print("Provide a description of the appointment. : ");
			try {
			      newappoint.setDescription(buffin.readLine());
			      
			}catch (IOException e) {
				 e.printStackTrace();
				
			}
			
			System.out.println(" ");
			System.out.print(" Enter your age :  ");
			try {
			      newappoint.setAge(buffin.readLine());
			      
			}catch (IOException e) {
				 e.printStackTrace();
				
			}
			
			
			//get date 
			newappoint.setDate(formatter1.format(currentDateTime ));
			
			//generate codeNumber
			newappoint.setCodeNumber(newappoint.getName()+"_"+formatter2.format(currentDateTime ));
			
			 while(true) {
			
			System.out.println("------------- ");
			System.out.println(" 1: Male");
			System.out.println(" 2: Female");
			System.out.println("------------- ");
			System.out.print(" Select gender : ");
		   
		    
		        
		        	 
		        	 int genderType = scn.nextInt();    
		        	 if(genderType >2){
			        	   
			        	   System.out.println("Incorrect gender type! Please try again.");
			        	   continue;
			           }
		        	 

			           if(genderType == 1 ) {
			        	   
			        	   newappoint.setGender("Male");
			           }else if(genderType == 2){
			        	   
			        	   newappoint.setGender("Female");
			           }
			           
			           //check whether the valid gender type is selected or not
			           if(genderType >0 && genderType <3){
			        	   
			        	   break;
		                }
		        	 
		        	 
		         }
			 
			 //select Test 	Type
			 while(true) {
	        	 
		         
		         System.out.println(" ");
		         System.out.println("----------------- ");
		         
		         System.out.println(" 1: Sugar Test");
				 System.out.println(" 2: Blood pressure Test");
				 System.out.println(" 3: Creatinine Test");
				 System.out.println(" 4: Urine Test");
				 System.out.println(" 5: PCR Test");
				 System.out.println(" 6: Dengue Test");
				 System.out.print(" Please select a test type : ");
				 
		         
		         int TestType = scn.nextInt();
		         System.out.println(" ");
				 System.out.println("----------------- ");
		        

			           if(TestType == 1 ) {
			        	   
			        	   newappoint.setTestType("Sugar");
			        	   
			           }else if(TestType == 2){
			        	   
			        	   newappoint.setTestType("Blood pressute");
			        	   
			           }else if(TestType == 3 ) {
			        	   
			        	   newappoint.setTestType("creatinine");
			        	   
			           }else if(TestType == 4){
			        	   
			        	   newappoint.setTestType("urine");
			        	   
			           }else if(TestType == 5 ) {
			        	   
			        	   newappoint.setTestType("PCR");
			        	   
			           }else if(TestType == 6){
			        	   
			        	   newappoint.setTestType("dengue");
			        	   
			           }
			           
			           
			           if(TestType >0 && TestType <7){
			        	   
			        	   break;
			        	   
			           }else {
			        	   
			        	   System.out.println("Incorrect test type! Please try again");
			           }
		        	 
		        	 
		         }
			 
			 //select Appointment Time
			 while(true) {
				 
		         
		         System.out.println(" ");
		         System.out.println("------------------ ");
		         
		         System.out.println(" 1:- 8.00 A.M.");
				 System.out.println(" 2:- 1.30 P.M.");
				 System.out.println(" 3:- 4.00 P.M.");
				 System.out.println(" 4:- Request for different time for appointment ");
				 System.out.println("------------------ ");
                 System.out.print(" Please select an option : ");
		         
		         int TimeType = scn.nextInt();
		         
		         System.out.println(" ");	        	 

			           if(TimeType == 1 ) {
			        	   
			        	   newappoint.setTimeType("8.00 A.M.");
			        	   
			           }else if(TimeType == 2){
			        	   
			        	   newappoint.setTimeType("1.30 P.M.");
			           }else if(TimeType == 3 ) {
			        	   
			        	   newappoint.setTimeType("4.00 P.M.");
			        	   
			           }else if(TimeType == 4){
			        	   
			        	   // request different time for appointment
			        	   System.out.print(" Select the appropriate time for the appointment : ");
			        	   String newTime = scn.next();
			        	   newappoint.setTimeType(newTime);
			           }
			           
			           if(TimeType >0 && TimeType <5){
			        	   
			        	   break;
			           }else {
			        	   
			        	   System.out.println("Incorrect type! Please try again");
			           }
		        	 
		        	 
		         }
		         
		         try {
		        	 
		        	 allAppointments.add(newappoint);
		        	 System.out.println("\n=====================================\n");
		        	 System.out.println(" Appointment added successfully");
		        	 System.out.println("\n \n=====================================");
		        	 
		         }catch (Exception e) {
		        	 
		        	 e.printStackTrace();
		        	 System.out.println("Error occured while adding appointment! please try again.");
		         }
			
   }
    
	//Display All Appointments 
	@Override
	public void displayAppointment() {
		
		System.out.println("------ All appointments ------");
		
		System.out.println("====================================\n\n");
		
        for(AppointmentModel app: allAppointments) {
			
        	System.out.println("                                  ");
        	System.out.println("CodeNumber : " + app.getCodeNumber());
        	System.out.println("Name : " + app.getName());
			System.out.println("Description : " + app.getDescription());
			System.out.println("Age : " + app.getAge());
			System.out.println("Gender : "+app.getGender());
			System.out.println("Date :" + app.getDate());
			System.out.println("Test type : "+app.getTestType());
			System.out.println("Time : " + app.getTimeType());
			System.out.println("====================================\n\n");
			
		}
		
		
	}
    
	// Search Appointment by Name or Test Type
	@Override
	public void searchAppointment() {
		
		
				String name,TestType;
				
				System.out.println("1: Search by name");
				System.out.println("2: Search by TestType");
				System.out.print("select an option : ");
                int select = scn.nextInt();
                
                // search by name
                if(select  == 1) {
                	
                	System.out.print("Enter appointer's name: ");
    				name = scn.next();
    				
    				for(AppointmentModel app: allAppointments) {
    					
    					if(app.getName().equalsIgnoreCase(name)) {
    						
    						System.out.println("\n\n\n---Appointment---");
    						System.out.println("-----------------------------------");
    						
    						System.out.println("CodeNumber : " + app.getCodeNumber());
    						System.out.println("Name : " + app.getName());
    						System.out.println("Description : " + app.getDescription());
    						System.out.println("Age : " + app.getAge());
    						System.out.println("Gender : "+app.getGender());
    						System.out.println("Date :" + app.getDate());
    						System.out.println("Test type : "+app.getTestType());
    						System.out.println("Time : " + app.getTimeType());
    						
    						System.out.println("-----------------------------------");
    					}
    					
    				}
                
    			//search by Test Type
                }else if(select == 2){
                	
                	System.out.print("Enter Test Type : ");
    				TestType = scn.next();
    				
    				System.out.println("");
					System.out.println("---Appointment---");
    				
    				for(AppointmentModel app: allAppointments) {
    					
    					
    					
    					if(app.getTestType().equalsIgnoreCase(TestType)) {
    						
    						
    						System.out.println("-----------------------------------");
    						
    						System.out.println("CodeNumber : " + app.getCodeNumber());
    						System.out.println("Name : " + app.getName());
    						System.out.println("Description : " + app.getDescription());
    						System.out.println("Age : " + app.getAge());
    						System.out.println("Gender : "+app.getGender());
    						System.out.println("Date :" + app.getDate());
    						System.out.println("Test type : "+app.getTestType());
    						System.out.println("Time : " + app.getTimeType());
    						
    						
    						System.out.println("-----------------------------------");
    					}
    					
    				}
                	
                }else if(select < 0 || select >2) {
                	System.out.println("-----------------------------------\n\n");
                	System.out.println("Invalid type... Please try again.");
                	System.out.println("\n\n-----------------------------------");
                	
                }	
	}

    // Generate Bill for Appointment
	@Override
	public void generateAppointmentBills() {
		
		 String codenumber,testType = " ";
		 double temp =0;
		 double total = 0,bookingPrice = 0;
		
		
		System.out.print("Enter the code number : ");
		codenumber = scn.next();
		
		System.out.println("");
		
		for(AppointmentModel app: allAppointments) {
			
			if(app.getCodeNumber().equalsIgnoreCase(codenumber)) {
						
				testType = app.getTestType();
				
			}
			
		}
		System.out.println(" ");
		System.out.println("------ Price List ------");
		   System.out.println(" Sugar test : Rs.250.00 ");
		   System.out.println(" Lipid test : Rs.850.00 ");
		   System.out.println(" creatinine test : Rs.1250.00 ");
		   System.out.println(" urine test : Rs.280.00 ");
		   System.out.println(" Antigen test : Rs.1890.00 ");
		   System.out.println(" dengue test : Rs.2000.00 ");
		   
		   
		   if(testType.equalsIgnoreCase("Sugar")) {
        	   
        	    temp = 250.00;
        	   
           }else if(testType.equalsIgnoreCase("Lipid")){
        	   
        	    temp = 850.00; 
        	   
           }else if(testType.equalsIgnoreCase("Creatinine") ) {
        	   
        	   temp = 1250.00; 
        	   
           }else if(testType.equalsIgnoreCase("Urine")){
        	   
        	   temp = 280.00; 
        	   
           }else if(testType.equalsIgnoreCase("Antigen") ) {
        	   
        	   temp = 1890.00; 
        	   
           }else if(testType.equalsIgnoreCase("Dengue")){
        	   
        	   temp = 2000.00; 
        	   
           }
		   
		   bookingPrice = 110.00;
		   
		   total = bookingPrice + temp;
		   
		   System.out.println("======================================== ");
		   System.out.println(" ");
		   System.out.println(" Appointment bill for : " + codenumber  );
		   System.out.println(" ");
		   System.out.println("======================================== ");
		   System.out.println(" Booking price : " + bookingPrice);
		   System.out.println(" " + testType + " Test price : " + temp);
		   System.out.println("==============");
		   System.out.println(" Total bill : " + total);
		   System.out.println("==============");
		
	}
	
  
}
