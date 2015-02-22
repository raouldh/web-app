package nl.rdehaard.webapp.rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import nl.rdehaard.webapp.core.entities.BlogEntry;
import nl.rdehaard.webapp.rest.BlogEntryResource;
import nl.rdehaard.webapp.rest.mvc.BlogEntryController;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryResourceAsm extends
		ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {

	public BlogEntryResourceAsm() {
		super(BlogEntryController.class, BlogEntryResource.class);
	}

	@Override
	public BlogEntryResource toResource(BlogEntry blogEntry) {
		final BlogEntryResource resource = new BlogEntryResource();
		resource.setTitle(blogEntry.getTitle());
		final Link link = linkTo(BlogEntryController.class).slash(
				blogEntry.getId()).withSelfRel();
		resource.add(link);

		return resource;
	}

}
