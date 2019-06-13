package cn.ssx.DAO;

import java.sql.SQLException;
import java.util.List;

import cn.ssx.Class.Administrator;

public interface Administrator_interface {
	
     public Administrator Findname(String Adminstrator_name) throws Exception;
     
     public void Administrator_Insert(Administrator Admin) throws Exception;
     
     public List<Administrator> Administrator_FindAll() throws SQLException, Exception;
}
