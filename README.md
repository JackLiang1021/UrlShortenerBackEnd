## URL Shortener – Java & Spring Boot Backend

### Overview

This project is a lightweight backend URL shortener service built using **Spring Boot** and **Java**. It was created to support my portfolio by allowing me to share clean, shortened links to my projects on my resume.

### Purpose

When showcasing projects, full-length URLs can clutter a resume or portfolio. This backend service provides a neat solution by generating shortened links under my personal domain, **[jakl.work](https://jakl.work)**. It’s currently backend-only, but frontend integration is planned as part of my personal website.

### Features

* Accepts POST requests with a JSON body containing a URL
* Returns a short code for redirection
* Duplicate URLs return the same code rather than generating a new one
* Custom domain usage: simply access `jakl.work/{code}` to be redirected—no ads, no tracking, just clean redirection
* Backed by **Neon** as the database for storing URLs and shortcodes

### API Usage

**Endpoint**: `POST /`

**Request Body**:

```json
{
  "url": "https://example.com/your-long-link"
}
```

**Response**:

```json
{
    "shortenUrl": "Ef9",
    "originalUrl": "https://example.com/your-long-link"
}
```

**Usage**:
Access `jakl.work/abc` to be redirected to the original link.

### What’s Next?

* Frontend interface as part of my personal portfolio site
* Analytics support for tracking click counts (optional and privacy-focused)
* Admin interface for managing links


**[Link to repo](https://jakl.work/aYu)**
