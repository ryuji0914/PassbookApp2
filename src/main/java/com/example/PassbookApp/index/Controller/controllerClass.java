package com.example.PassbookApp.index.Controller;

import com.example.PassbookApp.index.Entity.CreateForm;
import com.example.PassbookApp.index.Entity.PassbookEntity;
import com.example.PassbookApp.index.Entity.RegisterEntity;
import com.example.PassbookApp.index.Entity.RegisterForm;
import com.example.PassbookApp.index.Service.CreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class controllerClass {
    private final CreateService createservice;

    @GetMapping("/detail")
    public String detail(Model model){
        var find = createservice.find();
        var findOpportunity = createservice.findOpportunity();
        model.addAttribute("find",find);
        RegisterEntity latest = null;
        if (findOpportunity != null && !findOpportunity.isEmpty()) {
            latest = findOpportunity.get(findOpportunity.size() - 1);
        }
        model.addAttribute("findOpportunity", latest);

        return "detail/bankbook";
    }

    @GetMapping("/create")
    public String create(@RequestParam("year") int year,
                         @RequestParam("month") int month,
                         Model model){
        model.addAttribute("year",year);
        model.addAttribute("month",month);
        return "detail/newRegister";
    }

    @GetMapping("/update")
    public String update(){
        return "detail/Update";
    }

    @GetMapping("/targetMoney")
    public String settingmoney(){
        return "detail/targetMoney";
    }

    @PostMapping("/detail")
    public String createrecord(@Validated CreateForm form, Model model){
        createservice.create(form.createEntity());
        return "redirect:/month?year=" + form.year() + "&month=" + form.month();
    }

    @PostMapping("/detailA")
    public String createMoney(@Validated RegisterForm form,Model model){
        RegisterEntity entity = new RegisterEntity();
        entity.setTargetAmount(form.targetAmount());
        createservice.register(entity);
        return "redirect:/detail";
    }

    @GetMapping("/month")
    public String showMonthPage(
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            Model model
    ){
        List<PassbookEntity> list = createservice.findPassbook(year,month);
        model.addAttribute("year",year);
        model.addAttribute("month",month);
        model.addAttribute("list",list);

        return "detail/bankbook";
    }





}
