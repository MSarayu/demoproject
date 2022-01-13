package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.PeriodicElement;
import com.example.service.IElementSearchService;
import com.example.vo.ResponseObject;

@Controller
public class SearchController {

	@Autowired
	private IElementSearchService searchService;
	/*
	 * @RequestMapping(value = "/loadAllElements.do", method =
	 * RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE}) public
	 * ResponseEntity<List<PeriodicElement>> loadAllElements() {
	 * 
	 * ResponseObject response=new ResponseObject(); try {
	 * response.setData(searchService.getAllElements()); response.setStatus(true); }
	 * catch (Exception e) { response.setStatus(false);
	 * response.setData(e.getMessage()); } return response;
	 * 
	 * 
	 * List<PeriodicElement> elements=searchService.getAllElements(); if
	 * (elements.isEmpty()) { return new
	 * ResponseEntity<List<PeriodicElement>>(HttpStatus.NO_CONTENT); } return new
	 * ResponseEntity<List<PeriodicElement>>(elements, HttpStatus.OK); }
	 */
	
	@RequestMapping(value = "/loadAllElements.do", method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<PeriodicElement> loadAllElements() {
		/*
		 * ResponseObject response=new ResponseObject(); try {
		 * response.setData(searchService.getAllElements()); response.setStatus(true); }
		 * catch (Exception e) { response.setStatus(false);
		 * response.setData(e.getMessage()); } return response;
		 */
		
		return searchService.getAllElements();
		
	}

	@RequestMapping(value = "/element/{atomicNumber}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PeriodicElement> getProductByid(@PathVariable int atomicNumber) {
		PeriodicElement element = searchService.findElementByAtomicNumber(atomicNumber);
		if (element == null) {
			return new ResponseEntity<PeriodicElement>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PeriodicElement>(element, HttpStatus.OK);
	}

}
