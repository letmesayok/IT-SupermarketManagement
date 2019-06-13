package cn.ssx.DAO;

import java.sql.SQLException;

import java.util.List;//要导入这个包

import cn.ssx.Class.Product;
import cn.ssx.Test.count;

public interface Product_interface {
	
        public void Proudct_Insert(Product Product) throws SQLException, Exception;
        
        public void Product_Delete(String Product_name) throws SQLException, Exception; 
        
        public void Product_Update(Product Product) throws SQLException, Exception;
        
        //public List<Person> findAll() throws SQLException;
        public List<Product> Product_Findall() throws SQLException, Exception;

		public List<Product> Product_FindWarning() throws SQLException, Exception;
		
		public Product Product_FindSingle(String Product_name) throws SQLException, Exception;
		
		public List<Product> Product_FindJinhuo() throws SQLException, Exception;
		
        
}
