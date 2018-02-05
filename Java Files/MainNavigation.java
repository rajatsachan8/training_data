package com.mindtree.multifield.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ValueMap;


import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.commons.LanguageUtil;
import com.day.cq.wcm.api.Page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainNavigation extends WCMUsePojo{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainNavigation.class);

	private List<NavigationNode> navigationPages;		
	
		private String homePagePath;
		public String getHomePagePath() {
			return homePagePath;
		}

		private String externalLink;
        private int count;

	@Override
	public void activate() {
		navigationPages = new ArrayList<NavigationNode>();
	
		
	        homePagePath = LanguageUtil.getLanguageRoot(getCurrentPage().getPath());
		      
		Page homePage = getRequest().getResourceResolver().getResource(homePagePath).adaptTo(Page.class);
		
		//Page currentPage = getCurrentPage();
        if (homePage != null) {
        	
     externalLink="inside loop";
        	count=0;
            Iterator<Page> pageIterator = homePage.listChildren();
            while (pageIterator.hasNext()) {
          
            	NavigationNode navNode = new NavigationNode();
            	
                Page page = pageIterator.next();
                if (!page.isHideInNav()) {
                	
                    	navNode = new NavigationNode();
                    	 externalLink = getExternalLinkpath(page);  
                    	 if(!page.getTitle().equals("Packages") ){
                        	 navNode.setBasepageURL(externalLink);
                    	 }
                    	navNode.setBasepagename(page.getTitle());
                   
                  	LOGGER.info("pageURL :"+page.getName()+" : "+page.getPath());
                    LOGGER.info(page.getTitle());
                     
                    Map<String,String> mapper=new HashMap <String,String>();
                    Iterator<Page> childPagesIterator = page.listChildren();
                    List<String> childpagename=new ArrayList<String>();
                	//List<String> URLchildpage=new ArrayList<String>();
                    while (childPagesIterator.hasNext()) {
                    	
                        Page childPage = childPagesIterator.next();
                        if (childPage.isValid() && !childPage.isHideInNav()) {
                            
                            String externalLink1 = getExternalLinkpath(childPage);
                            mapper.put(externalLink1,childPage.getTitle());
                            
                           childpagename.add(externalLink1);
                           childpagename.add(childPage.getTitle());
                           
                        	LOGGER.info("pageURL1 :"+childPage.getName()+" : "+childPage.getPath());
                      
                        	
                            Iterator<Page> grandChildPagesIterator = childPage.listChildren();
                            List<String> grandchildpagename=new ArrayList<String>();
                        	List<String> URLgrandchildpage=new ArrayList<String>();
                            while (grandChildPagesIterator.hasNext()) {
                            	
                            	
                                Page grandChildPage = grandChildPagesIterator.next();
                                if (grandChildPage.isValid() && !grandChildPage.isHideInNav()) {
                                   
                                    String externalLink2 = getExternalLinkpath(grandChildPage);
                                    URLgrandchildpage.add(externalLink2);
                                    grandchildpagename.add(grandChildPage.getTitle());
                                    
                                	LOGGER.info("pageURL2 :"+grandChildPage.getName()+" : "+grandChildPage.getPath());
                                	
                                }
                               
                                navNode.setGrandchildpagelURL(URLgrandchildpage);
                                navNode.setGrandchildpagename(grandchildpagename);
                                
                            }  
                            navNode.setChildpagename(childpagename);
                            navNode.setMapperlist(mapper);
                           // navNode.setChildpageURL(URLchildpage);

                          
                        }
                    }
                     navigationPages.add(navNode);
                    count++;
                    LOGGER.info("count="+count);

                }
            }
        } else {
            
        }
		
	}







	public List<NavigationNode> getNavigationPages() {
		return navigationPages;
	}
  public int getCount(){
	  return count;
  }

	 public static String getExternalLinkpath(final Page page) {
	        if (page == null) {
	            return "";
	        }

	        ValueMap map = page.getProperties();
	        if (StringUtils.isNotEmpty(map.get("externalLink", String.class))) {
	            return map.get("externalLink", String.class);
	        }else if(StringUtils.isNotEmpty(map.get("redirectTarget", String.class))) {
	            return map.get("redirectTarget", String.class) + ".html";        	
	        }
	        else{
	        	return page.getPath() + ".html";
	        }
	        
	    }
	

}

