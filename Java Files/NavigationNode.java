package com.mindtree.multifield.core;

import java.util.List;
import java.util.Map;

import com.day.cq.wcm.api.Page;

public class NavigationNode {

	private String basepagename;
	private String basepageURL;
	private List<String> childpagename;
	private List<String> childpageURL;
	private List<String> grandchildpagename;
	private List<String> grandchildpagelURL;
	private Map<String,String> mapperlist;
	public String getBasepagename() {
		return basepagename;
	}
	public void setBasepagename(String basepagename) {
		this.basepagename = basepagename;
	}
	public String getBasepageURL() {
		return basepageURL;
	}
	public void setBasepageURL(String basepageURL) {
		this.basepageURL = basepageURL;
	}
	
	public List<String> getGrandchildpagename() {
		return grandchildpagename;
	}
	public void setGrandchildpagename(List<String> grandchildpagename) {
		this.grandchildpagename = grandchildpagename;
	}
	public List<String> getGrandchildpagelURL() {
		return grandchildpagelURL;
	}
	public void setGrandchildpagelURL(List<String> grandchildpagelURL) {
		this.grandchildpagelURL = grandchildpagelURL;
	}
	public List<String> getChildpagename() {
		return childpagename;
	}
	public void setChildpagename(List<String> childpagename) {
		this.childpagename = childpagename;
	}
	public List<String> getChildpageURL() {
		return childpageURL;
	}
	public void setChildpageURL(List<String> childpageURL) {
		this.childpageURL = childpageURL;
	}
	public Map<String,String> getMapperlist() {
		return mapperlist;
	}
	public void setMapperlist(Map<String,String> mapperlist) {
		this.mapperlist = mapperlist;
	}
	

	
	
	
}
