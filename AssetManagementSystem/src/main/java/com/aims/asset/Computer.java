package com.aims.asset;
import java.util.*;

public class Computer {
	
	private  int id;
	private  String computerModel;
	private  String computerNumber;
	private  String computerYear;
	
	
	public Computer(String computerModel, String computerNumber, String computerYear) {
		super();
		this.computerModel = computerModel;
		this.computerNumber = computerNumber;
		this.computerYear = computerYear;
	}


	public Computer(int id, String computerModel, String computerNumber, String computerYear) {
		super();
		this.id = id;
		this.computerModel = computerModel;
		this.computerNumber = computerNumber;
		this.computerYear = computerYear;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComputerModel() {
		return computerModel;
	}


	public void setComputerModel(String computerModel) {
		this.computerModel = computerModel;
	}


	public String getComputerNumber() {
		return computerNumber;
	}


	public void setComputerNumber(String computerNumber) {
		this.computerNumber = computerNumber;
	}


	public String getComputerYear() {
		return computerYear;
	}


	public void setComputerYear(String computerYear) {
		this.computerYear = computerYear;
	}


	@Override
	public String toString() {
		return "Computer [id=" + id + ", computerModel=" + computerModel + ", computerNumber=" + computerNumber
				+ ", computerYear=" + computerYear + "]";
	}
	
	
}
