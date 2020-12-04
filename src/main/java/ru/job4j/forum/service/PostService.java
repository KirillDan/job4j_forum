package ru.job4j.forum.service;

import org.springframework.stereotype.Service;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

	private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }
    
    public void add(Post post) {
    	post.setCreated(Calendar.getInstance());
    	this.posts.save(post);
    }
    
    public Post findById(Integer id) throws NullPointerException {
    	Optional<Post> optional = this.posts.findById(id);
    	Post result = null;
    	if (optional.isEmpty()) {
    		throw new NullPointerException("Пользователь с id = " + id + " не найден");
    	} else {
    		result = optional.get();
    	}
    	return result;
    }
    
    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }
}