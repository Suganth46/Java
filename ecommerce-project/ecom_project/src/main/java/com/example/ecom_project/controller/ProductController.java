package com.example.ecom_project.controller;

import com.example.ecom_project.model.Product;
import com.example.ecom_project.service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductServices services;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(services.getAllProduct(), HttpStatus.OK);
    }
    @GetMapping("/product/{proId}")
    public ResponseEntity<Product> getProductById(@PathVariable int proId){
        Product product= services.getProductById(proId);
        if(product !=null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
                                        @RequestPart MultipartFile imageFile){
        try{
            System.out.println(product);
            Product pro=services.adProduct(product,imageFile);
            return new ResponseEntity<>(pro,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id){
        Product product= services.getProductById(id);
        byte[] imageFile=product.getImageData();

        return ResponseEntity.ok().body(imageFile);
    }

    @PutMapping("product/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable int id,@RequestPart Product product,
                                               @RequestPart MultipartFile imageFile) throws IOException {
        Product product1= services.updateProductById(id,product,imageFile);

        if (product1!=null)
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        else
            return new ResponseEntity<>("Not Updated",HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id){
     Product product= services.getProductById(id);
     if(product!=null) {
         services.deleteProductById(id);
         return new ResponseEntity<>("Deleted", HttpStatus.OK);
     }
     else
         return new ResponseEntity<>("Failed to Delete",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> products=services.searchProducts(keyword);

        return new ResponseEntity<>(products,HttpStatus.OK);
    }

}
