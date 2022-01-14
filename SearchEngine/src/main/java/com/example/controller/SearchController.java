package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.ElementFilter;
import com.example.model.PeriodicElement;
import com.example.service.IElementSearchService;

@Controller
public class SearchController {

	@Autowired
	private IElementSearchService searchService;

	@RequestMapping(value = "/loadAllElements.do", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<PeriodicElement> loadAllElements() {
		return searchService.getAllElements();
		
	}

	@RequestMapping(value = "/findElement/{atomicNumber}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public PeriodicElement getElementById(@PathVariable int atomicNumber) {
		
		return searchService.findElementByAtomicNumber(atomicNumber);
	}
	
	@RequestMapping(value = "/findElementBasedOnFilter", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<PeriodicElement> getElementByFilter(@RequestBody ElementFilter filter) {
		
		return searchService.findElementBasedOnFilter(filter);
	}
	
}
