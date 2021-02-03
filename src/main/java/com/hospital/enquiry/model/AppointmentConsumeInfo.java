package com.hospital.enquiry.model;

import java.io.Serializable;

public class AppointmentConsumeInfo implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String type;
		private String name;
		private String availableDays;
		private String availableTime;
		private String isAvailable;
		private int hospitalId;
		private String hospitalName;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAvailableDays() {
			return availableDays;
		}
		public void setAvailableDays(String availableDays) {
			this.availableDays = availableDays;
		}
		public String getAvailableTime() {
			return availableTime;
		}
		public void setAvailableTime(String availableTime) {
			this.availableTime = availableTime;
		}
		public String getIsAvailable() {
			return isAvailable;
		}
		public void setIsAvailable(String isAvailable) {
			this.isAvailable = isAvailable;
		}
		public int getHospitalId() {
			return hospitalId;
		}
		public void setHospitalId(int hospitalId) {
			this.hospitalId = hospitalId;
		}
		public String getHospitalName() {
			return hospitalName;
		}
		public void setHospitalName(String hospitalName) {
			this.hospitalName = hospitalName;
		}
		public AppointmentConsumeInfo(String type, String name, String availableDays, String availableTime,
				String isAvailable, int hospitalId, String hospitalName) {
			super();
			this.type = type;
			this.name = name;
			this.availableDays = availableDays;
			this.availableTime = availableTime;
			this.isAvailable = isAvailable;
			this.hospitalId = hospitalId;
			this.hospitalName = hospitalName;
		}
		public AppointmentConsumeInfo() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
