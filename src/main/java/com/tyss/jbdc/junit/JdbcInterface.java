package com.tyss.jbdc.junit;

import java.util.ArrayList;

	public interface JdbcInterface {



	public void insert(int sid,String sname);

	public ArrayList<Object> select();

	public void update(int sid,String sname);

	public void delete(int sid);



	}

