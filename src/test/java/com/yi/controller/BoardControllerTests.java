package com.yi.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

@WebAppConfiguration

@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })

@Log4j

public class BoardControllerTests {

	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testGet() throws Exception {

		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("name", "이창민")).andReturn()
				.getModelAndView().getModelMap());
	}

	@Test
	public void testList() throws Exception {

		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}

	//@Test
	public void testRegister() throws Exception {

		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("name", "새글 제목")
				.param("age", "23").param("address", "asdf").param("phoneNo", "1234")).andReturn().getModelAndView()
				.getViewName();

		log.info(resultPage);

	}

	

	//@Test
	public void testModify() throws Exception {

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify").param("memberid", "11").param("name2", "수정된 새글 제목")
						.param("age", "22").param("address", "fffff").param("phoneNo", "1111").param("name", "새로 작성하는 글"))
				.andReturn().getModelAndView().getViewName();

		log.info(resultPage);

	}

	//@Test
	public void testRemove() throws Exception {
		// 삭제전 데이터베이스에 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("memberid", "16")).andReturn()
				.getModelAndView().getViewName();

		log.info(resultPage);
	}

	//@Test
	public void testListPaging() throws Exception {

		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list").param("pageStart", "1").param("perPageNum", "10"))
				.andReturn().getModelAndView().getModelMap());
	}

}
