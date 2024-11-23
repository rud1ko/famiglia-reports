package famiglia.com.famiglia_reports.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "TaskCompletion")
public class TaskCompletion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "completed_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime completedAt;

    @Column(name = "feedback")
    private String feedback;

    @ManyToOne(optional = true)
    @JoinColumn(name = "report_id")
    private Report report;
}
