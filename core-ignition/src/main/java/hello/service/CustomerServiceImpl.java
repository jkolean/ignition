package hello.service;

import hello.solr.CustomerSolr;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	@Autowired(required = false)
	CustomerIndexService indexService;

	// @PreAuthorize("hasPermission('Customer', 'search')")
	@Override
	public List<CustomerSolr> search(final String searchTerm) {
		log.debug("Search CustomerDocument with search term: {}", searchTerm);
		return indexService.search(searchTerm);
	}

}