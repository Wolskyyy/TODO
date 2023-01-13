package com.kamil.todo.controller;

import com.kamil.todo.dao.Repository;
import com.kamil.todo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private Repository todo;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Welcome to the TODO list app";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody Task task){
        todo.save(task);
        return "Task added!";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Task> result(){
        return todo.findAll();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable(name = "id") int id){
        todo.deleteById(id);
        return "Removed task" + id;
    }

    @RequestMapping("/getTask/{id}")
    @ResponseBody
    public List<Task> getTaskById(@PathVariable int id){
        return todo.findById(id);
    }
}
