package com.journalapp.journalingApp.controller;


import com.journalapp.journalingApp.entity.JournalEntry;
import com.journalapp.journalingApp.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal") // Class pr mapping krdegaa

public class JournalEntryController2 {

    @Autowired
    private journalEntryService journalEntryService;


    @GetMapping
     public List<JournalEntry> getAll(){
       return journalEntryService.getAll();
     }

     @PostMapping
     public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveAll(myEntry);
        return true;
     }

     @GetMapping("id/{myid}")
     public  JournalEntry findById(@PathVariable String myid){
        return journalEntryService.getById(myid).orElse(null);
     }

     @DeleteMapping("id/{myid}")
     public  boolean deleteJournalById(@PathVariable String myid){
          journalEntryService.DeleteById(myid);
          return true;
     }

     @PutMapping("id/{myid}")
    public  JournalEntry UpdateJournalById(@PathVariable String myid, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.getById(myid).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }

        journalEntryService.saveAll(old);
        return  old;
    }



}


