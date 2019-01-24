package com.starlabs.rweater.controller;

import com.starlabs.rweater.domain.Message;
import com.starlabs.rweater.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;
import com.starlabs.rweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreaetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting( Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model/*Map<String, Object> model*/) {
        Iterable<Message> messages = messageRepo.findAll();

        if(filter!=null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }

        //model.put("messages", messages);
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag, user);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    /*//old
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
       Iterable<Message> messages;

       if(filter!=null && !filter.isEmpty()) {
           messages = messageRepo.findByTag(filter);
       } else {
           messages = messageRepo.findAll();
       }

        model.put("messages", messages);
        return "main";
    }*/
}
