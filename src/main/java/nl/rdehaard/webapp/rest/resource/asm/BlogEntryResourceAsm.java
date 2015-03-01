package nl.rdehaard.webapp.rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import nl.rdehaard.webapp.core.model.entities.BlogEntry;
import nl.rdehaard.webapp.rest.mvc.BlogController;
import nl.rdehaard.webapp.rest.mvc.BlogEntryController;
import nl.rdehaard.webapp.rest.resource.BlogEntryResource;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAsm extends
		ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {
	public BlogEntryResourceAsm() {
		super(BlogEntryController.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		BlogEntryResource res = new BlogEntryResource();
		res.setTitle(blogEntry.getTitle());
		res.setContent(blogEntry.getContent());
		Link self = linkTo(BlogEntryController.class).slash(blogEntry.getId())
				.withSelfRel();
		res.add(self);
		if (blogEntry.getBlog() != null) {
			res.add((linkTo(BlogController.class).slash(
					blogEntry.getBlog().getId()).withRel("blog")));
		}
		return res;
	}
}