package com.harry.crm.entity;

import com.harry.crm.TaskDTO;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to_staff_id")
    private Staff assignedTo;

    // Constructors, getters, setters
    // Omitted for brevity

    // Method to convert to TaskDTO
    public TaskDTO toDTO() {
        TaskDTO dto = new TaskDTO();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setDescription(this.description);
        dto.setStatus(this.status);
        dto.setPriority(this.priority);
        dto.setDueDate(this.dueDate);
        dto.setAssignedToId(this.assignedTo != null ? this.assignedTo.getId() : null);
        return dto;
    }
}