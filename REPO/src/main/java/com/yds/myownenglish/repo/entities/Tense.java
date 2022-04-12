package com.yds.myownenglish.repo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tenses", schema = "tenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tense {

    @Id
    @Column(name = "tense_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID tenseId;

    @Column(name = "tense_name")
    private String tenseName;
}
