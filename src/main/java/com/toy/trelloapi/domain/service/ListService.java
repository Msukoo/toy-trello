package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.CardResponse;
import com.toy.trelloapi.domain.dto.SwapRequest;
import com.toy.trelloapi.domain.dto.WorkListRequest;
import com.toy.trelloapi.domain.dto.WorkListResponse;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.exception.WorkListNotFoundException;
import com.toy.trelloapi.domain.repository.WorkListQueryRepository;
import com.toy.trelloapi.domain.repository.WorkListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListService {

    private final WorkListRepository workListRepository;
    private final WorkListQueryRepository workListQueryRepository;

    public WorkListResponse saveWorkList(WorkListRequest workListRequest) {

        LocalDateTime currentDateTime = LocalDateTime.now();

        return workListRepository.save(
                WorkList.builder()
                        .workListTitle(workListRequest.getWorkListTitle())
                        .workListOrd(getNextWorkListOrd())
                        .regId("admin")
                        .regDtime(currentDateTime)
                        .useYn(true)
                        .modId("admin")
                        .modDtime(currentDateTime)
                        .build()
        ).convertWorkListDto();
    }

    @Transactional
    public WorkListResponse updateWorkList(WorkListRequest workListRequest) {
        WorkList workList = workListRepository.findById(workListRequest.getWorkListId())
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));
        workList.changeWorkList(workListRequest, "admin");
        return workList.convertWorkListDto();
    }

    private Long getNextWorkListOrd() {
        return workListQueryRepository.findLastWorkListOrd() + 1000L;
    }

    @Transactional
    public List<WorkListResponse> findAll() {
        List<WorkList> workLists = workListRepository.findAllByUseYnEqualsOrderByWorkListOrd(true);

        return workLists.stream()
                .map(x -> {
                    List<Card> cardList = x.getCard();
                    List<CardResponse> cardResponseList = cardList.stream()
                            .map(y -> y.convertCardDto())
                            .collect(Collectors.toList());
                    WorkListResponse workListResponse = x.convertWorkListDto();
                    workListResponse.setCardList(cardResponseList);
                    return workListResponse;
                })
                .collect(Collectors.toList());
    }

    @Transactional
    public WorkListResponse moveWorkList(Long workListId, long newOrder) {
        WorkList workList = workListRepository.findById(workListId)
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));
        workList.changeOrd(newOrder, "admin");
        return workList.convertWorkListDto();
    }

    @Transactional
    public WorkListResponse copyWorkList(Long workListId, long newOrder) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        WorkList workList = workListRepository.findById(workListId)
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));
        WorkList copiedWorkList = WorkList.builder()
                .workListTitle(workList.getWorkListTitle())
                .workListOrd(newOrder)
                .regId("admin")
                .regDtime(currentDateTime)
                .useYn(true)
                .modId("admin")
                .modDtime(currentDateTime)
                .build();

        List<Card> cards = workList
                .getCard()
                .stream()
                .map(c ->
                          Card.builder()
                              .cardTitle(c.getCardTitle())
                              .cardDesc(c.getCardDesc())
                              .cardOrd(c.getCardOrd())
                              .regId("admin")
                              .regDtime(currentDateTime)
                              .modId("admin")
                              .modDtime(currentDateTime)
                              .workList(copiedWorkList)
                              .useYn(true)
                              .build()
                ).collect(Collectors.toList());

        copiedWorkList.setCard(cards);

        return workListRepository.save(copiedWorkList).convertWorkListDto();
    }

    @Transactional
    public void swapWorkList(SwapRequest swapRequest) {
        WorkList workList1 = workListRepository.findById(swapRequest.getWorkListId1())
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));
        WorkList workList2 = workListRepository.findById(swapRequest.getWorkListId2())
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));

        Long sort1 = workList1.getWorkListOrd();
        Long sort2 = workList2.getWorkListOrd();
        workList1.swapWorkListOrd(sort2);
        workList2.swapWorkListOrd(sort1);
    }

    private Long findDestinationOrd(long rightOrd) {
        Long leftOrd = workListQueryRepository.findLeftWorkListOrd(rightOrd);
        Long destinationOrd = (rightOrd + leftOrd) / 2 != 0 ? (rightOrd + leftOrd) / 2 : 1L;
        return destinationOrd;
    }


}
