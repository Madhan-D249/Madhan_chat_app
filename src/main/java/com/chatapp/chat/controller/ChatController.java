package com.chatapp.chat.controller;

import com.chatapp.chat.model.Message;
import com.chatapp.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/")
    public String chat(Model model) {
        model.addAttribute("messages", chatService.getMessages());
        model.addAttribute("message", new Message());
        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(@ModelAttribute Message message) {
        chatService.addMessage(message);
        return "redirect:/";
    }
}
