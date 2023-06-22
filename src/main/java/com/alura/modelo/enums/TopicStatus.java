package com.alura.modelo.enums;

public enum TopicStatus {
	
	NO_ANSWERED ("No answered"),
	UNSOLVED("Unsolved"),
	SOLVED("Solved"),
	CLOSE("Close");

	final String TopicStatusName;

	TopicStatus(String topicStatusName) {
		TopicStatusName = topicStatusName;
	}

	@Override
	public String toString() {
		return TopicStatusName;
	}
}
