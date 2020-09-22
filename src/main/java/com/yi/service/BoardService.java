package com.yi.service;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardService {

	public void register(BoardVO board);

	public BoardVO get(int memberid);

	public boolean modify(BoardVO boardVO);

	public boolean remove(int memberid);

	public List<BoardVO> getList();

	public List<BoardVO> getList(Criteria cri);

	public int getTotal(Criteria cri);

}
