package com.gmail.merikbest2015.commons.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_seq")
    @SequenceGenerator(name = "tags_seq", sequenceName = "tags_seq", initialValue = 100, allocationSize = 1)
    private Long id;

    @NonNull
    @Column(name = "tag_name")
    private String tagName;

    @NonNull
    @Column(name = "tweets_quantity")
    private Long tweetsQuantity;

    @NonNull
    @ManyToMany
    @JoinTable(name = "tweets_tags",
            joinColumns = @JoinColumn(name = "tags_id"),
            inverseJoinColumns = @JoinColumn(name = "tweets_id"))
    private List<Tweet> tweets;
}
