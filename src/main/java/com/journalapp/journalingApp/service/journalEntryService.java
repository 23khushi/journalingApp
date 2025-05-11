package com.journalapp.journalingApp.service;

import com.journalapp.journalingApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class journalEntryService {

    @Autowired
    private MongoRepository mongoRepository; // Interface, Spring will automatically create implementation on runtime

    public void saveAll(JournalEntry journalEntry){
        mongoRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return mongoRepository.findAll();
    }

    public void DeleteById(String id){
        mongoRepository.deleteById(id);
    }

    public Optional<JournalEntry> getById(String id){
        return mongoRepository.findById(id);
    }
}
