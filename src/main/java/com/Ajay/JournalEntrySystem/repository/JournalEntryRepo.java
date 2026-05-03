package com.Ajay.JournalEntrySystem.repository;

import com.Ajay.JournalEntrySystem.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry , Object> {
}
