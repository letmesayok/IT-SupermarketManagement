package cn.ssx.Impl;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;

public class Test1 {

	@Test
	public void test1() throws SQLException, Exception
	{
		Administrator_DAO_Impl dao= new Administrator_DAO_Impl();
		List <Administrator> list =dao.Administrator_FindAll();
		for(Administrator ad: list) {
			System.out.println(ad.getAdministrator_name());
		}
	}
	
	
	
	
}
