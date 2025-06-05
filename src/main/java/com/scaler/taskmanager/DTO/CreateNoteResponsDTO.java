package com.scaler.taskmanager.DTO;

import com.scaler.taskmanager.entities.NoteEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateNoteResponsDTO {
    private Integer tasksId;
    private NoteEntity note;

}
