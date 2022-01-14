package com.example.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.example.dto.ElementFilter;
import com.example.model.PeriodicElement;
import com.example.service.IElementSearchService;
import com.example.test.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class,loader = AnnotationConfigContextLoader.class)

public class SearchControllerTest {

	@Autowired
	IElementSearchService searchService;
	
	List<PeriodicElement> elements;
	
	@Test
	public void checkIfAllElementsLoaded() {
		elements=searchService.getAllElements();
		Assert.assertEquals(117,elements.size());
	}
	
	/**
	 * check if the returned list has element with groupId:1 and period:1
	 */
	@Test
	public void checkExistingGroupAndPeriod() {
		ElementFilter filter=new ElementFilter();
		filter.setFilterId(3);// group and period filter
		filter.setGroupId(1);
		filter.setPeriod(1);
		elements=searchService.findElementBasedOnFilter(filter);
		Assert.assertTrue(elements.size()==1);
	}
	
	/**
	 * check if the returned list has no element with groupId:1 and period:8
	 */
	@Test
	public void checkNonExistingGroupAndPeriod() {
		ElementFilter filter=new ElementFilter();
		filter.setFilterId(3);// group and period filter
		filter.setGroupId(1);
		filter.setPeriod(8);
		elements=searchService.findElementBasedOnFilter(filter);
		Assert.assertFalse(elements.size()>0);
	}
	
	/**
	 * check if the returned object is not null for atomic number:1
	 */
	@Test
	public void checkExistingElementByAtomicNumber() {
		PeriodicElement element=searchService.findElementByAtomicNumber(1);
		Assert.assertNotNull(element);
	}
	
	/**
	 * check if the returned object is not null for atomic number:20
	 */
	@Test
	public void checkNonExistingElementByAtomicNumber() {
		PeriodicElement element=searchService.findElementByAtomicNumber(200);
		Assert.assertNull(element);
	}
	
	
}
