package com.university.sportapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "training_sessions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coach_id")
    private Coach coach;

    @NotNull(message = "Session date is required")
    @Column(name = "session_date")
    private LocalDate sessionDate;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
}
