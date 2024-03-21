package com.jsp.springboot.product.test.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.product.test.dto.ProductRequest;
import com.jsp.springboot.product.test.exception.ProductNotFoundByIdException;
import com.jsp.springboot.product.test.model.Product;
import com.jsp.springboot.product.test.repository.ProductRepository;
import com.jsp.springboot.product.test.service.ProductService;
import com.jsp.springboot.product.test.utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService{

	//	@Autowired
	private ProductRepository productRepository;
	private ResponseStructure<Product> responseStructure;
	private ResponseStructure<List<Product>> rs;

	public ProductServiceImpl(ProductRepository productRepository,
			ResponseStructure<Product> responseStructure , ResponseStructure<List<Product>> rs) {
		super();
		this.productRepository = productRepository;
		this.responseStructure = responseStructure;
		this.rs = rs;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductRequest product){
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product Data Saved Successfully!!")
				.setData(productRepository.save(mapToProduct(product))));
	}

	private Product mapToProduct(ProductRequest product) {
		return Product.builder().productName(product.getProductName())
				.productPrice(product.getProductPrice()).build();
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId){
		return productRepository.findById(productId).map(product->ResponseEntity.ok(
				responseStructure.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product have been founded Successfully!!")
				.setData(product)))
				.orElseThrow(() -> new ProductNotFoundByIdException("Product Not Found By Id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, ProductRequest productRequest) {
		Product updatedProduct = mapToProduct(productRequest);
		return productRepository.findById(productId).map(exProduct -> {
			updatedProduct.setProductId(exProduct.getProductId());
			exProduct = productRepository.save(updatedProduct);
			return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value()).setMessage("Product Data Updated Successfully!!").setData(updatedProduct));
		}).orElseThrow(() -> new ProductNotFoundByIdException("Product Not Updated"));

	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
		Optional<Product> optional = productRepository.findById(productId);
		return optional.map(product -> {productRepository.delete(product);
		return ResponseEntity.ok(responseStructure.setStatuscode(HttpStatus.OK.value()).setMessage("Product Data Deleted Successfully!!"));
		}).orElse(null);

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProducts() {
		return ResponseEntity.ok(rs.setStatuscode(HttpStatus.OK.value()).setMessage("Product Data Fetched Successfully!!")
				.setData(productRepository.findAll()));
	}
	
	
}
