/**
* File: Problem2.java
* Class: CSCI 1302
* Author: Andrew Lantz
* Created on: Nov 22, 2025
* Last Modified: Nov 22, 2025
* Description: Lab 11
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
import java.util.ArrayList;
import java.util.Collections;

public class Problem2 {
	
	public static void main(String[] args) {
		String inputPath = "people.dat";
		String sortedOutputPath = "people-salary-sorted.dat";
		
		ArrayList<Person> people = new ArrayList<>();
		
		try (DataInputStream in = new DataInputStream(
				new BufferedInputStream(new FileInputStream(inputPath)))){
			
			while (true) {
				try {
					int age = in.readInt();
					String name = in.readUTF();
					String address = in.readUTF();
					int zip = in.readInt();
					double salary = in.readDouble();
					
					Person p = new Person(age, name, address, zip, salary);
					people.add(p);
				} catch (EOFException eof) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found: " + e.getMessage());
			return;
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		Collections.sort(people);
		
		try (DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream(sortedOutputPath)))) {
			
			for (Person p : people) {
				out.writeUTF(p.toString());
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("Output file could not be created: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
