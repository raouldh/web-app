package nl.rdehaard.webapp.rest;

import nl.rdehaard.webapp.core.entities.BlogEntry;

import org.springframework.hateoas.ResourceSupport;

public class BlogEntryResource extends ResourceSupport {

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BlogEntry toBlogEntry() {
		final BlogEntry entry = new BlogEntry();
		entry.setTitle(title);
		return entry;
	}
}
