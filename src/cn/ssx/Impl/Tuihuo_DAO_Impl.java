package cn.ssx.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast1.servlet.JdbcUtil;
import cn.ssx.Class.SaleRecord;
import cn.ssx.Class.TuihuoRecord;
import cn.ssx.DAO.TuihuoRecord_interface;


public class Tuihuo_DAO_Impl implements TuihuoRecord_interface{
	private static final JdbcUtil DBUtils = null;
	QueryRunner runner = new QueryRunner();
	@Override
	public List<TuihuoRecord> Tuihuo_Findall() throws SQLException, Exception {
		String sql = "select * from tuihuo";
        List<TuihuoRecord> list = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<TuihuoRecord>(TuihuoRecord.class));
        return list;
	}

	@Override
	public void Tuihuo_Delete(String Customer_Tel) throws SQLException, Exception {
		String sql = "delete from tuihuo where Customer_Tel = ?";
		runner.update(JdbcUtil.getConnection(), sql,Customer_Tel);	
		
	}

	@Override
	public void Tuihuo_Insert(TuihuoRecord tuihuoRecord) throws SQLException, Exception {
		String sql = "insert into tuihuo(Customer_Tel,Product_name,Product_price,Product_number)values(?,?,?,?)";
		runner.update(JdbcUtil.getConnection(), sql, tuihuoRecord.getCustomer_Tel(),tuihuoRecord.getProduct_name(),tuihuoRecord.getProduct_price(),tuihuoRecord.getProduct_number());
		
	}

	@Override
	public void Tuihuo_Update(TuihuoRecord tuihuoRdcord) throws SQLException, Exception {
		// TODO Auto-generated method stub
		String sql = "update tuihuo set Product_number=?,Product_name=?,Product_price=? where Customer_Tel=?";
		runner.update(JdbcUtil.getConnection(), sql,tuihuoRdcord.getProduct_number(),tuihuoRdcord.getProduct_name(),tuihuoRdcord.getProduct_price(),tuihuoRdcord.getCustomer_Tel());
	}
	

	/*
	 * private String Customer_Tel; private String Product_name; private String
	 * Product_price; private String Product_number;
	 */
}
