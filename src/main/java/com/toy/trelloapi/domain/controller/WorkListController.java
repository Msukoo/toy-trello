package com.toy.trelloapi.domain.controller;

import com.toy.trelloapi.domain.dto.workListDto;
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
    public ResponseEntity saveWorkList(@RequestBody workListDto workListdto){
        WorkList workList = listService.saveWorkList(workListdto.getWorkListTitle());
        return ResponseEntity.ok().body(workList.getWorkListId());
    }
}
