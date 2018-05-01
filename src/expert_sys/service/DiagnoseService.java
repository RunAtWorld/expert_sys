package expert_sys.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expert_sys.dao.Diagnose;
import expert_sys.dao.Illness;
import expert_sys.dao.Medicine;
import expert_sys.dao.Priscription;
import expert_sys.db.DBHelper;

/**
 * @author yu
 * @date 创建时间：2017年4月10日 下午10:04:58 
 */
public class DiagnoseService {

	public List<Diagnose> getDiagnoseList(String[] symptoms) throws SQLException{
		Diagnose diagnose=new Diagnose();
//		String[] symptoms={"感冒","发热"};

		List<Diagnose> diagnosisList=diagnose.diagnoseProcess(symptoms);
		
//		if(diagnosisList!=null && !diagnosisList.isEmpty())
//		{
//			for(int i=0;i<diagnosisList.size();i++)
//			{
//				System.out.println(diagnosisList.get(i));
//			}
//			System.out.printf("共获取到%d个疾病id！%n",diagnosisList.size());
//		}
//		else
//		{
//			System.out.printf("无法根据已知信息判断疾病情况！");
//			
//		}
		return diagnosisList;
	}
	
	/**
	 * 根据疾病id获得处方信息
	 * @return 处方对应的药品信息
	 * @throws SQLException
	 */
	public  List<Medicine> getPrescriptionByIllId(int illId) throws SQLException
	{
	    DBHelper dbhelper=new DBHelper();
		String sqlS=String.format("SELECT * from view_priscription_en WHERE illness_id = %d", illId);
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
/*                String tradename = null;
                String id = null;
                String functions = null;
                String cat = null;
		         id = rs.getString("id");
		         tradename= rs.getString("tradename");
		         functions= rs.getString("functions");
		         cat= rs.getString("category");
                //输出结果
                System.out.println(id + "\t" + tradename + "\t" + functions + cat);*/
            	Medicine medicine = new Medicine(rs.getString("registration_numbers"), rs.getString("tradename"),rs.getString("generic_name"),
                		rs.getString("functions"),rs.getString("adverse_reaction"), rs.getString("notice"),rs.getString("traits"),rs.getString("norms"), 
                		rs.getString("imgurl"),rs.getString("manufacturers"),rs.getString("preparation"), rs.getString("packaging"), 
                		rs.getString("ingredient"),	rs.getString("dosage"), rs.getString("category"), rs.getDate("registrate_date"));
            	medicine.setId(rs.getInt("medicine_id"));
                medlist.add(medicine);
            }
        }

        rs.close();
	    dbhelper.close();
	    return medlist;
	}
	
	/**
	 * 获取与药品名关键字相关的药品信息集合
	 * @param medicineId 药品Id
	 * @return 相关药品信息集合
	 * @throws SQLException
	 */
	public  List<Medicine> getMedicineInfoByMedicineId(int medicineId) throws SQLException
	{
        System.out.println("-----------------");
        System.out.println("执行结果如下所示:");  
        System.out.println("-----------------");  
        System.out.println("id" + "\t" + "商品名" + "\t" + "功能主治" + "\t" + "分类");  
        System.out.println("-----------------");  
        
	    DBHelper dbhelper=new DBHelper();
	    String sqlS=String.format("SELECT * FROM view_medicine WHERE id = %d ",medicineId);
		System.out.println(sqlS);
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
/*                String tradename = null;
                String id = null;
                String functions = null;
                String cat = null;
                 id = rs.getString("id");
                 tradename= rs.getString("tradename");
                 functions= rs.getString("functions");
                 cat= rs.getString("category");
                //输出结果
                System.out.println(id + "\t" + tradename + "\t" + functions + cat);*/

                medlist.add(new Medicine(rs.getString("registration_numbers"), rs.getString("tradename"),rs.getString("generic_name"),
                		rs.getString("functions"),rs.getString("adverse_reaction"), rs.getString("notice"),rs.getString("traits"),rs.getString("norms"), 
                		rs.getString("imgurl"),rs.getString("manufacturers"),rs.getString("preparation"), rs.getString("packaging"), 
                		rs.getString("ingredient"),	rs.getString("dosage"), rs.getString("category"), rs.getDate("registrate_date")));
            }
        }

        rs.close();
	    dbhelper.close();
	    return medlist;
	}
	
	/**
	 * 获取与药品名关键字相关的药品信息集合
	 * @param tradeName 药品商品名
	 * @return 相关药品信息集合
	 * @throws SQLException
	 */
	public  List<Medicine> getMedicineInfoByTradeName(String tradeName) throws SQLException
	{
        System.out.println("-----------------");
        System.out.println("执行结果如下所示:");  
        System.out.println("-----------------");  
        System.out.println("id" + "\t" + "商品名" + "\t" + "功能主治" + "\t" + "分类");  
        System.out.println("-----------------");  
        
	    DBHelper dbhelper=new DBHelper();
	    String sqlS=String.format("SELECT * FROM view_medicine WHERE tradename LIKE '%%%s%%' ",tradeName.trim());
		System.out.println(sqlS);
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
/*                String tradename = null;
                String id = null;
                String functions = null;
                String cat = null;
                 id = rs.getString("id");
                 tradename= rs.getString("tradename");
                 functions= rs.getString("functions");
                 cat= rs.getString("category");
                //输出结果
                System.out.println(id + "\t" + tradename + "\t" + functions + cat);*/
            	Medicine medicine = new Medicine(rs.getString("registration_numbers"), rs.getString("tradename"),rs.getString("generic_name"),
                		rs.getString("functions"),rs.getString("adverse_reaction"), rs.getString("notice"),rs.getString("traits"),rs.getString("norms"), 
                		rs.getString("imgurl"),rs.getString("manufacturers"),rs.getString("preparation"), rs.getString("packaging"), 
                		rs.getString("ingredient"),	rs.getString("dosage"), rs.getString("category"), rs.getDate("registrate_date"));
            	medicine.setId(rs.getInt("id"));
                medlist.add(medicine);
            }
        }

        rs.close();
	    dbhelper.close();
	    return medlist;
	}
	
	/**
	 * 根据疾病对象返回药方列表
	 * @param 疾病对象
	 * @return 药方列表
	 * @throws SQLException
	 */
	public  List<Priscription> getPrescriptionByIllness(Illness ill) throws SQLException
	{
		System.out.println("开始根据疾病查找药方...");  
	    DBHelper dbhelper=new DBHelper();
		String sqlS=String.format("SELECT * from view_priscription_en WHERE illness_id = %d",  ill.getId());
        ResultSet rs=dbhelper.query2(sqlS);
        List<Priscription> priscriptionlist=null;
        List<Medicine> medlist=null;
        List<Integer> pris_ids=new ArrayList<Integer>();
        if(rs!=null)
        {	
        	priscriptionlist = new ArrayList<Priscription>();       	
            while(rs.next()){
            	if(pris_ids.contains(rs.getInt("prescription_id")))
            	{
            		//如果药方信息已经存在，为药方加入药品
                	Medicine medicine=new Medicine(rs.getString("registration_numbers"), rs.getString("tradename"),rs.getString("generic_name"),
                    		rs.getString("functions"),rs.getString("adverse_reaction"), rs.getString("notice"),rs.getString("traits"),rs.getString("norms"), 
                    		rs.getString("imgurl"),rs.getString("manufacturers"),rs.getString("preparation"), rs.getString("packaging"), 
                    		rs.getString("ingredient"),	rs.getString("dosage"), rs.getString("category"), rs.getDate("registrate_date"));
                	medicine.setId(rs.getInt("medicine_id"));
                	medlist.add(medicine);
            	}
            	else
            	{ 
            		//加入新的药方信息
            		medlist=new ArrayList<Medicine>();
            		Priscription priscription=new Priscription(rs.getInt("prescription_id"), ill, medlist);
            		pris_ids.add(rs.getInt("prescription_id"));
            		priscriptionlist.add(priscription);
            	}

            }
            System.out.println(priscriptionlist.toString());
            System.out.println("成功获取药方...");
        }

        rs.close();
	    dbhelper.close();

		return priscriptionlist;
	}
}
