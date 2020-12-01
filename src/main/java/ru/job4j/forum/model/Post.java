package ru.job4j.forum.model;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private Calendar created;

	public static Post of(String name, String desc) {
		Post post = new Post();
		post.name = name;
		post.description = desc;
		post.created = Calendar.getInstance();
		return post;
	}

	public static Post of(int id, String name, String desc) {
		Post post = Post.of(name, desc);
		post.id = id;
		return post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Post post = (Post) o;
		return id == post.id && Objects.equals(name, post.name) && Objects.equals(description, post.description)
				&& Objects.equals(created, post.created);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, created);
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", description=" + description + ", created=" + created + "]";
	}

}
