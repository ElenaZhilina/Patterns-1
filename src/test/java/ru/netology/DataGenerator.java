package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int daysToAdd) {
        return LocalDate.now().plusDays(daysToAdd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

        //public static final Faker faker = new Faker(new Locale("ru"));
        public static String generateCity () {
        var cities = new String[] {"Москва", "Уфа", "Липецк", "Ярославль",
                "Белгород", "Орел", "Астрахань", "Чита", "Магадан", "Казань", "Саратов", "Чебоксары",
                "Хабаровскк", "Мурманск", "Санкт-Петербург"};
            return cities[new Random().nextInt(cities.length)];
        }

        public static String generateName () {
            return faker.name().fullName();
        }

        public static String generatePhone () {
            return faker.phoneNumber().phoneNumber();
        }



    public static class Registration {
        public static User generateUser() {
            Faker localeFaker = new Faker(new Locale("ru"));
            User user = new User();
            user.setName(localeFaker.name().fullName());
            user.setPhone(localeFaker.phoneNumber().phoneNumber());
            user.setCity(localeFaker.address().city());
            return user;
        }

    }
}

    }
