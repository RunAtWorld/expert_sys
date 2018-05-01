package expert_sys.dao;
import java.sql.SQLException;

import expert_sys.db.DBHelper;


public class emp {
	
	public static void main(String[] args) throws SQLException {
	    //驱动程序名
	    String driver = "com.mysql.jdbc.Driver";
	    //URL指向要访问的数据库名mydata
	    String url = "jdbc:mysql://localhost:3306/expert_sys";
	    //MySQL配置时的用户名
	    String user = "root";
	    //MySQL配置时的密码
	    String password = "lipengfei2015";
	    
	    DBHelper dbhelper=null;
		dbhelper = new DBHelper(driver, url, user, password);
		
//        dbhelper.insert();
//		dbhelper.excuteBatch();
		String sqlS="SELECT r_category_medicine.id,t_medicine_info.tradename,t_medicine_info.adverse_reaction,t_medicine_info.functions,t_medicine_category.categoryname FROM r_category_medicine JOIN t_medicine_info ON r_category_medicine.medicineid=t_medicine_info.id JOIN t_medicine_category ON r_category_medicine.categoryid=t_medicine_category.id";
	    dbhelper.query2(sqlS);
//	    dbhelper.update();
//	    dbhelper.delete();
	    dbhelper.close();
	}
	
}
