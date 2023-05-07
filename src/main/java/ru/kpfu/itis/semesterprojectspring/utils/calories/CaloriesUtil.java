package ru.kpfu.itis.semesterprojectspring.utils.calories;

import ru.kpfu.itis.semesterprojectspring.model.entity.User;

public class CaloriesUtil {
    public static Double calcMaxCalories(User user){
        double calories = 10 * user.getWeight() + 6.25 * user.getHeight() - 5* user.getAge();
        if (user.getSex()){
            return 1.2 * (calories + 5);
        }else {
            return 1.2 * (calories - 161);
        }
    }

    public static Double calcMaxFats(User user){
        return 0.8 * user.getWeight();
    }

    public static Double calcMaxProteins(User user){
        return 1.5 * user.getWeight();
    }

    public static Double calcMaxCarbs(User user){
        return (double) (2 * user.getWeight());
    }
}
