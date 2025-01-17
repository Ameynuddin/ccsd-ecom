package com.ccsdg3.ecom.service;

@Service
@Slf4j
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Set<String> getAllCategories() {
        return productRepository.findAll().stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }
}
