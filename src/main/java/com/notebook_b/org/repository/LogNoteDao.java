package com.notebook_b.org.repository;

import com.notebook_b.org.entity.log.LogNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogNoteDao extends JpaRepository<LogNote,Integer> {
}
