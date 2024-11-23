package famiglia.com.famiglia_reports.model;

import famiglia.com.famiglia_reports.enums.Quality;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quality")
    @Enumerated(EnumType.STRING)
    private Quality quality;

    @Column(name = "generated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime generatedAt;

    @Column(name = "generated_by", nullable = false)
    private Long generatedBy;

    @Column(name = "result_message")
    private String resultMessage;

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TaskCompletion> taskCompletions = new ArrayList<>();
}
