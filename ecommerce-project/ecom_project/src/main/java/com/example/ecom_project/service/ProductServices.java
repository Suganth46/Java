package com.example.ecom_project.service;

import com.example.ecom_project.model.Product;
import com.example.ecom_project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProductServices {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProduct() {
       return repo.findAll();
    }


    public Product getProductById(int proId) {
        return repo.findById(proId).orElse(null);
    }

    public Product addProduct(Product pro, MultipartFile imageFile) throws IOException {
        pro.setImageName(imageFile.getOriginalFilename());
        pro.setImageType(imageFile.getContentType());
        pro.setImageData(imageFile.getBytes());
       return repo.save(pro);
    }


    public Product updateProductById(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        return repo.save(product);
    }

    public void deleteProductById(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }


}
