
-- sub-query which return total consumed calories in last 30 days
SELECT total_calories
FROM (
         SELECT user_id, sum(calorie) as total_calories
         FROM records
         WHERE date > current_date - interval '30 days'
         GROUP BY user_id
     ) AS calories_total
         JOIN  users ON users.user_id=calories_total.user_id where name = 'new value';

-- some
select r.name
from users join user_recipe ur on users.user_id = ur.user_id join recipes r on r.recipe_id = ur.recipe_id
where users.name = 'new value'
and r.calories in (select calories from recipes order by calories desc limit 5 )