package com.App.Quora.Entity;

import java.util.UUID;

import jakarta.persistence.*;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Question> questions;

}
