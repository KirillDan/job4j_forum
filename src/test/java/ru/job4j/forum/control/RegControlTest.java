package ru.job4j.forum.control;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import ru.job4j.forum.Main;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

@AutoConfigureMockMvc
@SpringBootTest(classes = Main.class)
public class RegControlTest {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserRepository repository;
	@MockBean
	private AuthorityRepository authorities;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/registration"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("reg"));
	}
	
//	@Test
//    public void shouldReturnDefaultMessagePostMethod() throws Exception {
//		Mockito.when(authorities.findByAuthority("ROLE_USER")).thenReturn(Authority.of(1, "ROLE_USER"));
//		String password = UUID.randomUUID().toString();
//		String username = UUID.randomUUID().toString();
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("username",username);
//		params.add("password",password);
//        this.mockMvc.perform(post("/registration")
//                .params(params))
//                .andDo(print())
//                .andExpect(status().is3xxRedirection());
//        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
//        verify(repository).save(argument.capture());
//        assertThat(argument.getValue().getUsername(), is(username));
//        assertTrue(passwordEncoder.matches(password, argument.getValue().getPassword()));
//    }
}
