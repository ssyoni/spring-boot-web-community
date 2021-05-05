package com.web.controller;

import com.web.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/board") // API URL 경로 
public class BoardController {
    
    @Autowired
    BoardService boardService;

    @GetMapping({"","/"}) // 매핑경로를 중괄호 사용으로 여러개 받을 수 있다. 
    public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("board", boardService.findBoardByIndex(idx));
        return "/board/list";
    }

    @GetMapping("/list")
    public String list(@PageableDefault Pageable pageable, Model model){ // @PageableDefault  size, sort, direction 등을 사용하여 페이징 처리에 대한 규약을 정의할 수 있다.
        model.addAttribute("boardList", boardService.findBaordList(pageable));
        return "/board/list"; // src/resource/templates 을 기준으로 데이터를 바인딩할 타깃의 뷰 경로를 지정한다. 
    }
    
}
