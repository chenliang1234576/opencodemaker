package  com.opensource.maker.test.model;

import java.util.Date;

public class Txuser{ 

 		private String userid;
		private String username;
		private String userpass;
		private String supplierid;
		private int province;
		private int city;
		private int county;
		private Date addtime;
		private String countries;
		private String timeZone;

		public String getUserid(){
				return userid; 
		}
		public void setUserid(String userid){
				this.userid=userid; 
		}

		public String getUsername(){
				return username; 
		}
		public void setUsername(String username){
				this.username=username; 
		}

		public String getUserpass(){
				return userpass; 
		}
		public void setUserpass(String userpass){
				this.userpass=userpass; 
		}

		public String getSupplierid(){
				return supplierid; 
		}
		public void setSupplierid(String supplierid){
				this.supplierid=supplierid; 
		}

		public int getProvince(){
				return province; 
		}
		public void setProvince(int province){
				this.province=province; 
		}

		public int getCity(){
				return city; 
		}
		public void setCity(int city){
				this.city=city; 
		}

		public int getCounty(){
				return county; 
		}
		public void setCounty(int county){
				this.county=county; 
		}

		public Date getAddtime(){
				return addtime; 
		}
		public void setAddtime(Date addtime){
				this.addtime=addtime; 
		}

		public String getCountries(){
				return countries; 
		}
		public void setCountries(String countries){
				this.countries=countries; 
		}

		public String getTimeZone(){
				return timeZone; 
		}
		public void setTimeZone(String timeZone){
				this.timeZone=timeZone; 
		}

}
