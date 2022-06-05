package com.toy.trelloapi.message;

import com.toy.trelloapi.utils.JsonUtil;

public class Message {
	public Message() {
	}

	public String toJsonString() {
		return JsonUtil.toJsonString(this);
	}
}
