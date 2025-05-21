package com.jackliang.urlshortener.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ShortenUrl {
    @Id
    private String shortenUrl;
    private String originalUrl;


    public void setShortenUrl(String shortenUrl) {
        this.shortenUrl = shortenUrl;
    }

    public String getShortenUrl() {
        return this.shortenUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getOriginalUrl() {
        return this.originalUrl;
    }
}
