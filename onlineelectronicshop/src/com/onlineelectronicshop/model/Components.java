package com.onlineelectronicshop.model;



	import java.util.Objects;



	public class Components {

		private String componentId;
		private String componentName;
		private String CategoryId;
		private String categoryName;
		private String description;
		private double totalPrice;
		public String getComponentId() {
			return componentId;
		}
		public void setComponentId(String componentId) {
			this.componentId = componentId;
		}
		public String getComponentName() {
			return componentName;
		}
		public void setComponentName(String componentName) {
			this.componentName = componentName;
		}
		public String getCategoryId() {
			return CategoryId;
		}
		public void setCategoryId(String categoryId) {
			CategoryId = categoryId;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public Components(String componentId, String componentName, String categoryId, String categoryName,
				String description, double totalPrice) {
			super();
			this.componentId = componentId;
			this.componentName = componentName;
			CategoryId = categoryId;
			this.categoryName = categoryName;
			this.description = description;
			this.totalPrice = totalPrice;
		}
		public Components() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public String toString() {
			return "Components [componentId=" + componentId + ", componentName=" + componentName + ", CategoryId="
					+ CategoryId + ", categoryName=" + categoryName + ", description=" + description + ", totalPrice="
					+ totalPrice + "]";
		}
		@Override
		public int hashCode() {
			return Objects.hash(CategoryId, categoryName, componentId, componentName, description, totalPrice);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Components other = (Components) obj;
			return Objects.equals(CategoryId, other.CategoryId) && Objects.equals(categoryName, other.categoryName)
					&& Objects.equals(componentId, other.componentId)
					&& Objects.equals(componentName, other.componentName)
					&& Objects.equals(description, other.description)
					&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
		}
		
		
		
		
	}
