package nl.rdehaard.webapp.rest.resource;

import nl.rdehaard.webapp.core.model.entities.Blog;

import org.springframework.hateoas.ResourceSupport;

public class BlogResource extends ResourceSupport {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Blog toBlog() {
		Blog blog = new Blog();
		blog.setTitle(title);
		return blog;
	}
}