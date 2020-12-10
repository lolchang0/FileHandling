package handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class FileHandling {
	public static void main(String[] args) {
		
		//initializing scanners
		Scanner scanWrite = new Scanner(System.in); 
		Scanner scanChoice = new Scanner(System.in);
		
		//welcome statement
		System.out.println("Welcome to my FIle Handling Program");
		
		//User choice variable at menu screen
		char choice;
		do {
			
			//menu screen
			System.out.println("1. Write to File");
			System.out.println("2. Read From File");
			System.out.println("3. Append to File");
			System.out.println("4. Exit");
			System.out.println("Please select an option: ");
			
			//user choice of input
			choice = scanChoice.next().charAt(0);
			
			//switch case for each choice option
			switch(choice) {
			
			//option to write to a file
			case '1':
				//BufferedWriter to my EmployeeNames.txt file
				try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\EclipseWorkSpace\\FileHandling\\src\\handling\\EmployeeNames.txt", true))){
						
						//enter a name
						System.out.println("Please enter a name: ");
						String input = scanWrite.nextLine();
						//creates a new line for the new name
						bw.newLine();
						bw.write(input);
						
						//close the BufferedWriter
						bw.close();
						
					//Exception Handling
					} catch(FileNotFoundException e){
						e.printStackTrace();
					} catch(IOException e) {
						e.printStackTrace();
					}
				break;
			//option for reading the file
			case '2':
				try(BufferedReader br = new BufferedReader(new FileReader("D:\\EclipseWorkSpace\\FileHandling\\src\\handling\\EmployeeNames.txt"))){
					String line = br.readLine();
					while(line != null) {
						System.out.println(line);
						line = br.readLine();
					}
					
				//Exception Handling
				} catch(FileNotFoundException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
				break;
			//option for appending to a file
			case '3':
				try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\EclipseWorkSpace\\FileHandling\\src\\handling\\EmployeeNames.txt", true))){
					
					Scanner scan = new Scanner(System.in);
					System.out.println("Please enter a name: ");
					String input = scan.nextLine();
					bw.newLine();
					bw.append(input);
					bw.close();
					
				//Exception Handling
				} catch(FileNotFoundException e){
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
				break;
			//option to exit the program
			case '4':
				System.out.println("Successfully exited the program");
				System.exit(0);
			//case for invalid inputs
			default:
				System.out.println("Invalid Input");
				break;
			}
		//condition to continue while loop
		}while(choice != '4');
	}
}
