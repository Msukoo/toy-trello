package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.WorkListDto;
import com.toy.trelloapi.domain.entity.WorkList;
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
        List<WorkListDto> workLists = listService.findAll();
        return ResponseEntity.ok().body(workLists);
    }

    @ApiOperation(value = "")
    @PostMapping("")
    public ResponseEntity saveWorkList(@RequestBody String workListTitle){
        WorkListDto workListDto = listService.saveWorkList(workListTitle);
        return ResponseEntity.ok().body(workListDto);
    }

    @ApiOperation(value = "")
    @PutMapping("/{workListId}")
    public ResponseEntity updateWorkList(@PathVariable Long workListId, @RequestBody WorkListDto workListDto){
        workListDto.setWorkListId(workListId);
        listService.updateWorkList(workListDto); // 쿼리가 두번씩 날려짐...
        return ResponseEntity.ok().body(workListId);
    }
}
