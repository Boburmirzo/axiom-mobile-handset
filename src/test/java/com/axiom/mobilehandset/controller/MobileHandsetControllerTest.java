package com.axiom.mobilehandset.controller;

import com.axiom.mobilehandset.model.MobileHandset;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MobileHandsetControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void whenGetMobileHandsetsNoFilter_thenReturnMobileHandsets() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/mobile/search"))
				.andDo(print())
				.andExpect(status()
						.isOk())
				.andReturn();

		List<MobileHandset> mobileHandsets =
				objectMapper.readValue(mvcResult.getResponse().getContentAsString(),
						new TypeReference<List<MobileHandset>>() {});

		assertThat(mobileHandsets).isNotEmpty();
	}

}
