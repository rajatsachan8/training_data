package com.mindtree.multifield.core;

import java.time.Year;

import com.adobe.cq.sightly.WCMUsePojo;

public class Footer extends WCMUsePojo {

	String year;
	
	public String getYear() {
		return year;
	}

	@Override
	public void activate() throws Exception {
		year=Year.now()+"";
	}

}
