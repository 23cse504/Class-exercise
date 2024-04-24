package com.example.day6cw3.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6cw3.model.kesavProduct;
import com.example.day6cw3.repository.kesavProductRepo;

@Service
public class kesavProductService {
    public kesavProductRepo productRepo;
    public kesavProductService(kesavProductRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean postProduct(kesavProduct product)
    {
        try{

            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<kesavProduct> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<kesavProduct> sortPagination(int offset,int size,String field)
    {
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public kesavProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
