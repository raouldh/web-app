package nl.rdehaard.webapp.rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import nl.rdehaard.webapp.core.services.util.BlogEntryList;
import nl.rdehaard.webapp.rest.mvc.BlogController;
import nl.rdehaard.webapp.rest.resource.BlogEntryListResource;
import nl.rdehaard.webapp.rest.resource.BlogEntryResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BlogEntryListResourceAsm extends
		ResourceAssemblerSupport<BlogEntryList, BlogEntryListResource> {
	public BlogEntryListResourceAsm() {
		super(BlogController.class, BlogEntryListResource.class);
	}

	@Override
	public BlogEntryListResource toResource(BlogEntryList list) {
		List<BlogEntryResource> resources = new BlogEntryResourceAsm()
				.toResources(list.getEntries());
		BlogEntryListResource listResource = new BlogEntryListResource();
		listResource.setEntries(resources);
		listResource.add(linkTo(
				methodOn(BlogController.class).findAllBlogEntries(
						list.getBlogId())).withSelfRel());
		return listResource;
	}
}
