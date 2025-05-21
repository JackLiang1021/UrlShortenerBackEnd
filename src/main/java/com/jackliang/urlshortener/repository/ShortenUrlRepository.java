package com.jackliang.urlshortener.repository;

import com.jackliang.urlshortener.entity.ShortenUrl;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShortenUrlRepository extends CrudRepository<ShortenUrl, String> {
    boolean existsByShortenUrl(String shortenUrl);
    boolean existsByOriginalUrl(String originalUrl);
    Optional<ShortenUrl> findOriginalUrlByShortenUrl(String shortenUrl);
    Optional<ShortenUrl> findOriginalUrlByOriginalUrl(String originalUrl);
}
