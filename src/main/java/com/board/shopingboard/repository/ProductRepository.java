package com.board.shopingboard.repository;

import com.board.shopingboard.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

/*public class ProductRepository{
    private static final Map<Long,Product> store = new HashMap<>();
    private static long sequence =0L;

    public Product save(Product product){
        product.setId(++sequence);

        store.put(product.getId(),product);
        return product;
    }

    public Product findById(Long id){
        return store.get(id);
    }

    public List<Product> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Product updateParam){
        Product findItem = findById(itemId);
        findItem.setProduct_name(updateParam.getProduct_name());
        findItem.setProduct_price(updateParam.getProduct_price());
        findItem.setProduct_stock(updateParam.getProduct_stock());*/
//    }
//}
