package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int USER_MEAL_ID = START_SEQ + 3;
    public static final int ADMIN_MEAL_ID = START_SEQ + 10;

    public static final Meal meal1 = new Meal(USER_MEAL_ID, of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
    public static final Meal meal2 = new Meal(USER_MEAL_ID + 1, of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
    public static final Meal meal3 = new Meal(USER_MEAL_ID + 2, of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);
    public static final Meal meal4 = new Meal(USER_MEAL_ID + 3, of(2015, Month.MAY, 31, 00, 0), "Еда на граничное значение", 100);
    public static final Meal meal5 = new Meal(USER_MEAL_ID + 4, of(2015, Month.MAY, 31, 10, 0), "Завтрак", 500);
    public static final Meal meal6 = new Meal(USER_MEAL_ID + 5, of(2015, Month.MAY, 31, 13, 0), "Обед", 1000);
    public static final Meal meal7 = new Meal(USER_MEAL_ID + 6, of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);
    public static final Meal adminMeal1 = new Meal(ADMIN_MEAL_ID, of(2022, Month.JUNE, 21, 14, 0), "Админ ланч", 510);
    public static final Meal adminMeal2 = new Meal(ADMIN_MEAL_ID + 1, of(2022, Month.JUNE, 21, 21, 0), "Админ ужин", 1500);

    public static final List<Meal> meals = Arrays.asList(meal7, meal6, meal5, meal4, meal3, meal2, meal1);
    public static final List<Meal> adminMeals = Arrays.asList(adminMeal2, adminMeal1);

    public static Meal getCreated() {
        return new Meal(null, of(2015, Month.JUNE, 1, 18, 0), "Созданный ужин", 300);
    }

    public static Meal getUpdated() {
        return new Meal(USER_MEAL_ID, of(2015, Month.MAY, 30, 9, 30), "Обновленный завтрак", 200);
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
    }
}
