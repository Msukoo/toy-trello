package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.ChangeOrdInfo;
import com.toy.trelloapi.domain.dto.WorkListRequest;
import com.toy.trelloapi.domain.dto.WorkListResponse;
import com.toy.trelloapi.domain.service.ListService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class WorkListController {
    private final ListService listService;

    @ApiOperation(value = "메인 페이지 workList, card 목록 불러오기")
    @GetMapping("")
    public ResponseEntity findAll(){
        List<WorkListResponse> workLists = listService.findAll();
        return ResponseEntity.ok().body(workLists);
    }

    @ApiOperation(value = "WorkList 추가")
    @PostMapping("")
    public ResponseEntity saveWorkList(@RequestBody WorkListRequest workListRequest) {
        WorkListResponse workListResponse = listService.saveWorkList(workListRequest);
        return ResponseEntity.ok().body(workListResponse);
    }

    @ApiOperation(value = "WorkList 수정")
    @PutMapping("/{workListId}")
    public ResponseEntity updateWorkList(@PathVariable Long workListId, @RequestBody WorkListRequest workListRequest) {
        workListRequest.setWorkListId(workListId);
        WorkListResponse changeWorkList = listService.updateWorkList(workListRequest);
        return ResponseEntity.ok().body(changeWorkList);
    }

    @ApiOperation(value = "WorkList 이동")
    @PutMapping("/move/{workListId}")
    public ResponseEntity moveWorkList(@PathVariable Long workListId, @RequestBody ChangeOrdInfo changeOrdInfo) {
        WorkListResponse workListResponse = listService.moveWorkList(workListId, changeOrdInfo.getRightOrd());
        return ResponseEntity.ok().body(workListResponse);
    }

    @ApiOperation(value = "WorkList 복사")
    @PostMapping("/copy/{workListId}")
    public ResponseEntity copyWorkList(@PathVariable Long workListId, @RequestBody ChangeOrdInfo changeOrdInfo) {
        WorkListResponse workListResponse = listService.copyWorkList(workListId, changeOrdInfo.getRightOrd());
        return ResponseEntity.ok().body(workListResponse);
    }

}
