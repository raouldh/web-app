package nl.rdehaard.webapp.rest.resource.asm;

import nl.rdehaard.webapp.core.services.util.BlogList;
import nl.rdehaard.webapp.rest.mvc.BlogController;
import nl.rdehaard.webapp.rest.resource.BlogListResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogListResourceAsm extends
		ResourceAssemblerSupport<BlogList, BlogListResource> {
	public BlogListResourceAsm() {
		super(BlogController.class, BlogListResource.class);
	}

	@Override
	public BlogListResource toResource(BlogList blogList) {
		BlogListResource res = new BlogListResource();
		res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
		return res;
	}
}
