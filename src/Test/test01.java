package Test;
import cn.ssx.Class.Administrator;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;

public class test01 {
	public static void main(String[] args) throws Exception {
		 // TODO Auto-generated method stub
         Administrator_interface dao = new Administrator_DAO_Impl ();//Create a Dao
         String Administrator_name = "shishunx";//Define administrator's name
         Administrator admi=null;//Set null
         System.out.println(Administrator_name);//printoff
         admi=dao.Findname(Administrator_name);//printoff
         else System.out.println(admi.getAdministrator_password());
	}

}
