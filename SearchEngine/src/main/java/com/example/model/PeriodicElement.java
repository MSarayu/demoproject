package com.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class PeriodicElement {

	
	Map<String, String> details;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("atomic_number")
	private int atomicNumber;
	
	@JsonProperty("group_block")
	private String groupBlock;
	
	private int group;
	
	@JsonProperty("period")
	private int period;
	
	@JsonProperty("alternative_name")
	private String alternativeName;

	@JsonProperty("alternative_names")
	private String alternativeNames;
	
	@JsonProperty("appearance")
	private String appearance;
	
	@JsonProperty("symbol")
	private String symbol;
	
	@JsonProperty("discovery")
	private String discoverer;
	
	@JsonProperty("first_isolation")
	private String firstIsolator;
	
	private List<String> discoverers;
	
	private String discoveryYear;
	
	@JsonProperty("discovery_and_first_isolation")
	private String discovererAndIsolator;
	
	public PeriodicElement() {
		super();
		details=new HashMap<String, String>();
		discoverers=new ArrayList<String>();
	}
	
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

	public void setGroupBlock(String groupBlock) {
		if(!groupBlock.equalsIgnoreCase("n/a")){
		this.groupBlock = groupBlock;
		groupBlock=groupBlock.replaceAll("\\D+","");
		try {
			setGroup(Integer.parseInt(groupBlock));
		} catch (NumberFormatException e) {
			setGroup(0);
		}
		}else {
			setGroup(0);
		}
	}

	public void setGroup(int group) {
	this.group = group;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}

	public int getGroup() {
		return group;
	}
	public String getGroupBlock() {
		return groupBlock;
	}

	public int getPeriod() {
		return period;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public void setAlternativeNames(String alternativeNames) {
		StringBuilder sb=new StringBuilder("");
		if(!alternativeName.equalsIgnoreCase("n/a")) {
			sb.append(alternativeName);
			sb.append(",");
		}
		if(!alternativeNames.equalsIgnoreCase("n/a")) {
			sb.append(alternativeNames);
		}
		if(sb.length()==0) {
			sb.append("none");
		}
		this.alternativeNames = sb.toString();
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setDiscoverer(String discoverer) {
		if(!discoverer.equalsIgnoreCase("n/a")){
		String tempDiscoverer=discoverer;
		tempDiscoverer=tempDiscoverer.replaceAll("\\D+", "");
		this.setDiscoveryYear(tempDiscoverer);
		
		tempDiscoverer=discoverer;
		tempDiscoverer=tempDiscoverer.replaceAll("\\d+", "");
		addDiscoveres(tempDiscoverer);
		}
	}

	public void addDiscoveres(String discoverer) {
		this.discoverers.add(discoverer);
	}
	public void setFirstIsolator(String firstIsolator) {

		if(!firstIsolator.equalsIgnoreCase("n/a")){
		String tempDiscoverer=firstIsolator;
		tempDiscoverer=tempDiscoverer.replaceAll("\\d+", "");
		addDiscoveres(tempDiscoverer);
		}
	
		this.firstIsolator = firstIsolator;
	}

	
	public void setDiscovererAndIsolator(String discovererAndIsolator) {

		if(!discovererAndIsolator.equalsIgnoreCase("n/a")){
		String tempDiscoverer=discovererAndIsolator;
		tempDiscoverer=tempDiscoverer.replaceAll("\\D+", "");
		this.setDiscoveryYear(tempDiscoverer);
		
		tempDiscoverer=discovererAndIsolator;
		tempDiscoverer=tempDiscoverer.replaceAll("\\d+", "");
		addDiscoveres(tempDiscoverer);
		}
		this.discovererAndIsolator = discovererAndIsolator;
	}

	public void setDiscoveryYear(String discoveryYear) {
		this.discoveryYear = discoveryYear;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public String getAlternativeNames() {
		return alternativeNames;
	}

	public String getAppearance() {
		return appearance;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getDiscoverer() {
		return discoverer;
	}

	public String getFirstIsolator() {
		return firstIsolator;
	}

	public List<String> getDiscoverers() {
		return discoverers;
	}

	public String getDiscoveryYear() {
			return discoveryYear!=null?discoveryYear:"unknown";
	}

	public String getDiscovererAndIsolator() {
		return discovererAndIsolator;
	}
	
	
	
}
