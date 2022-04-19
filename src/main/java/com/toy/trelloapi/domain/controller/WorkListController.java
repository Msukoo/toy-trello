package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.WorkListDto;
import com.toy.trelloapi.domain.service.ListService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
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
        List<WorkListDto> workLists = listService.findAll();
        return ResponseEntity.ok().body(workLists);
    }

    @ApiOperation(value = "WorkList 추가")
    @PostMapping("")
    public ResponseEntity saveWorkList(@RequestBody String workListTitle) throws UnsupportedEncodingException {
        WorkListDto workListDto = listService.saveWorkList(workListTitle);
        return ResponseEntity.ok().body(workListDto);
    }

    @ApiOperation(value = "WorkList 수정")
    @PutMapping("/{workListId}")
    public ResponseEntity updateWorkList(@PathVariable Long workListId, @RequestBody WorkListDto workListDto) throws UnsupportedEncodingException {
        workListDto.setWorkListId(workListId);
        WorkListDto changeWorkList = listService.updateWorkList(workListDto);
        return ResponseEntity.ok().body(changeWorkList);
    }
}
