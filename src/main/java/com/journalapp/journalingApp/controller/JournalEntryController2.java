package com.journalapp.journalingApp.controller;


import com.journalapp.journalingApp.entity.JournalEntry;
import com.journalapp.journalingApp.service.journalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal") // Class pr mapping krdegaa

public class JournalEntryController2 {

    @Autowired
    private journalEntryService journalEntryService;


    @GetMapping
     public ResponseEntity<?> getAll(){
        List<JournalEntry> all= journalEntryService.getAll();
        if(!all.isEmpty() && !(all ==null)){
            return  new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     @PostMapping
     public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        try {
            journalEntryService.saveAll(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

     }

     @GetMapping("id/{myid}")
     public  ResponseEntity<?> findById(@PathVariable String myid){

        Optional<JournalEntry> GetById=  journalEntryService.getById(myid);
        if (GetById.isPresent()){
            return new ResponseEntity<>(GetById.get(), HttpStatus.OK);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     @DeleteMapping("id/{myid}")
     public  ResponseEntity<?> deleteJournalById(@PathVariable String myid){
          journalEntryService.DeleteById(myid);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

     @PutMapping("id/{myid}")
    public  ResponseEntity<?> UpdateJournalById(@PathVariable String myid, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.getById(myid).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveAll(old);
            return new  ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


