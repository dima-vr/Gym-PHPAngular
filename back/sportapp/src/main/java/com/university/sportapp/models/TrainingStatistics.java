package com.university.sportapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "training_statistics")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "Training date is required")
    @Column(name = "training_date")
    private LocalDate trainingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @NotNull(message = "Duration is required")
    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @NotNull(message = "Achievements are required")
    @Column(name = "achievements")
    private List<String> achievements;
}
