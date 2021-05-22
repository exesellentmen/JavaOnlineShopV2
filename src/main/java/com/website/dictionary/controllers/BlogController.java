package com.website.dictionary.controllers;

import com.website.dictionary.models.Post;
import com.website.dictionary.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {

    // Аннотация @Autowired необходима для ссылки на репозиторию
    @Autowired
    private PostRepository postRepository;


    @GetMapping("/blog")
    public String blogMain(Model model){

        //Массив данных, в котором будут содержаться все значения из БД
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);


        return "blog-main";
    }


    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    // Обрабатываем post запросы
    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        //Сохраняет полученные данные из модели post при помощи репозитории
        postRepository.save(post);
        return "redirect:/blog";
    }

    // {id} - динамический параметр в который передает id страницы
    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){

        //Проверка существует ли запись
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }

        // Находим запись в БД по id в таблице postRepository(класс на основе CrudRepository). Также создаем объект на основе класса Optional в скобках указываем модель с которой работаем
        Optional<Post> post = postRepository.findById(id);

        //Переводим объект Optional в объект на основе класса ArrayList
        ArrayList<Post> res = new ArrayList<>();
        //Преобразуем объект post(Optional) в объект res(ArrayList)
        post.ifPresent(res::add);


        //Передаем в шаблон объект post
        model.addAttribute("post", res);

        return "blog-details";
    }




    // {id} - динамический параметр в который передает id страницы
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){

        //Проверка существует ли запись
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }

        // Находим запись в БД по id в таблице postRepository(класс на основе CrudRepository). Также создаем объект на основе класса Optional в скобках указываем модель с которой работаем
        Optional<Post> post = postRepository.findById(id);

        //Переводим объект Optional в объект на основе класса ArrayList
        ArrayList<Post> res = new ArrayList<>();
        //Преобразуем объект post(Optional) в объект res(ArrayList)
        post.ifPresent(res::add);


        //Передаем в шаблон объект post
        model.addAttribute("post", res);

        return "blog-edit";
    }

    // Обрабатываем post запросы редактирование записи
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){

        //Обращаемся к репозитории(хранилищю), ищем нужную запись по id, и выбрасываем исключения если запись была не найдена: .orElseThrow()
        Post post = postRepository.findById(id).orElseThrow();
        post.setTITLE(title);
        post.setANONS(anons);
        post.setFULL_TEXT(full_text);

        //Сохраняет полученные данные из модели post при помощи репозитории и мы обновляем запись а не добавляем
        postRepository.save(post);
        return "redirect:/blog";
    }

    // Обрабатываем post запросы удаление записи
    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){

        //Обращаемся к репозитории(хранилищю), ищем нужную запись по id, и выбрасываем исключения если запись была не найдена: .orElseThrow()
        Post post = postRepository.findById(id).orElseThrow();

        //Удаляем определенную запись
        postRepository.delete(post);

        return "redirect:/blog";
    }





//
//    @Autowired
//    private TestRepository testRepository;
//
//    // {id} - динамический параметр в который передает id страницы
//    @GetMapping("/test/{id}/edit")
//    public String testSecondEdit(@PathVariable(value = "id") long id, Model model){
//
//        //Проверка существует ли запись
//        if(!testRepository.existsById(id)){
//            return "redirect:/blog";
//        }
//
//        // Находим запись в БД по id в таблице postRepository(класс на основе CrudRepository). Также создаем объект на основе класса Optional в скобках указываем модель с которой работаем
//        Optional<TestqSecond> post = testRepository.findById(id);
//
//        //Переводим объект Optional в объект на основе класса ArrayList
//        ArrayList<TestqSecond> res = new ArrayList<>();
//        //Преобразуем объект post(Optional) в объект res(ArrayList)
//        post.ifPresent(res::add);
//
//
//        //Передаем в шаблон объект post
//        model.addAttribute("post", res);
//
//        return "test-edit";
//    }
//
//    // Обрабатываем post запросы редактирование записи
//    @PostMapping("/test/{id}/edit")
//    public String testSecondUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
//
//        //Обращаемся к репозитории(хранилищю), ищем нужную запись по id, и выбрасываем исключения если запись была не найдена: .orElseThrow()
//
//        TestqSecond post = testRepository.findById(id).orElseThrow();
//
//        post.setName(title);
//
//        //Сохраняет полученные данные из модели post при помощи репозитории и мы обновляем запись а не добавляем
//        testRepository.save(post);
//        return "redirect:/blog";
//    }






}
