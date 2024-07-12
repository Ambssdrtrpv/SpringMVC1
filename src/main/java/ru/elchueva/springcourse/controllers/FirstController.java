package ru.elchueva.springcourse.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("calculator")
    public String calculatorPage(@RequestParam(value = "a") Double a, @RequestParam(value = "b") Double b,
                                 @RequestParam (value = "action") String action, Model model) {
        Double res = 0.0;
        ActionType actionType = Enum.valueOf(ActionType.class, action.toUpperCase());
        switch (actionType){
            case MULTIPLICATION:
                res = a * b;
                break;
            case DIVISION:
                res = a / b;
                break;
            case ADDITION:
                res = a + b;
                break;
            case SUBTRACTION:
                res = a - b;
                break;
        }
        model.addAttribute("result", res);
        return "first/calculator";
    }
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){ //HttpServletRequest request в этом обхекте содержатся все сведения о поступающем http запросе, внедряет объект - Model для дальнейшего использлвания этой оболочки, сама модель передается в представление

        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message", "Hello " + name + " " + surname); //нужно выбрать ключ(строка) и добавить значението есть изи sout
        return "first/hello"; // это представление! возвращаем ту страницу представления которая будет показана пользователю хорошая практика класть все представления в папку которая относится к контролеру
    }
    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }
}
