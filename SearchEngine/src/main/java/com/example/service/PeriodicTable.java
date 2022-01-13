package com.example.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.example.model.PeriodicElement;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class PeriodicTable {

	
	private static PeriodicTable periodicTable=null;
	private List<PeriodicElement> elementsList=null;
	
	public List<PeriodicElement> getElementsList() {
		return elementsList;
	}

	private  List<PeriodicElement> loadPeriodicTableElements() {
		ObjectMapper mapper=new ObjectMapper();
		try {
		File file=new ClassPathResource("periodic_table.json").getFile();
		
			 CollectionType javaType = mapper.getTypeFactory()
				      .constructCollectionType(List.class, PeriodicElement.class);
			elementsList = mapper.readValue(file, javaType);
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return elementsList;
	}
	
	public static PeriodicTable getInstance() {
		if(periodicTable==null) {
			periodicTable=new PeriodicTable();
			periodicTable.loadPeriodicTableElements();
		}
		
		return periodicTable;
	}
}
