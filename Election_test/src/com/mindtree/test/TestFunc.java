package com.mindtree.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.*;

import com.mindtree.Candidates;
import com.mindtree.DAO;

public class TestFunc {
	
	@Test
	public void myTest(){
	     DAO dao=new DAO();
	     List<Candidates> candidates=dao.contestants();
	     assertNotNull(candidates.size());
	}
	
	@Test
	public void testCandidate() throws IOException{
		DAO dao=new DAO();
		String name=dao.insertNewData();
		List<Candidates> allnames=dao.allcandidates();
		assertEquals(name,allnames.get(allnames.size()-1).getName());
	}
	
	
}

