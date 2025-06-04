package com.scaler.taskmanager.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateTaskDTO {
    boolean completed;
    String description;
    String deadline;
    public boolean getCompleted() {
        return completed;
    }

}
