package ru.job4j.forum.control;

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
        model.addAttribute("post", service.findById(id));
        return "post";
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
		model.addAttribute("post", service.findById(id));
		return "post/edit";
	}
	
	@PostMapping("/post/save")
    public String save(@ModelAttribute Post post) {
    	service.add(post);
        return "redirect:/post/" + post.getId();
    }
}
