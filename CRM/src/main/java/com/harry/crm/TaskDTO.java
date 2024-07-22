package com.harry.crm;

import com.harry.crm.entity.Priority;
import com.harry.crm.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private Priority priority;
    private LocalDateTime dueDate;
    private Long assignedToId; // Instead of the entire Staff object

    // Constructors, getters, setters
    // Omitted for brevity
}
