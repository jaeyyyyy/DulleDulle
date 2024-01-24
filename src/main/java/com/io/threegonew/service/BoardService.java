package com.io.threegonew.service;

import com.io.threegonew.domain.Board;
import com.io.threegonew.dto.AddBoardRequest;
import com.io.threegonew.dto.UpdateBoardRequest;
import com.io.threegonew.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    // 게시판 글 추가
    public Board save(AddBoardRequest request) {
        return boardRepository.save(request.toEntity());
    }

    // 게시판 글 전체 조회(최신순 조회)
    public List<Board> findAll() {
        return boardRepository.findAll(Sort.by("bpostdate").descending());
    }

//    // 게시판 글 추천순 조회
//    public List<Board> findAllLikes() {
//        return boardRepository.findAll(Sort.by("likes").descending());
//    }
//
//    // 게시판 글 조회순 조회
//    public List<Board> findAllViews() {
//        return boardRepository.findAll(Sort.by("visitCount").descending());
//    }

    // 글 아이디로 조회하기
    public Board findById(Long bid) {
        return boardRepository.findById(bid)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + bid));
    }

    // 게시판 글 삭제
    public void delete(Long bid) {
        boardRepository.deleteById(bid);
    }

    // 조회수 증가시키기
    @Transactional
    public void updateVisit(Long bid) {
        Board board = boardRepository.findById(bid).orElseThrow(() ->
                new IllegalArgumentException("not found : " + bid));
        board.updateVisitCount(board.getBvisitcount() + 1);
    }


    // 게시글 업데이트
    @Transactional
    public Board update(Long bid, UpdateBoardRequest request) {
        Board board = boardRepository.findById(bid).orElseThrow(() ->
                new IllegalArgumentException("not found : " + bid));


        board.update(request.getBtitle(), request.getBcontent());

        return board;
    }
}
