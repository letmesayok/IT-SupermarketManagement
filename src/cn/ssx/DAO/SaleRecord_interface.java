package cn.ssx.DAO;

import java.sql.SQLException;
import java.util.List;

import cn.ssx.Class.Product;
import cn.ssx.Class.SaleRecord;

public interface SaleRecord_interface {
                 public void SaleRecord_Insert(SaleRecord SaleRecord) throws SQLException, Exception;
                 public List <SaleRecord> SaleRecord_Findall() throws SQLException, Exception;
                 public void SaleRecord_Delete(String Sale_date) throws SQLException, Exception;
                 public void SaleRecord_Update(SaleRecord SaleRecord) throws SQLException, Exception;
                 public void insert(Product product) throws SQLException, Exception;
                 public List<Product> Youhui_Findall() throws SQLException, Exception;
}
