package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name="categories")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int nameCategories;

	public Category() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNameCategories() {
		return this.nameCategories;
	}

	public void setNameCategories(int nameCategories) {
		this.nameCategories = nameCategories;
	}

}