package expert_sys.dao;

public class Symptom {
	private int id;
	private String symptom;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Symptom(int id, String symptom) {
		super();
		this.id = id;
		this.symptom = symptom;
	}
	public Symptom(int id, String symptom, String remark) {
		super();
		this.id = id;
		this.symptom = symptom;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Symptom [id=" + id + ", symptom=" + symptom + ", remark=" + remark + "]";
	}

}
