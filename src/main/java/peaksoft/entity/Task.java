package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String deadLine;
    private String task;
    @ManyToOne(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Task(String name, String deadline, String task) {
        this.name = name;
        this.deadLine = deadline;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Task : -" +
                " id :" + id +
                " name :" + name + '\'' +
                " deadline :" + deadLine + '\'' +
                " task :" + task + '\'' +
                " lesson :" + lesson ;
    }
}
