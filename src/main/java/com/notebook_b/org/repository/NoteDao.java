package com.notebook_b.org.repository;

import com.notebook_b.org.entity.aim.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository<Note,Integer> {
}
