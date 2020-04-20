package com.project.controller;

import com.project.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.*;

@Controller
public class AnalyticsController {

    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/analytics")
    public String showAnalytics(Model model) {

        List<HashMap> bookView = bookService.queryBookViewTime();
        List<HashMap> bookSold = bookService.queryBookSold();
        LinkedHashMap<String, Integer> bookViewMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> bookSoldMap = new LinkedHashMap<>();
        for (HashMap temp : bookView) {
            bookViewMap.put((String) temp.get("bookName"), (Integer) temp.get("clickTime"));
        }

        for (HashMap temp : bookSold) {
            bookSoldMap.put((String) temp.get("bookName"), ((BigDecimal) temp.get("total")).intValue());
        }

        model.addAttribute("bookView", bookViewMap);
        model.addAttribute("bookSold", bookSoldMap);
        return "analytics";
    }
}
