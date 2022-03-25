package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Country;
import model.CountryData;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		CountryData cntrs=new CountryData();
		
		File file=new File("paises.txt");
		FileInputStream fis= new FileInputStream(file);
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String line=br.readLine();
			String[] data=line.split(";");
			cntrs.male.add(new Country(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
			cntrs.female.add(new Country(data[0], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6])));
			cntrs.total.add(new Country(data[0], Integer.parseInt(data[1])+Integer.parseInt(data[4]), Integer.parseInt(data[2])+Integer.parseInt(data[5]), Integer.parseInt(data[3])+Integer.parseInt(data[6])));
		}
		cntrs.sortFallingMale();
		cntrs.sortFemale();
		cntrs.insertionSort(cntrs.total);
		
		String report=cntrs.getReport();
		System.out.println(report);
	}

}
