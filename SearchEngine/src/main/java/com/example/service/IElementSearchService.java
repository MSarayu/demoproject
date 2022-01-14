package com.example.service;

import java.util.List;

import com.example.dto.ElementFilter;
import com.example.model.PeriodicElement;

public interface IElementSearchService {

	public List<PeriodicElement> getAllElements();
	public List<PeriodicElement> findElementBasedOnFilter(ElementFilter filter);
	public PeriodicElement findElementByAtomicNumber(int atomicNumber);
}
