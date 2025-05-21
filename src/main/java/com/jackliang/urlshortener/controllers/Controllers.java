package com.jackliang.urlshortener.controllers;

import com.jackliang.urlshortener.entity.ShortenUrl;
import com.jackliang.urlshortener.objects.UrlRequest;
import com.jackliang.urlshortener.repository.ShortenUrlRepository;
import com.jackliang.urlshortener.services.UrlShorteningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/")
public class Controllers {

    @Autowired
    private UrlShorteningService urlShorteningService;


    @PostMapping("/create")
    public ShortenUrl create(@RequestBody UrlRequest request) {
        return urlShorteningService.saveNewShortUrl(request.getUrl());
    }

    @GetMapping("/{shortcode}")
    public RedirectView get(@PathVariable("shortcode") String shortcode) {
        ShortenUrl result = urlShorteningService.findByShortenUrl(shortcode);
        if (result == null) {
            return new RedirectView("/404");
        }
        String originalUrl = result.getOriginalUrl();
        if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
            originalUrl = "https://" + originalUrl;
        }
        return new RedirectView(originalUrl);
    }

}
