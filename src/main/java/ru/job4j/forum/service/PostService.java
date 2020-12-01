package ru.job4j.forum.service;

import org.springframework.stereotype.Service;

import ru.job4j.forum.model.Post;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PostService {

    private final HashMap<Integer,Post> posts = new HashMap<Integer,Post>();
    private AtomicInteger ids = new AtomicInteger(0);
    
    public PostService() {
    	int id = this.ids.incrementAndGet();
        posts.put(id, Post.of(id, "Продаю машину ладу 01.", "описание"));
    }
    
    public void add(Post post) {
    	post.setCreated(Calendar.getInstance());
    	if (post.getId() == 0) {
    		int id = this.ids.incrementAndGet();
    		post.setId(id);
    		this.posts.put(id, post);
    	} else {
    		this.posts.put(post.getId(), post);
    	}
    }
    
    public Post findById(Integer id) {
    	return this.posts.get(id);
    }
    
    public List<Post> getAll() {
        return new ArrayList<Post>(posts.values());
    }
}