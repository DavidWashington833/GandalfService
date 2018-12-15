package com.gandalf.DAO;

import com.gandalf.DTO.ProductDTO;
import com.gandalf.models.Product;
import java.util.List;
import org.hibernate.criterion.Restrictions;

public class ProductDAO extends DAO {

    public List<Product> get() {
        return session.createCriteria(Product.class).list();
    }

    public Product get(int id) {
        return (Product) session.get(Product.class, id);
    }

    public List<Product> getForCategoria(int id) {
        return session
                .createCriteria(Product.class)
                .add(Restrictions.eq("category.id", id))
                .list();
    }

    public List<Product> like(String nomeProduto) {
        return session
                .createCriteria(Product.class)
                .add(Restrictions
                        .like("nameProduct", "%" + nomeProduto + "%"))
                .list();
    }

    public ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.id = product.getIdProduct();
        productDTO.name = product.getNameProduct();
        productDTO.price = product.getPriceProduct();
        productDTO.discount = product.getDiscountProduct();
        productDTO.stock = product.getStockProduct();
        productDTO.description = product.getDescriptionProduct();
        productDTO.active = product.getActiveProduct();
        productDTO.image = product.getImageProduct();
        return productDTO;
    }
}
