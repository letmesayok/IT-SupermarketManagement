package cn.ssx.DAO;

import java.sql.SQLException;
import java.util.List;

import cn.ssx.Class.TuihuoRecord;

public interface TuihuoRecord_interface {
	public List<TuihuoRecord> Tuihuo_Findall() throws SQLException, Exception;
    public void Tuihuo_Delete(String Tel) throws SQLException, Exception;
    public void Tuihuo_Insert(TuihuoRecord tuihuoRecord) throws SQLException, Exception;
    public void Tuihuo_Update(TuihuoRecord tuihuoRdcord) throws SQLException, Exception;
}
