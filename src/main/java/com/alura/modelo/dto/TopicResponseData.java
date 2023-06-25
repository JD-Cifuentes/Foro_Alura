package com.alura.modelo.dto;

import com.alura.modelo.Course;
import com.alura.modelo.Topic;
import com.alura.modelo.User;

public record TopicResponseData(Long id, String title, String message, User user, Course course) {
    public TopicResponseData(Topic topic){
        this(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getUser(),
                topic.getCourse()
        );

    }
}
