package model;

public class Country implements Comparable{
	
	private String name;
	private int gold;
	private int silver;
	private int bonce;
	
	public Country(String name, int gold, int silver, int bonce) {
		this.name = name;
		this.gold = gold;
		this.silver = silver;
		this.bonce = bonce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getBonce() {
		return bonce;
	}

	public void setBonce(int bonce) {
		this.bonce = bonce;
	}

	@Override
	public int compareTo(Object o) {
		Country A=this;
		Country B=(Country)o;
		int ans= A.gold-B.gold;
		if(ans==0) {
			ans= A.silver-B.silver;
			if(ans==0) {
				ans=A.bonce-B.bonce;
				if(ans==0) {
					ans=B.name.compareTo(A.name);
				}
			}
		}
		return ans;
	}
	
	
}
