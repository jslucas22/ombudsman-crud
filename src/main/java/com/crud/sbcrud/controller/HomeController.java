package com.crud.sbcrud.controller;

import com.crud.sbcrud.service.ManifestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
