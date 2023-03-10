package com.mogreene.board.controller;

import com.mogreene.board.common.api.ApiResponseDTO;
import com.mogreene.board.common.status.StatusCode;
import com.mogreene.board.dto.ReplyDTO;
import com.mogreene.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * 댓글 컨트롤러
 * @author mogreene
 */
@Slf4j
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    /**
     * 댓글 등록
     * @param boardNo
     * @param replyDTO
     * @return
     */
    @PostMapping("/notice/reply/{boardNo}")
    public ApiResponseDTO<?> postReply(@PathVariable("boardNo") Long boardNo,
                                            @RequestBody ReplyDTO replyDTO) {

        replyDTO.setBoardNo(boardNo);

        replyService.postReply(replyDTO);

        return ApiResponseDTO.builder()
                .resultType(StatusCode.SUCCESS)
                .httpStatus(HttpStatus.NO_CONTENT)
                .resultCode(HttpStatus.NO_CONTENT.value())
                .resultData("Success")
                .build();
    }
}
