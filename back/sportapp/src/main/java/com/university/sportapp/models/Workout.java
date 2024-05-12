package com.university.sportapp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "workout")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Type is required")
    @Column(name = "type")
    private String type;

    @NotNull(message = "Group session is required")
    @Column(name = "group_session")
    private boolean groupSession;
}
