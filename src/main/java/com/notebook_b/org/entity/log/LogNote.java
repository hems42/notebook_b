package com.notebook_b.org.entity.log;

import com.notebook_b.org.entity.aim.Note;
import com.notebook_b.org.entity.leadRole.User;
import com.notebook_b.org.product.appEnums.AppEnumCrud;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LogNotes")
public class LogNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AppEnumCrud crud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NoteId",nullable = false)
    private Note note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @Column(name = "CreatedDate", updatable = false)
    private LocalDateTime createdDate;
}
