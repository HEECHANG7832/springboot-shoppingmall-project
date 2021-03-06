package com.example.springbootshoppingmallproject.service;

import com.example.springbootshoppingmallproject.common.LineKey;
import com.example.springbootshoppingmallproject.common.LineMessageRequest;
import com.example.springbootshoppingmallproject.common.Messages;
import com.example.springbootshoppingmallproject.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class LineMessageService {

    private final LineKey lineKey;

    public void exchange() {

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.line.me/v2/bot/message/multicast")
                .encode()
                .build()
                .toUri();

        //http body -> object -> object mapper -> json -> resttemplate -> http body json
        LineMessageRequest req = new LineMessageRequest();

        List<String> to = new ArrayList<>();
        to.add("Ud2376d0d902d6f3d924ef13302a4dbf5");

        req.setTo(to);

        Messages msg = new Messages();
        msg.setType("text");
        msg.setText("Hello!! This is Line Messaging API!!");

        List<Messages> messages = new ArrayList<>();
        messages.add(msg);

        req.setMessages(messages);

        RequestEntity<LineMessageRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer {"+ lineKey.getKey() +"}")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LineMessageRequest> response = restTemplate.exchange(requestEntity, LineMessageRequest.class);

        log.info(response.getBody().toString());
    }

    public void sendLineMessage(User user, String content) {

        URI uri = UriComponentsBuilder
                .fromUriString("https://api.line.me/v2/bot/message/multicast")
                .encode()
                .build()
                .toUri();

        //http body -> object -> object mapper -> json -> resttemplate -> http body json
        LineMessageRequest req = new LineMessageRequest();

        List<String> to = new ArrayList<>();
        to.add("Ud2376d0d902d6f3d924ef13302a4dbf5"); // user's line id

        req.setTo(to);

        Messages msg = new Messages();
        msg.setType("text");
        msg.setText(content);

        List<Messages> messages = new ArrayList<>();
        messages.add(msg);

        req.setMessages(messages);

        RequestEntity<LineMessageRequest> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer {"+ lineKey.getKey() +"}")
                .body(req);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LineMessageRequest> response = restTemplate.exchange(requestEntity, LineMessageRequest.class);

        log.info(response.getBody().toString());
    }

}