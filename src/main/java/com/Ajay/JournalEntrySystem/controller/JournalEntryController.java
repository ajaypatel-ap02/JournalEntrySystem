package com.Ajay.JournalEntrySystem.controller;

import com.Ajay.JournalEntrySystem.entity.JournalEntry;
import com.Ajay.JournalEntrySystem.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<?> getAllEntries(){
        List<JournalEntry> entries = journalEntryService.getAllEntries();
        if(entries.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new ArrayList<>(entries),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEntryById(@PathVariable ObjectId id){
        Optional<JournalEntry> entry = journalEntryService.getEntryById( id);
        if(entry.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(entry,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry entry){
        JournalEntry journalEntry = journalEntryService.createEntry(entry);
        if(journalEntry != null) {
            return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Something wen wrong...!",HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateEntry(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry){
        JournalEntry entry = journalEntryService.updateEntry( id, newEntry);
        if(entry == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        return new ResponseEntity<>(entry,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId id){
        java.lang.Boolean result = journalEntryService.deleteEnteryById( id);
        if(result)
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>("Id not Found",HttpStatus.NOT_FOUND);
    }

}
