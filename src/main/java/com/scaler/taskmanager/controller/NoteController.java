package com.scaler.taskmanager.controller;

import com.scaler.taskmanager.DTO.CreateNoteDTO;
import com.scaler.taskmanager.DTO.CreateNoteResponsDTO;
import com.scaler.taskmanager.entities.NoteEntity;
import com.scaler.taskmanager.service.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId) {
        List<NoteEntity> notes = noteService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreateNoteResponsDTO> addNote(
            @PathVariable("taskId") Integer taskId,
            @RequestBody CreateNoteDTO createNoteDTO
    ) {
        NoteEntity noteEntity = noteService.addNoteForTask(taskId, createNoteDTO.getTitle(), createNoteDTO.getBody());
        CreateNoteResponsDTO response = new CreateNoteResponsDTO();
        response.setTasksId(taskId);
        response.setNote(noteEntity);
        return ResponseEntity.ok(response);
    }
}