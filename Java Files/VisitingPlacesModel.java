package com.mindtree.multifield.core;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VisitingPlacesModel {
	

	Map<String,String> childName=new TreeMap<String,String>();
	Map<String,String> parentName=new HashMap<String,String>();

	public Map<String, String> getParentName() {
		return parentName;
	}

	public void setParentName(Map<String, String> parentName) {
		this.parentName = parentName;
	}

	public Map<String, String> getChildName() {
		return childName;
	}

	public void setChildName(Map<String, String> childName) {
		this.childName = childName;
	}

	
}
