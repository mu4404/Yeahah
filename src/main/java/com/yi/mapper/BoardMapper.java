package com.yi.mapper;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from member where memberid > 0")
	public List<BoardVO> getList();

	public void insert(BoardVO board);

	public BoardVO read(int memberid);

	public int delete(int memberid);

	public int update(BoardVO board);

	public int getTotalCount(Criteria cri);

	public List<BoardVO> getListWithPaging(Criteria cri);

	public int update2(BoardVO board);

}
