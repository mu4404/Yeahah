package com.yi.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	// @Test
	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {

		BoardVO board = new BoardVO();

		board.setName("새로 작성하는 글");
		board.setAge(2);
		board.setAddress("newbie");
		board.setPhoneNo("212356489");

		service.register(board);

		// log.info("생성된 게시물의 번호: " + board.getMemberid());
	}

	@Test
	public void testGetList() {

		service.getList().forEach(board -> log.info(board));
		// service.getList(new Criteria(2, 10)).forEach(board -> log.info(board));
	}

	/*
	 * @Test public void testDelete() {
	 * 
	 * log.info("Remove Result: " + service.remove(10)); }
	 */

	@Test
	public void testUpdate() {

		BoardVO board = service.get(1);

		if (board == null) {
			return;
		}
		board.setName("제목 수정합니다.");
		log.info("MODIFY RESULT: " + service.modify(board));

		}

	}


