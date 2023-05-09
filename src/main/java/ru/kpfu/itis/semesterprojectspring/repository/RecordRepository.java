package ru.kpfu.itis.semesterprojectspring.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

import java.util.Date;
import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {


    @Query("SELECT COUNT(*) FROM Record r WHERE r.user.id = :userId and r.calorie>=:maxValue GROUP BY r.user.id")
    int getRecordCountForUserWhenOverMaxValue(@Param("userId") Long userId, @Param("maxValue") Double maxValue);

    @Query("SELECT r FROM Record r WHERE r.user = :user AND r.date BETWEEN :startDate AND :endDate")
    List<Record> findAllRecordsByUserAndDateRange(@Param("user") User user, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
