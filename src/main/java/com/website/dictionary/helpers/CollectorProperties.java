package com.website.dictionary.helpers;

import com.website.dictionary.models.Qqproducts;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class CollectorProperties {

    // Возвращаем свойства объекта в виде объектов(Name, Value, Type )
    public static ArrayList<HashMap<String, String>> collect(Object FromObject){

        ArrayList<HashMap<String, String>> res = new ArrayList<HashMap<String, String>>();

        try {
            //getBeanInfo() метод анализирует все свойства, методы и события объекта res
            BeanInfo entityInfo = Introspector.getBeanInfo(FromObject.getClass());

            //Возвращает ссылки на свойства объекта содержащийся в сущности entityInfo(res.get(0).getClass()) с помощью метода getPropertyDescriptors()
            PropertyDescriptor[] propertyDescriptors = entityInfo.getPropertyDescriptors();
            //Выделяем память для массива, propertyDescriptors.length - количество свойств

            int j = 0;
            //Перебор всех свойств объекта
            for(int i = 0 ; i < propertyDescriptors.length ; i++){

                Object propertyValue = propertyDescriptors[i].getReadMethod().invoke(FromObject);


                if(propertyValue != null){

                    //Если свойство является классом
                    Boolean IsClass = Objects.equals("class",propertyDescriptors[i].getName()),
                            //Если свойство является первичным ключем (id)
                            IsId = Objects.equals("id",propertyDescriptors[i].getName());

                    //Если свойство не является классом и не является первичным ключем
                    if(!IsClass && !IsId){
                        //Добавление элементов в массив {Наименование, тип, значение}

                        String TypeVar = propertyValue.getClass().getSimpleName();
                        if(Objects.equals(propertyDescriptors[i].getName(), "active")){
                            TypeVar = "ActiveType";
                        }

                        res.add(new HashMap<>(Map.of("NAME", propertyDescriptors[i].getName(), "VALUE", propertyValue.toString(),"TYPE", TypeVar)));

                        j++;
                    }

                } else {

                }
            }
        }catch (Exception e){
            //Handle your exception here.
        }
        return res;
        //return resq;
    }

    //Устанавливаем все свойства объекту из Post Запроса
    public static void setProperiesFromRequest(Qqproducts post, HttpServletRequest request) {

        //----------------Перебор сеттеров-------------------
        try {
            BeanInfo entityInfo = Introspector.getBeanInfo(post.getClass());
            PropertyDescriptor[] propertyDescriptors = entityInfo.getPropertyDescriptors();
            int j = 0;
            //Перебор всех свойств объекта
            for(int i = 0 ; i < propertyDescriptors.length ; i++) {

                Object propertyValue = propertyDescriptors[i].getReadMethod().invoke(post);

                String NameProperty = propertyDescriptors[i].getName();

                String TypeProperty = propertyValue.getClass().getSimpleName();

                if (Objects.equals(TypeProperty,"Timestamp")) {
                    try {
                        String stringDate = request.getParameter(NameProperty).replace('T',' ');
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                        //parsing string to date using parse() method
                        Date parsedDate = dateFormat.parse(stringDate);
                        //finally creating a timestamp
                        Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                        propertyDescriptors[i].getWriteMethod().invoke(post, timestamp);
                    } catch (IllegalAccessException ex) {
                        // handle these as appropriate
                    }
                }

                if (Objects.equals(TypeProperty,"String")) {
                    try {
                        propertyDescriptors[i].getWriteMethod().invoke(post, request.getParameter(NameProperty));
                    } catch (IllegalAccessException ex) {
                        // handle these as appropriate
                    }
                }

                //Не является первичным ключем
                Boolean IsId = Objects.equals("id",propertyDescriptors[i].getName());
                if ((Objects.equals(TypeProperty,"Long")) && !IsId) {
                    try {
                        System.out.println(Objects.equals(TypeProperty,"Long"));
                        propertyDescriptors[i].getWriteMethod().invoke(post, Long.parseLong(request.getParameter(NameProperty)) );
                    } catch (IllegalAccessException ex) {
                        // handle these as appropriate
                    }
                }
            }
        }catch (Exception e){
            //Handle your exception here.
        }
    }
}
