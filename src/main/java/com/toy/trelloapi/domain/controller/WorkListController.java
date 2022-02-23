package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.WorkListDto;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class WorkListController {
    private final ListService listService;

    @PostMapping("")
    public ResponseEntity saveWorkList(@RequestBody String workListTitle){
        WorkList workList = listService.saveWorkList(workListTitle);
        return ResponseEntity.ok().body(workList.getWorkListId());
    }

    @PutMapping("/{workListId}")
    public ResponseEntity updateWorkList(@PathVariable Long workListId, @RequestBody WorkListDto workListDto){
        workListDto.setWorkListId(workListId);
        listService.updateWorkList(workListDto); // 쿼리가 두번씩 날려짐...
        return ResponseEntity.ok().body(workListId);
    }
}
