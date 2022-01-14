package com.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.dto.ElementFilter;
import com.example.model.PeriodicElement;

@Service
public class ElementSearchServiceImpl implements IElementSearchService {
	
	  enum Filter{
		GROUP(1),
		PERIOD(2),
		BOTH(3);

		public final int filterId;
		private Filter(int id) {
			this.filterId=id;
		}
		 private static final Map<Integer,Filter> ENUM_MAP;

		   
	  public int getFilterId() {
			return filterId;
		}

	  
	  //create map to get the filter name by passing the selected filter id
	static {
	        Map<Integer,Filter> map = new ConcurrentHashMap<Integer,Filter>();
	        for (Filter filterName : Filter.values()) {
	            map.put(filterName.getFilterId(),filterName);
	        }
	        ENUM_MAP = Collections.unmodifiableMap(map);
	    }

	    public static Filter get (int id) {
	        return ENUM_MAP.get(id);
	    }
		
	}
	private static List<PeriodicElement> elementsList;
	
	//load all the elements once for an instance
	static{
		elementsList=PeriodicTable.getInstance().getElementsList();
	}
	
	public List<PeriodicElement> getAllElements() {
		
		return elementsList;
	}

	
	public PeriodicElement findElementByAtomicNumber(int atomicNumber) {
	List<PeriodicElement> list=elementsList.stream().filter(p->p.getAtomicNumber()==atomicNumber).map(e->e).collect(Collectors.toList());
		return (list!=null && !list.isEmpty())?list.get(0):null;
	}

	@Override
	public List<PeriodicElement> findElementBasedOnFilter(ElementFilter  filter) {
		Filter filtername=Filter.get(filter.getFilterId());//get the filter name by passing the id
		
		// add all the filters to the list
		List<Predicate<PeriodicElement>> allPredicates = new ArrayList<Predicate<PeriodicElement>>();
	    switch(filtername) {
		//apply group filter
		case GROUP:
			 allPredicates.add(p->p.getGroup()==filter.getGroupId());
			   	
			break;
			//apply period filter
		case PERIOD:
			 allPredicates.add(p->p.getPeriod()==filter.getPeriod());
				
			break;
			//apply all filters
		default:
			 allPredicates.add(p->p.getGroup()==filter.getPeriod());
			 allPredicates.add(p->p.getPeriod()==filter.getPeriod());
					
			break;
		}
		
		
		List<PeriodicElement> list=elementsList.stream()
		  .filter(allPredicates.stream().reduce(x->true, Predicate::and))
	      .collect(Collectors.toList());
		return list;
	}

}
