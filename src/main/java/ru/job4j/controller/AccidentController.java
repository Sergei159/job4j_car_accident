package ru.job4j.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Accident;
import ru.job4j.model.Rule;
import ru.job4j.service.AccidentService;
import ru.job4j.service.AccidentTypeService;
import ru.job4j.service.RuleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


@Controller
public class AccidentController {

    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;
    private final RuleService ruleService;

    public AccidentController(AccidentService service, AccidentTypeService accidentTypeService, RuleService ruleService) {
        this.accidentService = service;
        this.accidentTypeService = accidentTypeService;
        this.ruleService = ruleService;
    }


    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }

    @GetMapping("/addAccident")
    public String addAccident(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "addAccident";
    }

    @PostMapping("/createAccident")
    public String saveAccident(@ModelAttribute Accident accident, @RequestParam("type.id") int id,
                               Model model, HttpServletRequest req) {
        String[] rIds = req.getParameterValues("rIds");
        Set<Rule> rules = ruleService.createWithRules(rIds);
        accident.setRules(rules);
        accident.setType(accidentTypeService.findById(id));
        accidentService.add(accident);
        model.addAttribute("accidents", accidentService.findAll());
        model.addAttribute("rules", rules);
        return "redirect:/index";
    }


    @GetMapping("/accidentInfo/{accidentId}")
    public String itemInfo(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accident", accidentService.findById(id));
        model.addAttribute("accidents", accidentService.findAll());
        return "accidentInfo";
    }

    @GetMapping("/updateAccident/{accidentId}")
    public String updateAccident(Model model, @PathVariable("accidentId") int id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accident", accidentService.findById(id));
        model.addAttribute("types", accidentTypeService.findAll());
        model.addAttribute("rules", ruleService.findAll());
        return "updateAccident";
    }

    @PostMapping("/updateAccident")
    public String updateItem(@ModelAttribute Accident accident, @RequestParam("type.id") int id,
                             HttpServletRequest req) {
        String[] rIds = req.getParameterValues("rIds");
        accident.setRules(ruleService.createWithRules(rIds));
        accident.setType(accidentTypeService.findById(id));
        accidentService.update(accident);
        return "redirect:/index";
    }

    @GetMapping("/deleteAccident/{accidentId}")
    public String deleteItem(@PathVariable("accidentId") int id) {
        accidentService.delete(id);
        return "redirect:/index";
    }

}
