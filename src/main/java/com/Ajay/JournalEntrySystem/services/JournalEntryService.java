package com.Ajay.JournalEntrySystem.services;

import com.Ajay.JournalEntrySystem.entity.JournalEntry;
import com.Ajay.JournalEntrySystem.repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    JournalEntryRepo journalEntryRepo ;

    public JournalEntry createEntry(JournalEntry entry){
        if(entry.getTopic().isBlank()||entry.getDescription().isBlank())
            return null;

        entry.setPostDate(LocalDateTime.now());
        return journalEntryRepo.save(entry);
    }

    public List<JournalEntry> getAllEntries(){

        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    public JournalEntry updateEntry(ObjectId id, JournalEntry newEntry) {
        Optional<JournalEntry> entry = getEntryById(id);
        if(entry.isEmpty())
            return null;

        entry.get().setTopic(newEntry.getTopic()!=null?newEntry.getTopic():entry.get().getTopic());
        entry.get().setDescription(newEntry.getDescription()!=null?newEntry.getDescription():entry.get().getDescription());

        return entry.get();

    }

    public Boolean deleteEnteryById(ObjectId id) {
        Optional<JournalEntry> entry = getEntryById(id);
        if(entry.isEmpty())
            return false;
         journalEntryRepo.delete(entry.get());
         return true;

    }
}
