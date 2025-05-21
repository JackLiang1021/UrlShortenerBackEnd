package com.jackliang.urlshortener.services;

import com.jackliang.urlshortener.entity.ShortenUrl;
import com.jackliang.urlshortener.repository.ShortenUrlRepository;
import com.jackliang.urlshortener.utils.ShortenUrlGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShorteningService {
    @Autowired
    private ShortenUrlRepository repository;

    public String createUniqueShortCode() {
        String code;
        do {
            code = ShortenUrlGen.generate();
        } while (repository.existsByShortenUrl(code));
        return code;
    }

    public ShortenUrl findByShortenUrl(String shortenUrl) {
        if(repository.findOriginalUrlByShortenUrl(shortenUrl).isPresent()){
            return repository.findOriginalUrlByShortenUrl(shortenUrl).get();
        }
        return null;
    }




    public ShortenUrl saveNewShortUrl(String originalUrl) {
        return repository.findOriginalUrlByOriginalUrl(originalUrl)
                .orElseGet(() -> {
                    String code = createUniqueShortCode();
                    ShortenUrl shortenUrl = new ShortenUrl();
                    shortenUrl.setShortenUrl(code);
                    shortenUrl.setOriginalUrl(originalUrl);
                    return repository.save(shortenUrl);
                });
    }

}
