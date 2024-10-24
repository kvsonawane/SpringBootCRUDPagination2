package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController 
{
		@Autowired
		private ProductRepository productRepository;
		
		// Display paginated list of products
	    @GetMapping("/")
	    public String viewHomePage(Model model,
	                               @RequestParam(defaultValue = "0") int page,
	                               @RequestParam(defaultValue = "5") int size) {

	        Pageable pageable = PageRequest.of(page, size);
	        Page<Product> productPage = productRepository.findAll(pageable);

	        model.addAttribute("listProducts", productPage.getContent());
	        model.addAttribute("currentPage", page);
	        model.addAttribute("totalPages", productPage.getTotalPages());

	        return "Index";
	    }
	    
		@GetMapping("/insertProduct")
		public String showNewProductForm(Model model) 
		{
			model.addAttribute("product", new Product());
			return "new_product";
		}
		
		@PostMapping("/saveProduct")
		public String saveProduct(@ModelAttribute("product") Product product) 
		{
			productRepository.save(product);
			return "redirect:/";
		}
		
		@GetMapping("/updateProduct/{id}")
		public String showFormForUpdate(@PathVariable(value = "id") int id, Model model)
		{
			Product product = productRepository.findById(id).orElseThrow(() -> new
			IllegalArgumentException("Invalid product Id:" + id));
			model.addAttribute("product", product);
			
			return "update_product";
		}
		
		@GetMapping("/deleteProduct/{id}")
		public String deleteProduct(@PathVariable(value = "id") int id) 
		{
			Product product = productRepository.findById(id).orElseThrow(() -> new
			IllegalArgumentException("Invalid product Id:" + id));
			productRepository.delete(product);
			return "redirect:/";
		}
}

