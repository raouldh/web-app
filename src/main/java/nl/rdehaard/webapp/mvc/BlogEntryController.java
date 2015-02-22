package nl.rdehaard.webapp.mvc;

import nl.rdehaard.webapp.entities.BlogEntry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogEntryController {

	@RequestMapping(value="/test", method = RequestMethod.POST)
	public @ResponseBody BlogEntry test(@RequestBody BlogEntry blogEntry) {
			return blogEntry;
	}
}
