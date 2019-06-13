package cn.ssx.Test;

import java.sql.SQLException;
import java.util.List;

import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;
import cn.ssx.Impl.Product_DAO_Impl;

public class test {

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Product_interface pi = new Product_DAO_Impl();
		List<Product> list = pi.Product_FindWarning();
		if(list!=null)
		for(Product p :list) {
			if(p!=null)
			System.out.println(p.getProduct_name());
		}
		else System.out.println('1');
		/*Administrator_interface dao = new Administrator_DAO_Impl();
		List <Administrator> list  = dao.Administrator_FindAll();
		System.out.println(list.size());
		for(Administrator a: list) {
			System.out.println(a.getAdministrator_name());
		}*/
	}
}
