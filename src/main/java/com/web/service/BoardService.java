package com.web.service;

import com.web.domain.Board;
import com.web.repository.BoardRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
/*
게시판의 리스트와 폼을 찾아주며 핵심 로직을 담당하는 서비스 
*/
@Service
public class BoardService {
    
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public Page<Board> findBaordList(Pageable pageable){
        /*
        pageable 로 넘어온 pageNumber 객체가 0 이하일 때 0으로 최기화. 기본 페이지 크기인 10으로 새로운 PageRequest 객체를 만들어 페이징 처리된 게시글 리스트 반환 
        */
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());

        return boardRepository.findAll(pageable);
    }

    public Board findBoardByIndex(Long idx){
        return boardRepository.findById(idx).orElse(new Board()); // board의 idx 값을 사용하여 board 객체 반환 
    }
}
