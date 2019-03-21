package com.starlabs.rweater.domain;

public class RestExperimental {
    private Long id;
    private String name;
    private Double rite;

    public RestExperimental(){}

    public RestExperimental(long id, String content, Double rite) {
        this.id = id;
        this.name = content;
        this.rite = rite;
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

    public Double getRite() {
        return rite;
    }

    public void setRite(Double rite) {
        this.rite = rite;
    }


}
