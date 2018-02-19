package com.readlearncode.reactiveclient.resource;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Source {

    private String title;
    private String slug;
    private String url;
    private Integer crawl_rate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCrawl_rate() {
        return crawl_rate;
    }

    public void setCrawl_rate(Integer crawl_rate) {
        this.crawl_rate = crawl_rate;
    }

    @Override
    public String toString() {
        return "Source{" +
                "title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", url='" + url + '\'' +
                ", crawl_rate=" + crawl_rate +
                '}';
    }
}