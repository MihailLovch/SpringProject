package ru.kpfu.itis.semesterprojectspring.service;

import ru.kpfu.itis.semesterprojectspring.model.dto.UserDashboardDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;

import java.util.Date;
import java.util.List;

public interface RecordService {
    List<Record> findRecordsByUserAndDateRange(User user, Date start, Date end);

    int countDaysWhenOverCalories(User user, UserDashboardDto dto);
}
