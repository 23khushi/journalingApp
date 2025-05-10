package com.journalapp.journalingApp.controller;


import com.journalapp.journalingApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal") // Class pr mapping krdegaa

public class JournalEntryController2 {



    @GetMapping
     public List<JournalEntry> getAll(){

      return null;
     }

     @PostMapping
     public boolean createEntry(@RequestBody JournalEntry myEntry){

        return true;
     }

     @GetMapping("id/{myid}")
     public  JournalEntry findById(@PathVariable long myid){

        return  null;
     }

     @DeleteMapping("id/{myid}")
     public  JournalEntry deleteJounalById(@PathVariable long myid){

        return  null;
     }

     @PutMapping("id/{myid}")
    public  JournalEntry UpdateJournalById(@PathVariable long myid, @RequestBody JournalEntry entry){
        return  null;
    }



}


