package Test;

import cn.ssx.Class.Administrator;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;

public class test01 {
	public static void main(String[] args) throws Exception {
		 // TODO Auto-generated method stub
         Administrator_interface dao = new Administrator_DAO_Impl ();
         String Administrator_name = "shishunx";
         Administrator admi=null;
         System.out.println(Administrator_name);
         admi=dao.Findname(Administrator_name);
         if(admi==null) System.out.println("该用户啊不存在");
         else System.out.println(admi.getAdministrator_password());
	}

}
