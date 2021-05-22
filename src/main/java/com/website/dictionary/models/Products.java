package com.website.dictionary.models;

import org.hibernate.type.BlobType;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.awt.*;
import java.sql.Blob;
import java.util.Date;

//Аннотация Entity отвечает за табличку в БД и создает нам ее если ее нет при первом запуске
@Entity
public class Products {

    // Добавляем аннотацию именно из библиотеки javax.persistence.Id, которая и определяет уникальный id
    @Id
    // Аннотация позволяет автоматически генерировать новые число
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    //Аннотации @Column(columnDefinition = "text") позволяет сделать тип поля text
    @Column(columnDefinition = "text")
    private String NAME, PREVIEW_TEXT, DETAIL_TEXT;

    @Temporal(TemporalType.TIMESTAMP)
    private Date TIMESTAMP_X, MODIFIED_BY, DATE_CREATE;

    private Character ACTIVE;


    private Long SORT;







}
