package nl.rdehaard.webapp.core.services;

import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.core.model.entities.BlogEntry;
import nl.rdehaard.webapp.core.services.util.BlogEntryList;
import nl.rdehaard.webapp.core.services.util.BlogList;

public interface BlogService {
	/**
	 * @param blogId
	 *            the id of the blog to add this BlogEntry to
	 * @param data
	 *            the BlogEntry containing the data to be used for creating the
	 *            new entity
	 * @return the created BlogEntry with a generated ID
	 * @throws tutorial.core.services.exceptions.BlogNotFoundException
	 *             if the blog to add to cannot be found
	 */
	BlogEntry createBlogEntry(Long blogId, BlogEntry data);

	BlogList findAllBlogs();

	BlogEntryList findAllBlogEntries(Long blogId); // findBlog all
													// associated blog
													// entries

	Blog findBlog(Long id);
}
