package nl.rdehaard.webapp.core.services.impl;

import nl.rdehaard.webapp.core.model.entities.BlogEntry;
import nl.rdehaard.webapp.core.repositories.BlogEntryRepo;
import nl.rdehaard.webapp.core.services.BlogEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {
	@Autowired
	private BlogEntryRepo entryRepo;

	@Override
	public BlogEntry findBlogEntry(Long id) {
		return entryRepo.findBlogEntry(id);
	}

	@Override
	public BlogEntry deleteBlogEntry(Long id) {
		return entryRepo.deleteBlogEntry(id);
	}

	@Override
	public BlogEntry updateBlogEntry(Long id, BlogEntry data) {
		return entryRepo.updateBlogEntry(id, data);
	}
}