package com.example.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class PeriodicElement {

	
	public PeriodicElement() {
		super();
		// TODO Auto-generated constructor stub
	}
	Map<String, String> details=new HashMap<String, String>();
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("atomic_number")
	private int atomicNumber;
	
	@JsonAnyGetter
	public Map<String, String> getDetails() {
		return details;
	}
	
	@JsonAnySetter
	public void add(String key,String value) {
		details.put(key, value);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAtomicNumber() {
		return atomicNumber;
	}
	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}
	
	
	
}
