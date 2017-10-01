package com.unjlams.Pojo;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * Created by UnjlAms on 2017/8/28.
 */
public class Person implements Serializable{
    private String username;
    private MultipartFile image;

    public Person() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getImage() {

        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
