package com.doodle.examluis;

import com.doodle.examluis.controller.PollController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableWebMvc
public class ExamLuisApplicationTests {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	public static final String API_POLLS = "/doodlepolls";
	public static final String API_POLLS_ADD_MULTI = "/doodlepolls/addMulti";
	public static final String API_POLLS_FILTER_BY_CREATION_DATE = "/doodlepolls/filterByCreationDate";
	public static final String API_POLLS_TEXT_SEARCH = "/doodlepolls/textSearch";

	@Autowired
	private PollController pollController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders
				.standaloneSetup(pollController)
				.build();
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void itShouldSaveOnePollWithAJsonFile() throws Exception {
		String url = API_POLLS;
		String requestJson = "{ \"id\":\"John\", \"inviteesCount\":30, \"adminKey\":null }";

		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void itShouldSaveMultiPollsWithAJsonFile() throws Exception {
		String url = API_POLLS_ADD_MULTI;
		String requestJson = "[ { \"id\":\"John\", \"inviteesCount\":30, \"adminKey\":null } ]";

		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void itShouldGetAllThePolls() throws Exception {
		mockMvc.perform(get(API_POLLS))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void itShouldGetPollsByCreationDate() throws Exception {
		String url = API_POLLS_FILTER_BY_CREATION_DATE;

		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.param("aCreationDate", "25/01/1979"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void itShouldGetPollsByTextSearch() throws Exception {
		String url = API_POLLS_TEXT_SEARCH;

		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.param("aCriteria", "word1 word2 word3"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@After
	public void itShouldDeleteAll() throws Exception {
		mockMvc.perform(delete(API_POLLS).contentType(APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
}
