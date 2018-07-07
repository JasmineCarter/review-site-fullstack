package org.wecancodeit.reviewsitefullstack;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //magic of JPA connects the category to the repository
public class Category {

	@Id
	@GeneratedValue
	private long id; 
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	private String beverage;
	
	@OneToMany(mappedBy = "beverage")
	private Collection<Review> reviews; 
	
	

	public Category(String beverage) {
		this.beverage = beverage; 
	}

	public Category() {
}

	public long getId() {
		return id;
	}

	public String getBeverage() {
		return beverage;
	}
}