package com.volunteer.platform.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

    @PostMapping("/moderate")
    public void moderateContent(@RequestParam Long contentId, @RequestParam String action) {
        // Implement content moderation logic
    }

    @PostMapping("/update")
    public void updateContent(@RequestParam Long contentId, @RequestBody String newContent) {
        // Implement content update logic
    }
}
