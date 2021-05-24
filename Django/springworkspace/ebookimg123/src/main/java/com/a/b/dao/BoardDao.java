package com.a.b.dao;

import java.util.ArrayList;

import com.a.b.dto.Board;

public interface BoardDao {


	public void boardWrite(
			 String bId,
			 String bTitle,
			 String bContent
			);
	
	
	public ArrayList<Board> boardList();
	
	
	public void boardModify(
			final String bBid,
			final String bTitle,
			final String bContent
			);
	
	
	public void boardDelete(final String bBid);
	
	public Board boardContent_view(final String bBid);
	
	public void upHit(final String bBid);
}
