package com.toy.trelloapi.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.toy.trelloapi.domain.response.CardResponseCode;
import com.toy.trelloapi.model.PagingInfo;
import lombok.Data;

@Data
public class CardBaseResponseDto {
	@JsonIgnore
	private CardResponseCode responseCode = CardResponseCode.CARD_RESPONSE_SUCCESS;

	@JsonIgnore
	private PagingInfo pagingInfo = PagingInfo.builder().build();
}
