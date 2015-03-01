package nl.rdehaard.webapp.core.services.util;

import java.util.ArrayList;
import java.util.List;

import nl.rdehaard.webapp.core.model.entities.BlogEntry;

public class BlogEntryList {
	private List<BlogEntry> entries = new ArrayList<BlogEntry>();
	private Long blogId;

	public BlogEntryList(Long blogId, List<BlogEntry> entries) {
		this.blogId = blogId;
		this.entries = entries;
	}

	public List<BlogEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<BlogEntry> entries) {
		this.entries = entries;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
}
