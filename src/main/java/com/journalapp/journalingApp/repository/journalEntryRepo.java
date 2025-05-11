package com.journalapp.journalingApp.repository;

import com.journalapp.journalingApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepo extends MongoRepository<JournalEntry,String>{

}
