package nl.rdehaard.webapp.core.repositories;

import java.util.List;

import nl.rdehaard.webapp.core.model.entities.Blog;

public interface BlogRepo {
	public Blog createBlog(Blog data);

	public List<Blog> findAllBlogs();

	public Blog findBlog(Long id);

	public Blog findBlogByTitle(String title);

	public List<Blog> findBlogsByAccount(Long accountId);
}