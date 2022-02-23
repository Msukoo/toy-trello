package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.WorkListDto;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.repository.WorkListQueryRepository;
import com.toy.trelloapi.domain.repository.WorkListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ListService {

    private final WorkListRepository workListRepository;
    private final WorkListQueryRepository workListQueryRepository;

    public WorkList saveWorkList(String workListTitle) {

        LocalDateTime currentDateTime = LocalDateTime.now();

       return workListRepository.save(
                WorkList.builder()
                        .workListTitle(workListTitle)
                        .workListOrd(getNextWorkListOrd())
                        .regId("admin")
                        .regDtime(currentDateTime)
                        .useYn(true)
                        .modId("admin")
                        .modDtime(currentDateTime)
                        .build()
        );
    }

    @Transactional
    public void updateWorkList(WorkListDto workListDto) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        WorkList workList = workListRepository.getById(workListDto.getWorkListId());
        workList.changeWorkList(workListDto.getWorkListTitle(), "admin", currentDateTime);
    }

    private Long getNextWorkListOrd(){
        return workListQueryRepository.findLastWorkListOrd() + 1000L;
    }
}
