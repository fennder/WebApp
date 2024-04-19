package br.dev.abrindoportas.WebApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.dev.abrindoportas.WebApp.models.TaskModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {

    List<TaskModel> taskModels = new ArrayList<>();

    @GetMapping("")
    public String getIndexString(TaskModel taskModel){
        return "index";
    }
    
    @GetMapping("/create")
    public String getCreateString(){
        return "create";
    }

    @PostMapping("/create")
    public String postCreateString(TaskModel taskModel){
        // System.out.println("O nome da tarefa é: " + taskModel.getName());
        if (taskModel.getId() != null) {
            TaskModel taskModelFind = taskModels.stream().filter(taskModelItem -> taskModel.getId().equals(taskModel.getId())).findFirst().get();
            taskModels.set(taskModels.indexOf(taskModelFind), taskModel);
        }else{
            Long id = taskModels.size() + 1L;
            taskModels.add(new TaskModel(id, taskModel.getName(), taskModel.getDate()));
        }

        return "redirect:/list";
    }

    @GetMapping("/list")
    public ModelAndView getListString(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("taskModels", taskModels);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditString(@PathVariable("id") Long id){
        
        ModelAndView mv = new ModelAndView("create");

        TaskModel taskModelFind = taskModels.stream().filter(taskModel -> id.equals(taskModel.getId())).findFirst().get();

        mv.addObject("taskModel", taskModelFind);
        
        return mv;
    }

}
