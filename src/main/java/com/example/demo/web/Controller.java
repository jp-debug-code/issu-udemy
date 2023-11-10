package com.example.demo.web;

import com.example.demo.domain.issue.issueEntity;
import com.example.demo.domain.issue.issueRepositry;
import com.example.demo.domain.issue.issueService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller

@RequestMapping("/issues")  //各メソッドでの共通表記を省略できる
public class Controller {
    private final issueService ic;
    private final issueRepositry repo;

    public Controller(issueService ic, issueRepositry repo) {
        this.ic = ic;
        this.repo = repo;
    }


    @GetMapping //RequestMappingを使用した際は()を消す
    public String showlist(Model model) {

        model.addAttribute("issuelist", ic.findAll());
        return "issues/list";
    }

    @GetMapping("/creationform")//@ModelAttribute issueForm form→issueform@ModelAttribute issueForm formがmodelに登録される
    public String showCreationform(@ModelAttribute issueForm form) {
        return "issues/creationform";
    }//TODO issueFormをModel内に登録する

    @PostMapping
    public String create( @Validated issueForm form, BindingResult bindingResult ,Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationform(form);
        }
        ic.create(form.getSummury(), form.getDescription());


        return "redirect:/issues";//redirectを使う際は、Controllerのハンドラメソッドの戻り値にredirect:から始まる文字列を指定する。

    }

    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        //var et=new issueEntity(1,"概要","説明する");
        model.addAttribute("issue", ic.findById(issueId));
        //model.addAttribute("issues",et);
        return "issues/detail"; //HTML名

    }

//    @GetMapping("/updateform/{id}") //遷移処理
//    public String showupdateform(@PathVariable("id") long issueId ,Model model) {
//        issueEntity issue =ic.findById(issueId);
//        issueForm form = issueService.update(issue.getId(), issue.getSummury(), issue.getDescription());
//
//
//        return "issues/updateform";
//    }//TODO issueFormをModel内に登録する

//    @PostMapping("/update")//form処理　post/issuesを受け取る
//    public String update( @RequestParam("id")long id ,Model model, @Validated issueForm form, BindingResult bindingresult) {
////    ic.update()
//        if (bindingresult.hasErrors()) {
//            return "issues/updateform";//エラーの場合はredirectでなくそのままビュー名を返す
//
//        }
//        ic.update(id,form.getSummury(), form.getDescription());
//
//
//
//        return "redirect:/issues";//redirectを使う際は、Controllerのハンドラメソッドの戻り値にredirect:から始まる文字列を指定する。
//
//    }
    @PostMapping("/delete/{issueId}")
    public String delete(@PathVariable("issueId") long id) {
        ic.delete(id);
        //repo.resetAutoIncrement();
        return "redirect:/issues";
    }




    }

