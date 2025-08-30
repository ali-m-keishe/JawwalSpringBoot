package com.jawwal.iws.jawwalIWS.service;

import com.jawwal.iws.jawwalIWS.config.RestTemplateConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "https://integserver1.paltel.ps/memo/api/memo";

    public Map<String, Object> createMemo(Map<String, Object> memoRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(memoRequest, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                BASE_URL, HttpMethod.POST, entity, Map.class);

        return response.getBody();
    }

    public Map<String, Object> getMemoStatus(String memoId) {
        ResponseEntity<Map> response = restTemplate.exchange(
                BASE_URL + "/" + memoId, HttpMethod.GET, null, Map.class);

        return response.getBody();
    }
}
