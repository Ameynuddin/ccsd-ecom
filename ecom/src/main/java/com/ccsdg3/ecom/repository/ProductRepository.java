package com.ccsdg3.ecom.repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findBySlug(String slug);

    List<Product> findByCategory(String category);

    Optional<Product> findByName(String name);
}