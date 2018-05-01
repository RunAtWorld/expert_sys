package expert_sys.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expert_sys.db.DBHelper;


public class Diagnose {
	/**
	 * 诊断序号
	 */
	private int id;
	/**
	 * 症状序号集合
	 */
	private String symptom_ids;
	/**
	 * 疾病
	 */
	private Illness illness;
	/**
	 * 置信度
	 */
	private float confidence;
	
	/**
	 * 诊断准确度
	 */
	private float accuracy_rate;
	
	@Override
	public String toString() {
		return "Diagnose [id=" + id + ", symptom_ids=" + symptom_ids + ", illness=" + illness + ", confidence="
				+ confidence + ",accuracy_rate="+accuracy_rate +  "]";
	}

	public Diagnose(int id, String symptom_ids, Illness illness, float confidence) {
		super();
		this.id = id;
		this.symptom_ids = symptom_ids;
		this.illness = illness;
		this.confidence = confidence;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymptom_ids() {
		return symptom_ids;
	}

	public void setSymptom_ids(String symptom_ids) {
		this.symptom_ids = symptom_ids;
	}

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}


	public float getAccuracy_rate() {
		return accuracy_rate;
	}

	public void setAccuracy_rate(float accuracy_rate) {
		this.accuracy_rate = accuracy_rate;
	}

	/**
	 * 获取全部药品信息
	 * @return 全部药品信息集合
	 * @throws SQLException
	 */
	public  List<Medicine> getMedicineInfo() throws SQLException
	{
        System.out.println("-----------------");
        System.out.println("执行结果如下所示:");  
        System.out.println("-----------------");  
        System.out.println("id" + "\t" + "商品名" + "\t" + "功能主治" + "\t" + "分类");  
        System.out.println("-----------------");  
        
	    DBHelper dbhelper=new DBHelper();
		String sqlS="SELECT * FROM view_medicine";
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
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
	    DBHelper dbhelper=new DBHelper();
	    String sqlS=String.format("SELECT * FROM view_medicine WHERE tradename LIKE '%%%s%%' ",tradeName.trim());
		System.out.println(sqlS);
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
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
	 * 根据疾病id获得药品信息
	 * @return 所有药品信息
	 * @throws SQLException
	 */
	public  List<Medicine> getMedicinesByIllId(int illId) throws SQLException
	{
		System.out.println("开始根据疾病id查找药品列表...");  
	    DBHelper dbhelper=new DBHelper();
		String sqlS=String.format("SELECT * from view_priscription_en WHERE illness_id = %d", illId);
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
                medlist.add(new Medicine(rs.getInt("medicine_id"),rs.getString("registration_numbers"), rs.getString("tradename"),rs.getString("generic_name"),
                		rs.getString("functions"),rs.getString("adverse_reaction"), rs.getString("notice"),rs.getString("traits"),rs.getString("norms"), 
                		rs.getString("imgurl"),rs.getString("manufacturers"),rs.getString("preparation"), rs.getString("packaging"), 
                		rs.getString("ingredient"),	rs.getString("dosage"), rs.getString("category"), rs.getDate("registrate_date")));
            }
            System.out.println(medlist.toString());
            System.out.println("成功获取药品列表...");
        }

        rs.close();
	    dbhelper.close();
	    return medlist;
	}
	
	/**
	 * 根据疾病id获得多个处方
	 * @return 所有处方信息
	 * @throws SQLException
	 */
	public  List<Priscription> getPrescriptionByIllId(int illId) throws SQLException
	{
		System.out.println("开始根据疾病id查找疾病...");  
		this.illness=Illness.getIllnessById(illId);
		System.out.println("成功查找到该疾病名字:"+this.illness.getIllnessname());  
		
		System.out.println();
		System.out.println("开始根据疾病id查找药方...");  
	    DBHelper dbhelper=new DBHelper();
		String sqlS=String.format("SELECT * from view_priscription_en WHERE illness_id = %d", illId);
        ResultSet rs=dbhelper.query2(sqlS);
        List<Priscription> priscriptionlist=null;
        List<Integer> pris_ids=new ArrayList<Integer>();
        if(rs!=null)
        {	
        	
        	priscriptionlist = new ArrayList<Priscription>();    
        	while(rs.next())
        	{
        		if(!pris_ids.contains(rs.getInt("prescription_id")))
        		{
        			pris_ids.add(rs.getInt("prescription_id"));
            		//加入新的药方信息
            		List<Medicine> medlist=new ArrayList<Medicine>();
            		Priscription priscription=new Priscription(rs.getInt("prescription_id"), this.illness, medlist);  		
            		priscriptionlist.add(priscription); 
        		}
        	}
        	
        	rs.beforeFirst();      	
            while(rs.next()){            	
        		//如果药方信息已经存在，为药方加入药品
            	Medicine medicine=new Medicine(rs.getInt("medicine_id"),rs.getString("registration_numbers"), rs.getString("tradename"),rs.getString("generic_name"),
                		rs.getString("functions"),rs.getString("adverse_reaction"), rs.getString("notice"),rs.getString("traits"),rs.getString("norms"), 
                		rs.getString("imgurl"),rs.getString("manufacturers"),rs.getString("preparation"), rs.getString("packaging"), 
                		rs.getString("ingredient"),	rs.getString("dosage"), rs.getString("category"), rs.getDate("registrate_date"));
                for(int i=0;i<priscriptionlist.size();i++)
                {
                	if(priscriptionlist.get(i).prescription_id==rs.getInt("prescription_id"))
                	{
                		System.out.printf("药方%d加入药品%d:%n",priscriptionlist.get(i).prescription_id,medicine.getId());
                		priscriptionlist.get(i).medicinelist.add(medicine);
                	}
                }
            }
            System.out.printf("成功获取%d个药方...%n",priscriptionlist.size());
        }

        rs.close();
	    dbhelper.close();

		return priscriptionlist;
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
	/**
	 * 根据疾病名称大致匹配处方信息
	 * @param illName 疾病名称
	 * @return 处方对应的药品信息
	 * @throws SQLException
	 */
	public  List<Medicine> getMedicineByIllName(String illName) throws SQLException
	{
	    DBHelper dbhelper=new DBHelper();
		String sqlS=String.format("SELECT * FROM view_priscription_en WHERE illnessname LIKE '%%%s%%' ",illName.trim());
        ResultSet rs=dbhelper.query2(sqlS);
        List<Medicine> medlist=null;
        if(rs!=null)
        {	
        	medlist=new ArrayList<Medicine>();
            while(rs.next()){
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
	 * 根据症状进行诊断，并返回可能的疾病诊断
	 * @param 症状字符串数组
	 * @return 可能的疾病诊断
	 * @throws SQLException 
	 */
	public List<Diagnose> diagnoseProcess(String[] symptoms) throws SQLException
	{
	    DBHelper dbhelper=new DBHelper();
		System.out.println("输入的症状为：");
		for(int k=0;k<symptoms.length;k++)
			System.out.print(symptoms[k]+"   ");
		
		System.out.println();
		System.out.println();
	    //在数据库中找出标准症状关键词对应的id
	    System.out.println("在数据库中找出标准症状关键词对应的id...");
	    List<Symptom> symptomList=new ArrayList<Symptom>();
	    ResultSet rs1=null;
	    for(int j=0;j<symptoms.length;j++)
	    {
	    	String sqlSymp=String.format("SELECT * FROM t_symptom WHERE symptom LIKE '%%%s%%' ", symptoms[j].trim());
	    	System.out.println(sqlSymp);
	    	rs1=dbhelper.query2(sqlSymp);
	    	if(rs1!=null)
	    	{
		    	while(rs1.next())
		    	{
		    		Symptom symp=new Symptom(rs1.getInt("id"), rs1.getString("symptom"),rs1.getString("remark"));
		    		if(!symptomList.contains(symp))
		    			{
		    				symptomList.add(symp);
		    				System.out.println(symp.toString());
		    			}
		    	}
	    	}
	    	else
	    		continue;
	    }
	    
	    //在数据库中找出可能引起该症状的疾病
	    System.out.println("在数据库中找出可能引起该症状的疾病...");
	    List<Diagnose> diagnosisList=new ArrayList<Diagnose>();
	    ResultSet rs=null;
	    String sqlS="";
	    for(int i=0;i<symptomList.size();i++)
	    {
	    	if(i==0)
	    		sqlS=String.format("SELECT * FROM view_diagnose WHERE symptoms LIKE '%%#%d#%%'",symptomList.get(i).getId());
	    	else 
	    		sqlS+=String.format("OR symptoms LIKE '%%#%d#%%'",symptomList.get(i).getId());
	    }
	    System.out.println(sqlS);
	    if(sqlS!="" && sqlS != null)
	    	rs=dbhelper.query2(sqlS);
	    if(rs!=null)
        {	
            while(rs.next()){
            	Illness ill=new Illness(rs.getInt("illness_id"), rs.getString("illnessname"), rs.getString("division"), 
            			rs.getString("prescription_cn"),rs.getInt("level"));
            	Diagnose diag=new Diagnose(rs.getInt("id"), rs.getString("symptoms"), ill, rs.getFloat("confidence"));
            	
            	//计算诊断准确率
            	System.out.println("开始计算诊断准确率...");
            	String[] sympotomArray=rs.getString("symptoms").split(";");
            	List<String> symptoms_in_db=new ArrayList<String>();
            	
            	for(int i=0;i<sympotomArray.length;i++)
            		if(sympotomArray[i]!=null && sympotomArray[i]!="")
            		{
            			symptoms_in_db.add(sympotomArray[i].replace("#", ""));	
            		}
            			
            	float  weight_sum=0.0000f;
            	float weight_average=0.0000f;
            	if(!symptoms_in_db.isEmpty())
            		weight_average=(float)1/symptoms_in_db.size();
            	System.out.println("weight_average="+weight_average);
            	for(int k=0;k<symptomList.size();k++)
            	{
            		if(symptoms_in_db.contains(Integer.toString(symptomList.get(k).getId())))
            		{
            			weight_sum+=weight_average;
            		}
            	}
            	System.out.println("weight_sum="+weight_sum);
            	
            	diag.setAccuracy_rate((diag.confidence*weight_sum));
            	if(!diagnosisList.contains(diag))
            		diagnosisList.add(diag);
            }
            rs.close();
        }
	    dbhelper.close();

	    if(diagnosisList.size()<=0)
	    	return null;
	    else
	    	return diagnosisList;
	}

	public Diagnose() {
		super();
	}


}
