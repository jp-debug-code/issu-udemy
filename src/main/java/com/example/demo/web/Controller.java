package com.example.demo.web;

import com.example.demo.domain.issue.issueEntity;
import com.example.demo.domain.issue.issueService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
@RequestMapping("/issues")  //各メソッドでの共通表記を省略できる
public class Controller {
   private final issueService ic;
    @GetMapping //RequestMappingを使用した際は()を消す
        public String showlist(Model model){

      model.addAttribute("issuelist",ic.findAll());
return"issues/list";
    }
    @GetMapping ("/creationform")
    public String showCreationform(@ModelAttribute issueForm form){
        return"issues/creationform";
    }//TODO issueFormをModel内に登録する
    @PostMapping
    public String create( Model model, @Validated issueForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return showCreationform(form);
        }
        ic.create(form.getSummury(),form.getDescription());



        return "redirect:/issues";//redirectを使う際は、Controllerのハンドラメソッドの戻り値にredirect:から始まる文字列を指定する。

    }
    @GetMapping ("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model){
        //var et=new issueEntity(1,"概要","説明する");
        model.addAttribute("issue",ic.findById(issueId));
        //model.addAttribute("issues",et);
        return"issues/detail"; //HTML名

    };
}
