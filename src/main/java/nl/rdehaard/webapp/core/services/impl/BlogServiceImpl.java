package nl.rdehaard.webapp.core.services.impl;

import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.core.model.entities.BlogEntry;
import nl.rdehaard.webapp.core.repositories.BlogEntryRepo;
import nl.rdehaard.webapp.core.repositories.BlogRepo;
import nl.rdehaard.webapp.core.services.BlogService;
import nl.rdehaard.webapp.core.services.exceptions.BlogNotFoundException;
import nl.rdehaard.webapp.core.services.util.BlogEntryList;
import nl.rdehaard.webapp.core.services.util.BlogList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogRepo blogRepo;
	@Autowired
	private BlogEntryRepo entryRepo;

	@Override
	public BlogEntry createBlogEntry(Long blogId, BlogEntry data) {
		Blog blog = blogRepo.findBlog(blogId);
		if (blog == null) {
			throw new BlogNotFoundException();
		}
		BlogEntry entry = entryRepo.createBlogEntry(data);
		entry.setBlog(blog);
		return entry;
	}

	@Override
	public BlogList findAllBlogs() {
		return new BlogList(blogRepo.findAllBlogs());
	}

	@Override
	public BlogEntryList findAllBlogEntries(Long blogId) {
		Blog blog = blogRepo.findBlog(blogId);
		if (blog == null) {
			throw new BlogNotFoundException();
		}
		return new BlogEntryList(blogId, entryRepo.findByBlogId(blogId));
	}

	@Override
	public Blog findBlog(Long id) {
		return blogRepo.findBlog(id);
	}
}
