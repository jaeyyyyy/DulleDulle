package com.io.threegonew.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddReviewRequest {
    private Long bookId;
    private String touritemId;
    private String touritemTitle;
    private String reviewContent;
    private List<MultipartFile> photoList;

    @Builder
    public AddReviewRequest(Long bookId, String touritemId,
                            String touritemTitle, String reviewContent,
                            List<MultipartFile> photoList)
    {
        this.bookId = bookId;
        this.touritemId = touritemId;
        this.touritemTitle = touritemTitle;
        this.reviewContent = reviewContent;
        this.photoList = photoList;
    }
}
