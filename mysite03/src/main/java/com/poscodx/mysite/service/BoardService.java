package com.poscodx.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscodx.mysite.repository.BoardRepository;
import com.poscodx.mysite.repository.GuestbookRepository;
import com.poscodx.mysite.repository.UserRepository;
import com.poscodx.mysite.vo.BoardVo;
import com.poscodx.mysite.vo.GuestbookVo;
import com.poscodx.mysite.vo.UserVo;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	// singletone을 위해, 따로 new 를 하지 않고, 해당 container 내에서 사용할 수 있는 repository 객체를 생성

	public List<BoardVo> getBoardList(int page, int limit) {
		return boardRepository.findAll(page, limit);
	}

	public Boolean deleteContents(Long no) {
		return boardRepository.deleteByNo(no);
	}

	public Boolean addContents(BoardVo vo) {
		return boardRepository.insert(vo);
	}

}
