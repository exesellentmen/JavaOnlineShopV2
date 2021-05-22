package com.website.dictionary.repo;

import com.website.dictionary.models.Post;
import org.springframework.data.repository.CrudRepository;

// Добавляем extends CrudRepository и подключаем библиотеку, данный класс позволяет нам использовать стандартные функции добавить удалить запись и т д. Также в <Название таблицы, тип переменной уникального идентификатора>, также не забываем что должен подключиться класс import com.website.dictionary.models.Post;
public interface PostRepository extends CrudRepository<Post, Long> {

}
