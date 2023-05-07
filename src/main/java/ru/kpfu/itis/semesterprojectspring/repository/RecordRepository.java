package ru.kpfu.itis.semesterprojectspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;

public interface RecordRepository extends JpaRepository<Record,Long> {

}
