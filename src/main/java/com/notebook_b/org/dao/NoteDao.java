package com.notebook_b.org.dao;

import com.notebook_b.org.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteDao extends JpaRepository<Note,Integer> {
}
