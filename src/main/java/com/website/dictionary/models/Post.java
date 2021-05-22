package com.website.dictionary.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Аннотация Entity отвечает за табличку в БД и создает нам ее если ее нет при первом запуске
@Entity
public class Post {

    // Добавляем аннотацию именно из библиотеки javax.persistence.Id, которая и определяет уникальный id
    @Id
    // Аннотация позволяет автоматически генерировать новые число
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    // Можно прописывать сразу несколько полей одного типа через запятую
    private String TITLE, ANONS, FULL_TEXT;

    private int VIEWS;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getANONS() {
        return ANONS;
    }

    public void setANONS(String ANONS) {
        this.ANONS = ANONS;
    }

    public String getFULL_TEXT() {
        return FULL_TEXT;
    }

    public void setFULL_TEXT(String FULL_TEXT) {
        this.FULL_TEXT = FULL_TEXT;
    }

    public int getVIEWS() {
        return VIEWS;
    }

    public void setVIEWS(int VIEWS) {
        this.VIEWS = VIEWS;
    }


    public Post() {
    }

    public Post(String TITLE, String ANONS, String FULL_TEXT) {
        this.TITLE = TITLE;
        this.ANONS = ANONS;
        this.FULL_TEXT = FULL_TEXT;
    }
}
