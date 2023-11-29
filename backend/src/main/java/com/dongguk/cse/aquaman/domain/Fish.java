package com.dongguk.cse.aquaman.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "fish")
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id; // primary key

    @Column(name = "type")
    private String type; // 성어, 유어, 치어

}
