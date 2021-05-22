package com.website.dictionary.repo;

import com.website.dictionary.models.ShopProducts;
import org.springframework.data.repository.CrudRepository;

public interface ShopProductsRepository extends CrudRepository<ShopProducts, Long> {
}
