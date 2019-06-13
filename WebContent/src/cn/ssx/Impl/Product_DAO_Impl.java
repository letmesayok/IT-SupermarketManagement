package cn.ssx.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;这个包和util。list的包相互矛盾

import cn.itcast1.servlet.JdbcUtil;
import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Test.count;

import java.util.List;//要导入这个包
public class Product_DAO_Impl implements Product_interface{
	QueryRunner runner = new QueryRunner();
	@Override
	public void Proudct_Insert(Product Product) throws Exception{
		String sql ="insert into shangpinjinhuo(Administrator_store,Product_name,Product_price,Product_storedate,Product_prenumber,Storenumber,Product_honumber)values(?,?,?,?,?,?,?)";
		runner.update(JdbcUtil.getConnection(), sql, Product.getAdministrator_store(),Product.getProduct_name(),Product.getProduct_price(),Product.getProduct_storedate(),Product.getProduct_prenumber(),Product.getStorenumber(),Product.getProduct_honumber());
		//System.out.println(" -------------" +Product.getProduct_number());
		String sql1 ="insert into shangpinkucun(Product_name,Product_price,Product_number,Product_storedate)values(?,?,?,?)";
		//Product_name Product_price Product_number  Product_storedate
		runner.update(JdbcUtil.getConnection(), sql1, Product.getProduct_name(),Product.getProduct_price(),Product.getProduct_number(),Product.getProduct_storedate());
	}
	@Override
	public void Product_Delete(String Product_name) throws SQLException, Exception {
		String sql = "delete from shangpinkucun where Product_name = ?";
		runner.update(JdbcUtil.getConnection(), sql,Product_name);
	}
	@Override
	public void Product_Update(Product Product) throws SQLException, Exception {
		String sql = "update shangpinkucun set Product_name=?,Product_price=?,Product_number=? where Product_storedate=?";
		runner.update(JdbcUtil.getConnection(), sql, Product.getProduct_name(),Product.getProduct_price(),Product.getProduct_number(),Product.getProduct_storedate());
		 /*String sql = "update person set name=?,age=?,description=? where id=?";
		  runner.update(DBUtils.getConnection(), sql, p.getName(),p.getAge(),p.getDescription(),p.getId());
		  System.out.println("11111111111111"+Product.getProduct_storedate()+' '+Product.getProduct_price()+' '+Product.getProduct_number()+' '+Product.getProduct_name());
		*/
	}
	@Override
	public List<Product> Product_Findall() throws SQLException, Exception {
		 String sql = "select * from shangpinkucun";
         List<Product> list = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Product>(Product.class));
         return list;
	}
	@Override
	public List<Product> Product_FindWarning() throws SQLException, Exception {
		 String sql = "select * from shangpinkucun where Product_number<=4 ";
         List<Product> list = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Product>(Product.class));
		 //TODO Auto-generated method stub
         return list;
	}
	@Override
	public Product Product_FindSingle(String Product_name) throws SQLException, Exception {
		String sql = "select * from shangpinkucun where  Product_name = ?";
		Product a = runner.query(JdbcUtil.getConnection(), sql, new BeanHandler<Product>(Product.class),Product_name);
		return a;
	}
	@Override
	public List<Product> Product_FindJinhuo() throws SQLException, Exception {
		 String sql = "select * from shangpinjinhuo";
         List<Product> list = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Product>(Product.class));
         return list;
	}

}
