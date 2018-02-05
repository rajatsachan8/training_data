package com.mindtree.multifield.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

public class NavigationForVisitingPlaces extends WCMUsePojo {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NavigationForVisitingPlaces.class);
	String path;
	List<VisitingPlacesModel> list=new ArrayList<VisitingPlacesModel>();


	public List<VisitingPlacesModel> getList() {
		return list;
	}



	public void setList(List<VisitingPlacesModel> list) {
		this.list = list;
	}



	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}

	

	@Override
	public void activate() throws Exception {

		
		path=getProperties().get("linkURL","");
		LOGGER.info("outside"+path);
		
		if(path.equals(""))
		{
			path=getCurrentPage().getPath();
			LOGGER.info("inside null"+path);
		}
      
         Page rootPage = getRequest().getResourceResolver().getResource(path).adaptTo(Page.class);
         Iterator<Page> rootPageIterator = rootPage.listChildren();
         
         
         while(rootPageIterator.hasNext())
         { 
        	 Map<String,String> mapParent=new TreeMap<String,String>();

        	 Map<String,String> mapChild=new TreeMap<String,String>();

        	      VisitingPlacesModel v=new VisitingPlacesModel();
                  Page parent = rootPageIterator.next();
                  String parentName=parent.getTitle();
                  String parentUrl=parent.getPath();
                  mapParent.put(parentName, parentUrl);
                  

                  Iterator<Page> grandRootPageIterator = parent.listChildren();
                  while(grandRootPageIterator.hasNext())
                      {
                	  
                	 		Page child =    grandRootPageIterator.next();
                	 		String cname = child.getTitle();
                	 		String Url=child.getPath();
                	 		mapChild.put(cname, Url);
                	 		
                      }
             	
                  v.setChildName(mapChild);
                  v.setParentName(mapParent);
                  
                  list.add(v);
                
         }
         
       
	}
}
