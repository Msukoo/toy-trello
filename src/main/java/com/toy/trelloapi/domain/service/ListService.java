package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.CardResponse;
import com.toy.trelloapi.domain.dto.WorkListRequest;
import com.toy.trelloapi.domain.dto.WorkListResponse;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.exception.WorkListNotFoundException;
import com.toy.trelloapi.domain.repository.CardQueryRepository;
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
    private final CardQueryRepository cardQueryRepository;
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
    public WorkListResponse moveWorkList(Long workListId, long rightOrd) {
        Long destinationOrd = findDestinationOrd(rightOrd);
        WorkList workList = workListRepository.findById(workListId)
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));
        workList.changeOrd(destinationOrd, "admin");
        return workList.convertWorkListDto();
    }

    @Transactional
    public WorkListResponse copyWorkList(Long workListId, long rightOrd) {
        LocalDateTime currentDateTime = LocalDateTime.now();

        Long destinationOrd = findDestinationOrd(rightOrd);
        WorkList workList = workListRepository.findById(workListId)
                .orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));

        WorkList copiedWorkList = WorkList.builder()
                .workListTitle(workList.getWorkListTitle())
                .workListOrd(destinationOrd)
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

    private Long findDestinationOrd(long rightOrd) {
        Long leftOrd = workListQueryRepository.findLeftWorkListOrd(rightOrd);
        Long destinationOrd = (rightOrd + leftOrd) / 2 != 0 ? (rightOrd + leftOrd) / 2 : 1L;
        return destinationOrd;
    }
}
