package com.io.threegonew.controller;

import com.io.threegonew.domain.Planner;
import com.io.threegonew.domain.ReviewBook;
import com.io.threegonew.domain.TourItem;
import com.io.threegonew.domain.User;
import com.io.threegonew.dto.AddReviewBookRequest;
import com.io.threegonew.service.PlannerService;
import com.io.threegonew.service.ReviewBookService;
import com.io.threegonew.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class ReviewBookController {
    private final UserService userService;
    private final PlannerService plannerService;
    private final ReviewBookService reviewBookService;

//    @PostMapping("/create")
//    @ResponseBody
//    public ResponseEntity<Long> saveReviewBook(@ModelAttribute AddReviewBookRequest request) {
//        try {
//            User author = userService.findUser(request.getUserId());
//            Planner selectedPlanner = plannerService.findPlanner(request.getPlannerId());
//
//            ReviewBook reviewBook = reviewBookService.createReviewBook(author,selectedPlanner,request);
//
//            return ResponseEntity.ok().body(reviewBook.getBookId());
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
