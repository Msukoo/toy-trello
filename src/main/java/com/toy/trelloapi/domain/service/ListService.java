package com.toy.trelloapi.domain.service;

import com.toy.trelloapi.domain.dto.CardDto;
import com.toy.trelloapi.domain.dto.WorkListDto;
import com.toy.trelloapi.domain.entity.Card;
import com.toy.trelloapi.domain.entity.WorkList;
import com.toy.trelloapi.domain.exception.WorkListNotFoundException;
import com.toy.trelloapi.domain.repository.WorkListQueryRepository;
import com.toy.trelloapi.domain.repository.WorkListRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListService {

    private final WorkListRepository workListRepository;
    private final WorkListQueryRepository workListQueryRepository;
    private final ModelMapper modelMapper;

    public WorkListDto saveWorkList(String workListTitle) throws UnsupportedEncodingException {

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
        ).convertWorkListDto();
    }

    @Transactional
    public void updateWorkList(WorkListDto workListDto) throws UnsupportedEncodingException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        Optional<WorkList> optWorkList = workListRepository.findByWorkListId(workListDto.getWorkListId());
        WorkList workList = optWorkList.orElseThrow(() -> new WorkListNotFoundException("해당 리스트를 찾을 수 없습니다."));
        workList.changeWorkList(workListDto.getWorkListTitle(), "admin", currentDateTime);
    }

    private Long getNextWorkListOrd(){
        return workListQueryRepository.findLastWorkListOrd() + 1000L;
    }

    @Transactional
    public List<WorkListDto> findAll() {
        List<WorkList> workLists = workListRepository.findAllByUseYnEqualsOrderByWorkListOrd(true);

        return workLists.stream()
                .map(x -> {
                    List<Card> cardList = x.getCard();
                    List<CardDto> cardDtoList = cardList.stream()
                                                        .map(y -> y.convertCardDto())
                                                        .collect(Collectors.toList());
                    WorkListDto workListDto = x.convertWorkListDto();
                    workListDto.setCardList(cardDtoList);
                    return workListDto;
                })
                .collect(Collectors.toList());
    }
}
