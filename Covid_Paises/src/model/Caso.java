package model;

import java.util.Date;

public class Caso {
	private Date dateRep;
	private long cases;
	private int deaths;
	private String countriesAndTerritories;
	private String continentExp;
	private double cases_per_100000;
	
	public Caso(Date dateRep, long cases, int deaths, String countriesAndTerritories, String continentExp,
			double cases_per_100000) {
		super();
		this.dateRep = dateRep;
		this.cases = cases;
		this.deaths = deaths;
		this.countriesAndTerritories = countriesAndTerritories;
		this.continentExp = continentExp;
		this.cases_per_100000 = cases_per_100000;
	}

	public Date getDateRep() {
		return dateRep;
	}

	public void setDateRep(Date dateRep) {
		this.dateRep = dateRep;
	}

	public long getCases() {
		return cases;
	}

	public void setCases(long cases) {
		this.cases = cases;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public String getCountriesAndTerritories() {
		return countriesAndTerritories;
	}

	public void setCountriesAndTerritories(String countriesAndTerritories) {
		this.countriesAndTerritories = countriesAndTerritories;
	}

	public String getContinentExp() {
		return continentExp;
	}

	public void setContinentExp(String continentExp) {
		this.continentExp = continentExp;
	}

	public double getCases_per_100000() {
		return cases_per_100000;
	}

	public void setCases_per_100000(double cases_per_100000) {
		this.cases_per_100000 = cases_per_100000;
	}
	
	
	
	
	
	
	

}
