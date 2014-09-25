package master.tattoo.slidingmenu;

import com.parse.ParseFile;

public class MasterDetails {
	private String Master_id;
	private String Name;
	private String Gender;
	//private String Tel;
	//private String Email;
	//private String Address;
	//private String Website;
	private String image;

	public String getMaster_id() {
		return Master_id;
	}

	public void setMaster_id(String Master_id) {
		this.Master_id = Master_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	
	public String getGender() {
		return Gender;
	}

	public void setGender(String Gender) {
		this.Gender = Gender;
	}

	/*public String getTel() {
		return Tel;
	}

	public void setTel(String Tel) {
		this.Tel = Tel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}
	
	public String getAddress() {
		return Address;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String Website) {
		this.Website = Website;
	}
	*/
	
	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}
}

