package hello.service;

import java.util.List;

import hello.solr.ProductSolr;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	/**
	 * Searches the products for the given search term.
	 * 
	 * @param searchTerm
	 * @return The list of product documents. If no matches are not found, the
	 *         method returns an empty list.
	 */
	public List<ProductSolr> search(String searchTerm);

}