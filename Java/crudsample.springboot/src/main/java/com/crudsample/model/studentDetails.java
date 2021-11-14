package com.crudsample.model;

	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;

	import javax.persistence.GenerationType;


	@Entity
	@Table(name = "student_details")
	public class studentDetails {
		
	    private long Id;
		private String fname;
	    private String lname;
	    private String email;
	    private String course;
	    private String phone;
	 
	    public studentDetails() {
	  
	    }
	 
	    public studentDetails(String firstName, String lastName, String emailId, String course, String phone) {
	         this.fname= firstName;
	         this.lname= lastName;
	         this.email= emailId;
	         this.course= course;
	         this.phone= phone;
	    }
	    
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	    public long getId() {
			return Id;
		}

		public void setId(long Id) {
			this.Id = Id;
		}
		
		@Column(name = "first_name", nullable = false)
		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}
		
		@Column(name = "last_name", nullable = false)
		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}
		
		@Column(name = "email_address", nullable = false)
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Column(name = "course_details", nullable = false)
		public String getCourse() {
			return course;
		}

		public void setCourse(String course) {
			this.course = course;
		}
		
		@Column(name = "phone_number", nullable = false)
		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
	 
		@Override
		public String toString() {
			return "studentDetails [Id=" + Id + ",firstName=" + fname + ", lastName=" + lname + ", emailId=" + email + ", course=" + course + ", phone=" + phone + "]";
		}
		
		
		
		
	}

