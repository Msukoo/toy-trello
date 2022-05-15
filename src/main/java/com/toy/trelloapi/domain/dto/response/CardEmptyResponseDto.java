package com.toy.trelloapi.domain.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CardEmptyResponseDto extends CardBaseResponseDto{

	private boolean empty = true;
}
