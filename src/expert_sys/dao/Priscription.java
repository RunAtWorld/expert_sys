package expert_sys.dao;

import java.util.List;

/**
 * @author lpf
 *
 */
public class Priscription {
	
	/**
	 * 药方id
	 */
	Integer prescription_id;
	
	/**
	 * 疾病
	 */
	Illness illness;
	
	/**
	 *西医药方列表 
	 */
	List<Medicine> medicinelist;

	public Integer getPrescription_id() {
		return prescription_id;
	}

	public void setPrescription_id(Integer prescription_id) {
		this.prescription_id = prescription_id;
	}

	public Illness getIllness() {
		return illness;
	}

	public void setIllness(Illness illness) {
		this.illness = illness;
	}

	public List<Medicine> getMedicinelist() {
		return medicinelist;
	}

	public void setMedicinelist(List<Medicine> medicinelist) {
		this.medicinelist = medicinelist;
	}

	public Priscription(Integer prescription_id, Illness illness, List<Medicine> medlist) {
		super();
		this.prescription_id = prescription_id;
		this.illness = illness;
		this.medicinelist = medlist;
	}

	@Override
	public String toString() {
		String out="Priscription [prescription_id=" + prescription_id + ", illness=" + illness.toString();
		String prises=String.format("medicinelist(%d):%n",this.medicinelist.size());
		for(int i=0;i<this.medicinelist.size();i++)
		{
			prises+=String.format("药方%d:%n",this.prescription_id);
			prises+=this.medicinelist.get(i).toString();
			prises+=String.format("%n%n");
		}
		out+=prises;		
		return  out;
	}
	
}
