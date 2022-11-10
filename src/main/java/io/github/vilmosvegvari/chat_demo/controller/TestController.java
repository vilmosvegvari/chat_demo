package io.github.vilmosvegvari.chat_demo.controller;

import io.github.vilmosvegvari.chat_demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    private final TestService testService;


    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping({"/"})
    public String mainPage(Model model) {
        model.addAttribute("messages", testService.messages);
        return "text";
    }

//
//    @GetMapping({"/"})
//    public String getMEssages(Model model) {
//        model.addAttribute("messages", testService.messages);
//        return "";
//    }

    @RequestMapping({"/clearMessages"})
    public String clear() {
        testService.messages.clear();
        return "redirect:/";
    }
}
