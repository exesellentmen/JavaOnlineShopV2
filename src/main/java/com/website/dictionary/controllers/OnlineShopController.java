package com.website.dictionary.controllers;

import com.website.dictionary.helpers.CollectorProperties;
import com.website.dictionary.helpers.StructureProperty;
import com.website.dictionary.models.Qqproducts;
import com.website.dictionary.models.ShopProducts;
import com.website.dictionary.models.Testq;
import com.website.dictionary.repo.QqproductsRepository;
import com.website.dictionary.repo.ShopProductsRepository;
import com.website.dictionary.repo.TestqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class OnlineShopController {

    @Autowired
    private TestqRepository testqRepository;

    @Autowired
    private QqproductsRepository qqproductsRepository;

    @Autowired
    private ShopProductsRepository shopProductsRepository;





    // {id} - динамический параметр в который передает id страницы
    @GetMapping("/test/{id}/edit")
    public String TestqEdit(@PathVariable(value = "id") int id, Model model){


        if(!testqRepository.existsById(id)){
            return "redirect:/blog";
        }

        // Находим запись в БД по id в таблице postRepository(класс на основе CrudRepository). Также создаем объект на основе класса Optional в скобках указываем модель с которой работаем
        Optional<Testq> post = testqRepository.findById(id);

        //Переводим объект Optional в объект на основе класса ArrayList
        ArrayList<Testq> res = new ArrayList<>();
        //Преобразуем объект post(Optional) в объект res(ArrayList)

        //Добавление данных модели в массив res
        post.ifPresent(res::add);

        // CollectorProperties.collect(Object) - Собираем все свойства и значения и формируем массив объектов для передачи во View
        model.addAttribute("properties", CollectorProperties.collect(res.get(0)));

        //Передаем в шаблон объект post
        model.addAttribute("post", res);

        return "test-edit";
    }






    // {id} - динамический параметр в который передает id страницы
    @GetMapping("/qproducts/{id}/edit")
    public String QproductsEdit(@PathVariable(value = "id") long id, Model model){

        if(!qqproductsRepository.existsById(id)){
            return "redirect:/blog";
        }

        // Находим запись в БД по id в таблице postRepository(класс на основе CrudRepository). Также создаем объект на основе класса Optional в скобках указываем модель с которой работаем
        Optional<Qqproducts> post = qqproductsRepository.findById(id);

        //Преобразуем объект post(Optional) в объект res(ArrayList)
        ArrayList<Qqproducts> res = new ArrayList<>();

        //Добавление данных модели в массив res
        post.ifPresent(res::add);

        // CollectorProperties.collect(Object) - Собираем все свойства и значения и формируем массив объектов для передачи во View
        model.addAttribute("properties", CollectorProperties.collect(res.get(0)));

        //Передаем в шаблон объект post
        model.addAttribute("post", res);

        return "test-edit";
    }










    // Обрабатываем post запросы редактирование записи
    @PostMapping("/qproducts/{id}/edit")
    public String testSecondUpdate(HttpServletRequest request, @PathVariable(value = "id") long id, Model model){

        //Обращаемся к репозитории(хранилищю), ищем нужную запись по id, и выбрасываем исключения если запись была не найдена: .orElseThrow()
        Qqproducts post = qqproductsRepository.findById(id).orElseThrow();

        //Устанавливаем все свойства объекту из Post Запроса
        CollectorProperties.setProperiesFromRequest(post,request);


        //Сохраняет полученные данные из модели post при помощи репозитории и мы обновляем запись а не добавляем
        qqproductsRepository.save(post);
        return "redirect:/qproducts/" + id + "/edit";
    }






    //Пробуем работать со связями в моделях
    // {id} - динамический параметр в который передает id страницы
    @GetMapping("/shop_product/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){


        //Создание ассоциативного массива и передача его в шаблон thymeleaf
        ArrayList<HashMap<String, String>> test = new ArrayList<HashMap<String, String>>();
        test.add(new HashMap<>(Map.of("NAME", "NAME", "VALUE", "Petr","TYPE", "String")));
        test.add(new HashMap<>(Map.of("NAME", "NAME", "VALUE", "Olga","TYPE", "String")));
        model.addAttribute("newArq", test.toArray());


        //Проверка существует ли запись
        if(!shopProductsRepository.existsById(id)){
            return "redirect:/blog";
        }

        // Находим запись в БД по id в таблице postRepository(класс на основе CrudRepository). Также создаем объект на основе класса Optional в скобках указываем модель с которой работаем
        Optional<ShopProducts> shopProducts = shopProductsRepository.findById(id);

        //Переводим объект Optional в объект на основе класса ArrayList
        ArrayList<ShopProducts> res = new ArrayList<>();
        //Преобразуем объект post(Optional) в объект res(ArrayList)
        shopProducts.ifPresent(res::add);


        //Передаем в шаблон объект post
        model.addAttribute("productprop", res);

        return "test-product-edit";
    }














}
