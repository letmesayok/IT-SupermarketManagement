package cn.ssx.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast1.servlet.JdbcUtil;
import cn.ssx.Class.Product;
import cn.ssx.Class.SaleRecord;
import cn.ssx.DAO.Product_interface;
import cn.ssx.DAO.SaleRecord_interface;

public class SaleRecord_DAO_Impl implements SaleRecord_interface{
	private static final JdbcUtil DBUtils = null;
	QueryRunner runner = new QueryRunner();
	@Override
	public void SaleRecord_Insert(SaleRecord SaleRecord) throws SQLException, Exception {
		String sql = "insert into xiaoshoujilu(Sale_Productnumber,Sale_Administrator,Sale_date,Sale_Productprice,Sale_Productname,Sale_Profit)values(?,?,?,?,?,?)";
		runner.update(JdbcUtil.getConnection(), sql, SaleRecord.getSale_Productnumber(),SaleRecord.getSale_Administrator(),
				SaleRecord.getSale_date(),SaleRecord.getSale_Productprice(),SaleRecord.getSale_Productname(),SaleRecord.getSale_Profit());
		        
	}
	@Override
	public List<SaleRecord> SaleRecord_Findall() throws SQLException, Exception {
		 String sql = "select * from xiaoshoujilu";
         List<SaleRecord> list = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<SaleRecord>(SaleRecord.class));
         return list;
	}
	@Override
	public void SaleRecord_Delete(String Sale_date) throws SQLException, Exception {
		String sql = "delete from xiaoshoujilu where Sale_date = ?";
		runner.update(JdbcUtil.getConnection(), sql,Sale_date);	
		
	}
	@Override
	public void SaleRecord_Update(SaleRecord SaleRecord) throws SQLException, Exception {
		String sql = "update xiaoshoujilu set Sale_Productname=?,Sale_Productprice=?,Sale_Administrator=?,Sale_Profit=?,Sale_Productnumber=?where Sale_date=?";
		runner.update(JdbcUtil.getConnection(), sql, SaleRecord.getSale_Productname(), SaleRecord.getSale_Productprice(), SaleRecord.getSale_Administrator(), SaleRecord.getSale_Profit(),
				 SaleRecord.getSale_Productnumber(), SaleRecord.getSale_date());
		
	}
	@Override
	public void insert(Product product) throws SQLException, Exception {
		String sql = "insert into youhui(Product_name,Product_price,product_number,Product_storedate)values(?,?,?,?)";
		runner.update(JdbcUtil.getConnection(), sql,product.getProduct_name(),product.getProduct_price(),product.getProduct_number(),product.getProduct_storedate());
		
	}
	@Override
	public List<Product> Youhui_Findall() throws SQLException, Exception {
		 String sql = "select * from youhui";
         List<Product> list = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Product>(Product.class));
         return list;
	}
	
}
