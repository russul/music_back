package com.example.music.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "music_info")
@Data
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true,unique = true)
    private String name;
    private String url;
    private Integer compose_way;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCompose_way() {
        return compose_way;
    }

    public void setCompose_way(Integer compose_way) {
        this.compose_way = compose_way;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
