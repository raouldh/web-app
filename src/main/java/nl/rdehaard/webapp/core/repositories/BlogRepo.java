package nl.rdehaard.webapp.core.repositories;

import java.util.List;

import nl.rdehaard.webapp.core.model.entities.Blog;

public interface BlogRepo {
	Blog createBlog(Blog data);

	List<Blog> findAllBlogs();

	Blog findBlog(Long id);

	Blog findBlogByTitle(String title);

	List<Blog> findBlogsByAccount(Long accountId);
}