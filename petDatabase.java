/*
 * Nicholas Saal
 * WEEK 2
 * PART 2
 * CSC 422
 */


package csc422PetDatabaseW2;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class petDatabase {

	
		static ArrayList<String> petData = new ArrayList<String>();
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        
	    
			
			int chosenNumber=0;
			
			  //Title
		     System.out.println("Pet Database Program \n");
		    //creating the scanner object
		     Scanner myObj = new Scanner(System.in);
		    
		       
		    while (chosenNumber != 7) {
	                //Calling method to display menu options    
	                displayMenu();
		       
	                //Taking users input to choose an option
	                chosenNumber = myObj.nextInt();
		  
		    
	                //Switch statement for handling users request from the main menu
	                switch (chosenNumber) {
	                  case 1:
	                          viewAllPets();
	                          System.out.print("Your Choice: "+ chosenNumber +"\n");
	                    break;

	                  case 2:
	                      addPets();
	                     System.out.print("Your Choice: "+ chosenNumber +"\n");
	                    break; 

	                  case 3:
	                	  removePet();
	                     System.out.print("Your Choice: "+ chosenNumber +"\n");
	                    break;

	                  case 4:
	                     System.out.println("your Choice: "+ chosenNumber);
	                     System.out.println("Goodbye!");
	                     return;
	                    }//end of switch

		      
		         }//end of while loop
	
		  
		}//end of main
		 //method for adding pets
	    static void addPets (){
	        
	    
	            Scanner input = new Scanner(System.in);
	           
	            boolean check = true;
	        do {
	    	   System.out.print("add pet (name, age): ");
	                   String strPetData = input.nextLine();
	                   if(strPetData.equals("done")){
	                       check = false;
	                   }
	                   else{
	                        petData.add(strPetData); 
	                   }   
	        }
	        while(check);	
		       //write to file
            try{
                FileOutputStream writeData = new FileOutputStream("output.txt");
                ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                writeStream.writeObject(petData);
                writeStream.flush();
                writeStream.close();

            }catch (IOException e) {
                e.printStackTrace();
            }
	        
	    }
	   
		
		//Method for displaying the option menu
		        static void displayMenu() {
		            System.out.println("What would you like to do?");
		            System.out.println("1) View all pets");
		            System.out.println("2) Add more pets");
		            System.out.println("3) Remove a pet");
		            System.out.println("4) Exit program");
		  }
		        
		        //method for viewing all pets
		        static void viewAllPets(){
		        System.out.printf("+--------------------------------------+ \n");
		        System.out.printf("+--ID----------NAME------------AGE-----+ \n");
		        System.out.printf("+--------------------------------------+ \n");
		        System.out.print(petData + "\n");
		        System.out.printf("+--------------------------------------+ \n");
		        }
		      
		       
		        //method for removing pet
		        static void removePet(){
		        	Scanner input = new Scanner(System.in);
		        	//input for removing pets from the array list
		        	System.out.print("Enter the pet ID to remove: \n");
		        	int removedPet = input.nextInt();
		        	
		        	petData.remove(removedPet);
		        	System.out.print(petData);
		        	
		         }       		      	      
		   
		       
		}//end of program
