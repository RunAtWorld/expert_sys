package expert_sys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import expert_sys.db.DBHelper;

public class Illness {

	private int id;
	private String illnessname;
	private String division;
	private String prescription_cn;
	private int level;
	
	public Illness(int id, String illnessname, String division, String prescription_cn, int level) {
		super();
		this.id = id;
		this.illnessname = illnessname;
		this.division = division;
		this.prescription_cn = prescription_cn;
		this.level = level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIllnessname() {
		return illnessname;
	}
	public void setIllnessname(String illnessname) {
		this.illnessname = illnessname;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPrescription_cn() {
		return prescription_cn;
	}
	public void setPrescription_cn(String prescription_cn) {
		this.prescription_cn = prescription_cn;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Override
	public String toString() {
		return "Illness [id=" + id + ", illnessname=" + illnessname + ", division=" + division + ", prescription_cn="
				+ prescription_cn + ", level=" + level + "]";
	}

	public static Illness getIllnessById(int illId) throws SQLException
	{
	    DBHelper dbhelper=new DBHelper();
		String sqlS=String.format("SELECT * FROM t_illness WHERE id= %d",illId);
        ResultSet rs=dbhelper.query2(sqlS);
        Illness illness=null;
        if(rs!=null)
        {	
            while(rs.next()){
                illness=new Illness(rs.getInt("id"), rs.getString("illnessname"), rs.getString("division"), rs.getString("prescription_cn"), rs.getInt("level"));
            }
        }
        rs.close();
	    dbhelper.close();
	    return illness;
		
	}
	
}
