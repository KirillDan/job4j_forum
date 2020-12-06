package ru.job4j.forum.control;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
    private PostService posts;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForPost() throws Exception {
    	int id = 0;
    	Mockito.when(this.posts.findById(id)).thenReturn(Optional.of(Post.of("test","test")));
        this.mockMvc.perform(get("/post/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post"));
    }
    
    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForUpdate() throws Exception {
    	int id = 0;
    	Mockito.when(this.posts.findById(id)).thenReturn(Optional.of(Post.of("test","test")));
        this.mockMvc.perform(get("/post/update/" + id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }
    
    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageForCreate() throws Exception {
        this.mockMvc.perform(get("/post/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/edit"));
    }
    
    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/post/save")
                .param("name","Куплю ладу-грант. Дорого."))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(posts).add(argument.capture());
        System.err.println(argument.getValue().getId());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
    }
}
