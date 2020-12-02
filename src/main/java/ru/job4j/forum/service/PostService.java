package ru.job4j.forum.service;

import org.springframework.stereotype.Service;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    
    public Post findById(Integer id) {
    	return this.posts.findById(id).get();
    }
    
    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }
}