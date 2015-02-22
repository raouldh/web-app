package nl.rdehaard.webapp.rest.mvc;

import java.net.URI;

import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.core.model.entities.BlogEntry;
import nl.rdehaard.webapp.core.services.BlogService;
import nl.rdehaard.webapp.core.services.exceptions.BlogNotFoundException;
import nl.rdehaard.webapp.core.services.util.BlogEntryList;
import nl.rdehaard.webapp.core.services.util.BlogList;
import nl.rdehaard.webapp.rest.exceptions.NotFoundException;
import nl.rdehaard.webapp.rest.resource.BlogEntryListResource;
import nl.rdehaard.webapp.rest.resource.BlogEntryResource;
import nl.rdehaard.webapp.rest.resource.BlogListResource;
import nl.rdehaard.webapp.rest.resource.BlogResource;
import nl.rdehaard.webapp.rest.resource.asm.BlogEntryListResourceAsm;
import nl.rdehaard.webapp.rest.resource.asm.BlogEntryResourceAsm;
import nl.rdehaard.webapp.rest.resource.asm.BlogListResourceAsm;
import nl.rdehaard.webapp.rest.resource.asm.BlogResourceAsm;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/blogs")
public class BlogController {
	private BlogService blogService;

	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<BlogListResource> findAllBlogs() {
		BlogList blogList = blogService.findAllBlogs();
		BlogListResource blogListRes = new BlogListResourceAsm()
				.toResource(blogList);
		return new ResponseEntity<BlogListResource>(blogListRes, HttpStatus.OK);
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
	public ResponseEntity<BlogResource> getBlog(@PathVariable Long blogId) {
		Blog blog = blogService.findBlog(blogId);
		BlogResource res = new BlogResourceAsm().toResource(blog);
		return new ResponseEntity<BlogResource>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/{blogId}/blog-entries", method = RequestMethod.POST)
	public ResponseEntity<BlogEntryResource> createBlogEntry(
			@PathVariable Long blogId,
			@RequestBody BlogEntryResource sentBlogEntry) {
		BlogEntry createdBlogEntry = null;
		try {
			createdBlogEntry = blogService.createBlogEntry(blogId,
					sentBlogEntry.toBlogEntry());
			BlogEntryResource createdResource = new BlogEntryResourceAsm()
					.toResource(createdBlogEntry);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create(createdResource.getLink("self")
					.getHref()));
			return new ResponseEntity<BlogEntryResource>(createdResource,
					headers, HttpStatus.CREATED);
		} catch (BlogNotFoundException e) {
			throw new NotFoundException(e);
		}
	}

	@RequestMapping(value = "/{blogId}/blog-entries")
	public ResponseEntity<BlogEntryListResource> findAllBlogEntries(
			@PathVariable Long blogId) {
		try {
			BlogEntryList list = blogService.findAllBlogEntries(blogId);
			BlogEntryListResource res = new BlogEntryListResourceAsm()
					.toResource(list);
			return new ResponseEntity<BlogEntryListResource>(res, HttpStatus.OK);
		} catch (BlogNotFoundException exception) {
			throw new NotFoundException(exception);
		}
	}
}
