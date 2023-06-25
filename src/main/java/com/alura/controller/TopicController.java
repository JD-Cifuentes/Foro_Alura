package com.alura.controller;


import com.alura.modelo.Topic;
import com.alura.modelo.dto.TopicRegisterData;
import com.alura.modelo.dto.TopicResponseData;
import com.alura.modelo.repositories.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topic")
public class TopicController {


    private final TopicRepository topicRepository;

    public TopicController(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }
    @PostMapping
    public ResponseEntity<TopicResponseData> registrarMedico(@RequestBody @Valid TopicRegisterData topicRegisterData,
                                                             UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("el request llega correctamente");


        Topic topic = topicRepository.save(new Topic(topicRegisterData));
        TopicResponseData data = new TopicResponseData(topic);

        URI url = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(topic.getId()).toUri();

        return ResponseEntity.created(url).body(data);
    }


}
