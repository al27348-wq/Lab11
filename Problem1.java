/**
* File: Problem1.java
* Class: CSCI 1302
* Author: Andrew Lantz
* Created on: Nov 22, 2025
* Last Modified: Nov 22, 2025
* Description: Lab 11
* 
* gethub: 
*/
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Problem1 {
	
	public static void main(String[] args) {
		String inputPath = "people.dat";
		String outputPath = "people-copy.dat";
		
		try (DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream(inputPath)));
				DataOutputStream out = new DataOutputStream(
						new BufferedOutputStream(new FileOutputStream(outputPath)))) {
				
					
				while (true) {
					try {
						
						int age = in.readInt();
						String name = in.readUTF();
						String address = in.readUTF();
						int zip = in.readInt();
						double salary = in.readDouble();
						
						System.out.println("Age: " + age);
						System.out.println("Name: " + name);
						System.out.println("Address: " + address);
						System.out.println("Zip: " + zip);
						System.out.printf("Salary: %.2f%n", salary);
						System.out.println("-------------------------------------");
						
						out.writeInt(age);
						out.writeUTF(name);
						out.writeUTF(address);
						out.writeInt(zip);
						out.writeDouble(salary);
						
					} catch (EOFException eof){
						
						break;
					}
				}
					} catch (FileNotFoundException e) {
		System.err.println("Input file not found: " + e.getMessage());
		
	} catch (IOException e) {
		e.printStackTrace();
	}
				}
		}


