package com.benznestdeveloper.blognonestory;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table BLOGNONE_TAGS.
 */
public class BlognoneTags {

    private Long id;
    private String name;
    private String icon;
    private Boolean favorite;
    private String endpoint;

    public BlognoneTags() {
    }

    public BlognoneTags(Long id) {
        this.id = id;
    }

    public BlognoneTags(Long id, String name, String icon, Boolean favorite, String endpoint) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.favorite = favorite;
        this.endpoint = endpoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}