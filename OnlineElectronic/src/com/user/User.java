
package com.user;
	import java.util.Objects;

	public class User {

		private String name;
		private String email_id;
		private String password;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail_id() {
			return email_id;
		}
		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public User() {
			super();
		}
		public User(String name, String email_id, String password) {
			super();
			this.name = name;
			this.email_id = email_id;
			this.password = password;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", email_id=" + email_id + ", password=" + password + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(email_id, name, password);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(email_id, other.email_id) && Objects.equals(name, other.name)
					&& Objects.equals(password, other.password);
		}
		
	}


