package cn.ssx.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.AbstractQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sun.jndi.toolkit.corba.CorbaUtils;

import cn.itcast1.servlet.JdbcUtil;
import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;
import cn.ssx.DAO.Administrator_interface;

public class Administrator_DAO_Impl implements Administrator_interface{

	private static final JdbcUtil DBUtils = null;
	QueryRunner runner = new QueryRunner();
	
	public Administrator Findname(String Administrator_name) throws Exception {
		String sql = "select * from guanliyuanxinxi where Administrator_name = ?";
		Administrator a = runner.query(JdbcUtil.getConnection(), sql, new BeanHandler<Administrator>(Administrator.class),Administrator_name);
		return a;
	}
	@Override
	public void Administrator_Insert(Administrator Admin) throws Exception {
		String sql = "insert into guanliyuanxinxi(Administrator_name,Administrator_password)values(?,?)";
		runner.update(JdbcUtil.getConnection(), sql, Admin.getAdministrator_name(),Admin.getAdministrator_password());
	}
	@Override
	public List<Administrator> Administrator_FindAll() throws SQLException, Exception {
		String sql  = "select * from guanliyuanxinxi";
		List<Administrator> Admi = runner.query(JdbcUtil.getConnection(), sql, new BeanListHandler<Administrator>(Administrator.class));
		return Admi;
	}
}
