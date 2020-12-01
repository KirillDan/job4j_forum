package ru.job4j.forum.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

	Optional<Post> findById(Integer id);
}
