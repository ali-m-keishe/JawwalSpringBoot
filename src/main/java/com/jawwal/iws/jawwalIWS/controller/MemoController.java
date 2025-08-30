package com.jawwal.iws.jawwalIWS.controller;

import com.jawwal.iws.jawwalIWS.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/memo")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping
    public Map<String, Object> createMemo(@RequestBody Map<String, Object> memoRequest) {
        return memoService.createMemo(memoRequest);
    }

    @GetMapping("/{memoId}")
    public Map<String, Object> getMemoStatus(@PathVariable String memoId) {
        return memoService.getMemoStatus(memoId);
    }
}