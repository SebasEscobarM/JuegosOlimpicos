package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CountryData{
	
	public ArrayList<Country> male=new ArrayList<>();
	public ArrayList<Country> female=new ArrayList<>();
	public ArrayList<Country> total=new ArrayList<>();
	
	public String getReport() {
		String report="Masculino \n";
		for(Country c:male) {
			report+=c.getName()+" "+c.getGold()+" "+c.getSilver()+" "+c.getBonce()+"\n";
		}
		report+="----------\nFemenino\n";
		for(Country c:female) {
			report+=c.getName()+" "+c.getGold()+" "+c.getSilver()+" "+c.getBonce()+"\n";
		}
		report+="----------\nCombinado\n";
		for(Country c:total) {
			report+=c.getName()+" "+c.getGold()+" "+c.getSilver()+" "+c.getBonce()+"\n";
		}
		return report;
	}
	public void sortFemale() {
		Collections.sort(female);
	}
	public void sortFallingMale() {
		Collections.sort(male,new Comparator<Country>() {;
			@Override
			public int compare(Country A, Country B) {
				int ans= B.getGold()-A.getGold();
				if(ans==0) {
					ans=B.getSilver()-A.getSilver();
					if(ans==0) {
						ans=B.getBonce()-A.getBonce();
						if(ans==0) {
							ans= B.getName().compareTo(A.getName());
						}
					}
				}
				return ans;
			}
		});
	}
	public void insertionSort(ArrayList<Country> arr) {
		for(int i=1;i<arr.size();i++) {
			for(int j=0;j<i;j++) {
				if(arr.get(i).getGold()>arr.get(j).getGold()) {
					Country x=arr.get(i);
					arr.remove(i);
					arr.add(j, x);
					break;
				}else if(arr.get(i).getGold()==arr.get(j).getGold()) {
					if(arr.get(i).getSilver()>arr.get(j).getSilver()) {
						Country x=arr.get(i);
						arr.remove(i);
						arr.add(j, x);
						break;
					}else if(arr.get(i).getSilver()==arr.get(j).getSilver()) {
						if(arr.get(i).getBonce()>arr.get(j).getBonce()) {
							Country x=arr.get(i);
							arr.remove(i);
							arr.add(j, x);
							break;
						}else if(arr.get(i).getBonce()==arr.get(j).getBonce()) {
							int a=arr.get(i).getName().compareTo(arr.get(j).getName());
							if(a<0) {
								Country x=arr.get(i);
								arr.remove(i);
								arr.add(j, x);
							}
						}
					}
				}
			}
		}
	}
}
