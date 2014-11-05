package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring IoC 컨테이너를 구동한다. 
		ApplicationContext container = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring IoC 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. 검색된 객체의 메서드를 테스트한다.
		BoardVO vo = new BoardVO();
		vo.setTitle("JDBC 제목");
		vo.setWriter("채규태");
		vo.setContent("Spring JDBC 내용................");
		boardService.insertBoard(vo);
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}










