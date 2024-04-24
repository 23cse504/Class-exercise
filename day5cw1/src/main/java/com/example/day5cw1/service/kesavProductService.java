package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.kesavProduct;
import com.example.day5cw1.repository.kesavProductRepo;

@Service
public class kesavProductService {
    public kesavProductRepo productRepo;
    public kesavProductService(kesavProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(kesavProduct product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,kesavProduct product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public kesavProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
