package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {

		log.info("register......" + board);

		mapper.insert(board);
	}

	@Override
	public List<BoardVO> get(String name) {

		log.info("get......." + name);

		return mapper.read(name);
	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify........" + board);

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int memberid) {
		// TODO Auto-generated method stub
		log.info("remove......" + memberid);

		return mapper.delete(memberid) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated
		log.info("get List With name: ");

		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get list With criteria: " + cri);

		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get total count");

		return mapper.getTotalCount(cri);
	}

}
