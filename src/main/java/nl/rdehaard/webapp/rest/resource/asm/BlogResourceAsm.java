package nl.rdehaard.webapp.rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.rest.mvc.AccountController;
import nl.rdehaard.webapp.rest.mvc.BlogController;
import nl.rdehaard.webapp.rest.resource.BlogResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogResourceAsm extends
		ResourceAssemblerSupport<Blog, BlogResource> {
	public BlogResourceAsm() {
		super(BlogController.class, BlogResource.class);
	}

	@Override
	public BlogResource toResource(Blog blog) {
		BlogResource resource = new BlogResource();
		resource.setTitle(blog.getTitle());
		resource.add(linkTo(BlogController.class).slash(blog.getId())
				.withSelfRel());
		resource.add(linkTo(BlogController.class).slash(blog.getId())
				.slash("blog-entries").withRel("entries"));
		if (blog.getOwner() != null)
			resource.add(linkTo(AccountController.class).slash(
					blog.getOwner().getId()).withRel("owner"));
		return resource;
	}
}