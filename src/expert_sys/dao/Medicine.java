package expert_sys.dao;
import java.util.Date;

/**
 * @author lpf
 *
 */
public class Medicine {
	private int id;
	private String registration_numbers;
	private String tradename;
	private String generic_name;
	private String functions;
	private String adverse_reaction;
	private String notice;
	private String traits;
	private String norms;
	private String imgurl;
	private String manufacturers;
	private String preparation;
	private String packaging;
	private String ingredient;
	private String dosage;
	private String category;
	private Date registrate_date;
	
	@Override
	public String toString() {
		return "Medicine [id=" + id + ", registration_numbers=" + registration_numbers + ", tradename=" + tradename
				+ ", generic_name=" + generic_name + ", functions=" + functions + ", adverse_reaction="
				+ adverse_reaction + ", notice=" + notice + ", traits=" + traits + ", norms=" + norms + ", imgurl="
				+ imgurl + ", manufacturers=" + manufacturers + ", preparation=" + preparation + ", packaging="
				+ packaging + ", ingredient=" + ingredient + ", dosage=" + dosage + ", category=" + category
				+ ", registrate_date=" + registrate_date + "]";
	}
	
	public Medicine(String registration_numbers, String tradename, String generic_name, String functions,
			String adverse_reaction, String notice, String traits, String norms, String imgurl, String manufacturers,
			String preparation, String packaging, String ingredient, String dosage, String category,
			Date registrate_date) {
		super();
		this.registration_numbers = registration_numbers;
		this.tradename = tradename;
		this.generic_name = generic_name;
		this.functions = functions;
		this.adverse_reaction = adverse_reaction;
		this.notice = notice;
		this.traits = traits;
		this.norms = norms;
		this.imgurl = imgurl;
		this.manufacturers = manufacturers;
		this.preparation = preparation;
		this.packaging = packaging;
		this.ingredient = ingredient;
		this.dosage = dosage;
		this.category = category;
		this.registrate_date = registrate_date;
	}

	public Medicine(int id, String registration_numbers, String tradename, String generic_name, String functions,
			String adverse_reaction, String notice, String traits, String norms, String imgurl, String manufacturers,
			String preparation, String packaging, String ingredient, String dosage, String category,
			Date registrate_date) {
		super();
		this.id = id;
		this.registration_numbers = registration_numbers;
		this.tradename = tradename;
		this.generic_name = generic_name;
		this.functions = functions;
		this.adverse_reaction = adverse_reaction;
		this.notice = notice;
		this.traits = traits;
		this.norms = norms;
		this.imgurl = imgurl;
		this.manufacturers = manufacturers;
		this.preparation = preparation;
		this.packaging = packaging;
		this.ingredient = ingredient;
		this.dosage = dosage;
		this.category = category;
		this.registrate_date = registrate_date;
	}

	public Medicine(String tradename, String functions, String adverse_reaction, String norms, String manufacturers,
			String preparation, String dosage) {
		super();
		this.tradename = tradename;
		this.functions = functions;
		this.adverse_reaction = adverse_reaction;
		this.norms = norms;
		this.manufacturers = manufacturers;
		this.preparation = preparation;
		this.dosage = dosage;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegistration_numbers() {
		return registration_numbers;
	}
	public void setRegistration_numbers(String registration_numbers) {
		this.registration_numbers = registration_numbers;
	}
	public String getTradename() {
		return tradename;
	}
	public void setTradename(String tradename) {
		this.tradename = tradename;
	}
	public String getGeneric_name() {
		return generic_name;
	}
	public void setGeneric_name(String generic_name) {
		this.generic_name = generic_name;
	}
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public String getAdverse_reaction() {
		return adverse_reaction;
	}
	public void setAdverse_reaction(String adverse_reaction) {
		this.adverse_reaction = adverse_reaction;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getTraits() {
		return traits;
	}
	public void setTraits(String traits) {
		this.traits = traits;
	}
	public String getNorms() {
		return norms;
	}
	public void setNorms(String norms) {
		this.norms = norms;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}
	public String getPreparation() {
		return preparation;
	}
	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getRegistrate_date() {
		return registrate_date;
	}
	public void setRegistrate_date(Date registrate_date) {
		this.registrate_date = registrate_date;
	}

	
}
