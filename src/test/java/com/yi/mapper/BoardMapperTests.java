package com.yi.mapper;

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
//Java Config
//@ContextConfiguration(classes = {com.yi.config.RootConfig.class})

@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testgetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testInsert() {

		BoardVO board = new BoardVO();
		board.setName("이름");
		board.setAge(1);
		board.setAddress("주소");
		board.setPhoneNo("전화번호");

		mapper.insert(board);

		log.info(board);

		log.info("생성된 회원의 번호: " + board.getMemberid());

	}

	@Test
	public void testRead() {

		List<BoardVO> board = mapper.read("가라");

		log.info(board);
	}

	/*
	 * @Test public void testDelete() {
	 * 
	 * log.info("DELETE COUNT: " + mapper.delete(9)); }
	 */

	@Test
	public void testUpdate() {

		BoardVO board = new BoardVO();

		board.setMemberid(11);
		board.setName("이름");
		board.setAge(30);
		board.setAddress("대구광역시");
		board.setPhoneNo("01055254444");

		int count = mapper.update2(board);
		log.info("UPDATE COUNT: " + count);
	}

}
