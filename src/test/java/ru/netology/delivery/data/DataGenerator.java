package ru.netology.delivery.data;


import com.github.javafaker.Faker;
import lombok.Value;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DataGenerator {


    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {

        String[] cities = {"Белгород", "Брянск", "Владимир", "Воронеж", "Иваново", "Калуга", "Кострома",
                "Курск", "Липецк", "Москва", "Орел", "Рязань", "Смоленск", "Тамбов", "Тверь", "Тула", "Ярославль",
                "Архангельск", "Вологда", "Калининград", "Петрозаводск", "Сыктывкар", "Санкт-Петербург", "Мурманск",
                "Салехард", "Великий Новгород", "Псков", "Уфа", "Киров", "Йошкар-Ола", "Саранск", "Нижний Новгород",
                "Оренбург", "Пенза", "Пермь", "Самара", "Саратов", "Казань", "Ижевск", "Ульяновск", "Чебоксары",
                "Курган", "Екатеринбург", "Тюмень", "Ханты-Мансийск", "Челябинск", "Салехард", "Горно-Алтайск",
                "Барнаул", "Улан-Удэ", "Чита", "Иркутск", "Кемерово", "Красноярск", "Новосибирск", "Омск", "Томск",
                "Кызыл", "Абакан", "Благовещенск", "Биробиджан", "Петропавловск-Камчатский", "Магадан", "Владивосток",
                "Якутск", "Южно-Сахалинск", "Хабаровск", "Анадырь", "Майкоп", "Астрахань", "Волгоград", "Элиста",
                "Краснодар", "Ростов-на-Дону", "Махачкала", "Магас", "Нальчик", "Черкесск", "Владикавказ",
                "Ставрополь", "Грозный"};
        Random rand = new Random();

        return cities[rand.nextInt(cities.length)];

    }

    public static String generateName() {
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone() {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {

            String city = generateCity();
            String name = generateName();
            String phone = generatePhone();
            UserInfo user = new UserInfo(city, name, phone);
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}