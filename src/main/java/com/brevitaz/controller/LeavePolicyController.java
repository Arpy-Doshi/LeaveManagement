package com.brevitaz.controller;

import com.brevitaz.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave/policies")
public class LeavePolicyController {

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public void create(@RequestBody Employee employee)
    {
        System.out.println("policy is created.");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.PUT)
    public void update(@RequestBody Employee employee, @PathVariable String id)
    {
        System.out.println("policy is updated.");
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
    public void delete(@PathVariable String id)
    {
        System.out.println("policy is deleted.");
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public void get(@PathVariable String id)
    {
        System.out.println("policy is viewed.");
    }





}
