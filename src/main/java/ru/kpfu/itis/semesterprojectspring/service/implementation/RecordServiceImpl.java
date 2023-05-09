package ru.kpfu.itis.semesterprojectspring.service.implementation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.semesterprojectspring.model.dto.UserDashboardDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Record;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.repository.RecordRepository;
import ru.kpfu.itis.semesterprojectspring.service.RecordService;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor

public class RecordServiceImpl  implements RecordService {

    @PersistenceContext
    private final EntityManager em;
    private final RecordRepository recordRepository;
//    @Override
//    public List<Record> findRecordsByUserAndDateRange(User user, Date start, Date end) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Record> cq = cb.createQuery(Record.class);
//
//        Root<Record> root = cq.from(Record.class);
//
//        cq.where(
//                cb.and(
//                        cb.equal(root.get("user"),user),
//                        cb.between(root.get("date"),start,end)
//                )
//        );
//        return em.createQuery(cq).getResultList();
//    }

    @Override
    public List<Record> findRecordsByUserAndDateRange(User user, Date start, Date end) {
        return recordRepository.findAllRecordsByUserAndDateRange(user,start,end);
    }

    @Override
    public int countDaysWhenOverCalories(User user, UserDashboardDto dto){
        int res = (recordRepository.getRecordCountForUserWhenOverMaxValue(user.getId(), dto.getMaxCalories()));
        return recordRepository.getRecordCountForUserWhenOverMaxValue(user.getId(), dto.getMaxCalories());
    }
}
