package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.PeriodicElement;

@Service
public class ElementSearchServiceImpl implements IElementSearchService {
	
	private static List<PeriodicElement> elementsList;
	static{
		elementsList=PeriodicTable.getInstance().getElementsList();
	}
	
	public List<PeriodicElement> getAllElements() {
		
		return elementsList;
	}

	public List<PeriodicElement> findElementBasedOnFilter() {
		
		return elementsList;
	}

	public PeriodicElement findElementByAtomicNumber(int atomicNumber) {
	
		return elementsList.get(atomicNumber);
	}

}
