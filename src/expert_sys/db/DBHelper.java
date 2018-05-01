package expert_sys.db;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.Configuration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * @author lpf
 *
 */
public class DBHelper {
    //声明Connection对象
    Connection con;
    //驱动程序名
    String driver;
    //URL指向要访问的数据库名mydata
    String url;
    //MySQL配置时的用户名
    String user;
    //MySQL配置时的密码
    String password;
    
    
    /**
     * 构造函数
     * @param driver
     * @param url
     * @param user
     * @param password
     */
    public DBHelper(String driver,String url,String user,String password) {
		this.driver=driver;
		this.url=url;
		this.user=user;
		this.password=password;
		try {
	        //加载驱动程序
	        Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = (Connection) DriverManager.getConnection(url, user, password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
		} catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }
	}
    
    
    /**
     *无参数构造函数，默认读取config目录下dbconfig.xml的第一个数据库配置 
     */
    public DBHelper() {
    	setDBConfig();
		try {
	        //加载驱动程序
	        Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = (Connection) DriverManager.getConnection(url, user, password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
		} catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }
	}
    
	/**
	 * 设置当前连接的数据库
	 */
	private void setDBConfig()
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			//打印数据库配置内容
			db = dbf.newDocumentBuilder();
			//URL path = Configuration.class.getClassLoader().getResource("dbconfig.xml");
			String path = DBHelper.class.getResource("/").toString();  
			//System.out.println(path+"------path");
			Document doc=db.parse(path+"/dbconfig.xml");
			NodeList dblist=doc.getElementsByTagName("DataBase");
			//设置本程序使用的数据库
			String configs="";
			Node cur_config=(Node) dblist.item(0);
			NodeList cur_items=(NodeList) cur_config.getChildNodes();
			for(int j=0;j<cur_items.getLength();j++)
			{
				if(cur_items.item(j).getNodeType() == Node.ELEMENT_NODE){
					switch(cur_items.item(j).getNodeName())
					{
							case "driver":
								this.driver=cur_items.item(j).getTextContent();
								break;
							case "url":
								this.url=cur_items.item(j).getTextContent()+"?useUnicode=true&characterEncoding=UTF-8";
								break;
							case "user":
								this.user=cur_items.item(j).getTextContent();
								break;
							case "password":
								this.password=cur_items.item(j).getTextContent();
								break;
							default:
								break;
					
					}
				}
			}			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * 输出所有数据库的配置文件
	 */
	private void ShowDBConfig()
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			//打印数据库配置内容
			db = dbf.newDocumentBuilder();
			Document doc=db.parse("config/dbconfig.xml");
			NodeList dblist=doc.getElementsByTagName("DataBase");
			//查看所有数据库配置
			System.out.printf("输出所有数据库配置，一共有%d个数据库%n",dblist.getLength());
			for(int i=0;i<dblist.getLength();i++)
			{
				System.out.printf("输出第%d个数据库%n",i+1);
				Node dbnode=(Node) dblist.item(i);
				NodeList dbconfigs=(NodeList) dbnode.getChildNodes();
				for(int j=0;j<dbconfigs.getLength();j++)
				{
					if(dbconfigs.item(j).getNodeType() == Node.ELEMENT_NODE){
					System.out.printf("  输出第%d个数据库配置%n",j+1);
					System.out.printf("节点名   %s    节点值：%s  %n",dbconfigs.item(j).getNodeName(),dbconfigs.item(j).getTextContent());
					}
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
    public void query(){
    	//遍历查询结果集
        try {
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = (Statement) con.createStatement();
            //要执行的SQL语句
            String sql = "select * from Diagnose";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-----------------");
            System.out.println("执行结果如下所示:");  
            System.out.println("-----------------");  
            System.out.println("姓名" + "\t" + "职称");  
            System.out.println("-----------------");  
             
            String job = null;
            String id = null;
            while(rs.next()){
                //获取stuname这列数据
                job = rs.getString("job");
                //获取stuid这列数据
                id = rs.getString("ename");

                //输出结果
                System.out.println(id + "\t" + job);
            }
            rs.close();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("数据库连接成功，请求执行完毕！");
        }	
    }
    
    
    /**
     * 根据数据库查询语句查询数据
     * @param sql ： 要执行的查询语句
     */
    public ResultSet query2(String sql){
    	//遍历查询结果集
        try {
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = (Statement) this.con.createStatement();
            //要执行的SQL语句
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            //rs.close();
            return rs;
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
		return null;	
    }
    

    public void insert() throws SQLException{
    	PreparedStatement psql=null;
    	//预处理添加数据，其中有两个参数--“？”
		psql = (PreparedStatement) con.prepareStatement("insert into Diagnose (empno,ename,job,hiredate,sal) "
    	        + "values(?,?,?,?,?)");
    	psql.setInt(1, 3214);              //设置参数1，创建id为3212的数据
    	psql.setString(2, "王小聪");      //设置参数2，name 为王刚
    	psql.setString(3, "总裁助理");
    	DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    	Date myDate2=null;
		try {
			myDate2 = (Date) dateFormat2.parse("2010-09-13");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	psql.setDate(4,new java.sql.Date(myDate2.getTime()));
    	psql.setFloat(5, (float) 2000.3);		
    	psql.executeUpdate();
    }
	
    public void update() throws SQLException{
    	PreparedStatement psql=null;
    	//预处理更新（修改）数据，将王刚的sal改为5000.0
		if(con==null)
			System.out.println("连接指针为空");
		psql =(PreparedStatement) con.prepareStatement("update Diagnose set sal = ? where ename = ?");
		if(psql==null)
			System.out.println("psql为空！");
		psql.setFloat(1, (float) 5000);	
    	psql.setString(2,"王刚");        
		psql.executeUpdate();        //执行更新
    }
    
    public void delete() throws SQLException{
    	PreparedStatement psql;
    	//预处理删除数据
    	psql = (PreparedStatement) con.prepareStatement("delete from Diagnose where sal > ?");
    	psql.setFloat(1, 4500);
    	psql.executeUpdate();
    }
	
    
    /**
     * 批量处理插入
     * @return 插入成功的记录数
     */
    public int excuteBatch(){
    	try {
    		Statement sql;
    		//不允许批处理中有失败的语句，使用手动提交事务的方式
			con.setAutoCommit(false);
	    	sql=(Statement) con.createStatement();
	    	sql.addBatch("insert into Diagnose (empno,ename,job,hiredate,sal) values('10','张勋','工人','2010-09-13',1300)");
	    	sql.addBatch("insert into Diagnose (empno,ename,job,hiredate,sal) values('11','张中','工人','2010-09-13',1300)");
	    	sql.addBatch("insert into Diagnose (empno,ename,job,hiredate,sal) values('12','张性','工人','2010-09-13',1300)");
	    	sql.addBatch("insert into Diagnose (empno,ename,job,hiredate,sal) values('13','张共','工人','2010-09-13',1300)");
	    	sql.addBatch("insert into Diagnose (empno,ename,job,hiredate,sal) values('14','张浪奇','工人','2010-09-13',1300)");
	    	int[] nums=sql.executeBatch();
	    	con.commit();
	    	sql.clearBatch();
	    	//恢复事务提交
	    	con.setAutoCommit(true);
	    	//返回执行的语句数
	    	return nums.length;
		} catch (SQLException e) {
			//批处理失败就回滚事务
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return 0;
		}
    }
    
    public void close() throws SQLException
    {
        this.con.close();
    }
}
