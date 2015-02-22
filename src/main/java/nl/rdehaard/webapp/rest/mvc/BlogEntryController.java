package nl.rdehaard.webapp.rest.mvc;

import nl.rdehaard.webapp.core.entities.BlogEntry;
import nl.rdehaard.webapp.core.services.BlogEntryService;
import nl.rdehaard.webapp.rest.BlogEntryResource;
import nl.rdehaard.webapp.rest.resource.asm.BlogEntryResourceAsm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {
	private BlogEntryService service;

	public BlogEntryController(BlogEntryService service) {
		this.service = service;
	}

	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(
			@PathVariable Long blogEntryId) {
		final BlogEntry entry = service.find(blogEntryId);
		if (entry != null) {
			BlogEntryResource res = new BlogEntryResourceAsm()
					.toResource(entry);
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.DELETE)
	public ResponseEntity<BlogEntryResource> deleteBlogEntry(
			@PathVariable Long blogEntryId) {
		final BlogEntry entry = service.delete(blogEntryId);
		if (entry != null) {
			BlogEntryResource res = new BlogEntryResourceAsm()
					.toResource(entry);
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{blogEntryId}", method = RequestMethod.PUT)
	public ResponseEntity<BlogEntryResource> updateBlogEntry(
			@PathVariable Long blogEntryId,
			@RequestBody BlogEntryResource sentBlogEntry) {
		final BlogEntry updatedEntry = service.update(blogEntryId,
				sentBlogEntry.toBlogEntry());
		if (updatedEntry != null) {
			BlogEntryResource res = new BlogEntryResourceAsm()
					.toResource(updatedEntry);
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

}
