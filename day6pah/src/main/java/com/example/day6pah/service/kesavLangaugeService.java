package com.example.day6pah.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day6pah.model.kesavLanguage;
import com.example.day6pah.repository.kesavLanguageRepo;

@Service
public class kesavLangaugeService {
    public kesavLanguageRepo languageRepo;
    public kesavLangaugeService(kesavLanguageRepo languageRepo)
    {
        this.languageRepo = languageRepo;
    }
    public boolean postLanguage(kesavLanguage language)
    {
        try{

            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<kesavLanguage> getSortedLanguages(String field)
    {
        return languageRepo.findAll(Sort.by(field));
    }
    public List<kesavLanguage> getPaginationLanguages(int offset,int size)
    {
        return languageRepo.findAll(PageRequest.of(offset, size)).getContent();
        // return childrenRepo.findAll(Pageable.ofSize(size).withPage(offset)).getContent();
                        
    }
    public List<kesavLanguage> getSortedPaginationLanguages(int offset,int size,String field)
    {
        return languageRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
}
