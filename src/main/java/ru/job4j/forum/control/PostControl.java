package ru.job4j.forum.control;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
	private PostService service;

	public PostControl(PostService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/post/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
		String result = "redirect:/index";
		Optional<Post> optional = service.findById(id);
		if (optional.isPresent()) {
			result = "post";
			model.addAttribute("post", optional.get());
		}
        return result;
    }
	
	@GetMapping("/post/create")
	public String create(Model model) {
		Post post = new Post();
		post.setId(0);
		model.addAttribute("post", post);
		return "post/edit";
	}
	
	@GetMapping("/post/update/{id}")
	public String update(@PathVariable int id, Model model) {
        String result = "redirect:/index";
		Optional<Post> optional = service.findById(id);
		if (optional.isPresent()) {
			result = "post/edit";
			model.addAttribute("post", optional.get());
		}
        return result; 
	}
	
	@PostMapping("/post/save")
    public String save(@ModelAttribute Post post) {
    	service.add(post);
        return "redirect:/post/" + post.getId();
    }
}
