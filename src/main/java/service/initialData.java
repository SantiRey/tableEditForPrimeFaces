package service;

import dao.CarDAO;
import model.Brand;
import model.Car;
import model.Color;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Startup
@Singleton
public class initialData {

    @Inject
    CarDAO carDAO;

    @PersistenceContext
    EntityManager em;

    private final static String[] colors;

    private final static String[] brands;

    private List<String> colorsList = new ArrayList<>();
    private List<String> brandsList = new ArrayList<>();

    static {
        colors = new String[10];
        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        brands = new String[10];
        brands[0] = "BMW";
        brands[1] = "Mercedes";
        brands[2] = "Volvo";
        brands[3] = "Audi";
        brands[4] = "Renault";
        brands[5] = "Fiat";
        brands[6] = "Volkswagen";
        brands[7] = "Honda";
        brands[8] = "Jaguar";
        brands[9] = "Ford";
    }

    @PostConstruct
    public void init() {
        colorsList.add("Black");
        colorsList.add("White");
        colorsList.add("Green");
        colorsList.add("Red");
        colorsList.add("Blue");

        brandsList.add("BMW");
        brandsList.add("Mercedes");
        brandsList.add("Audi");
        brandsList.add("Volkswagen");
        brandsList.add("Ford");
        for (int i = 0; i < 5; i++) {
            //Car car = new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), getRandomPrice(), getRandomSoldState());
            Car car = new Car(getRandomId(), "BMW", 2020, "Blue", 1, true);
            System.out.println("::::::::::::::Trying to Persist" + car.id);
            em.persist(car);
            System.out.println("::::::::::Persisted" + car.id);
            Color color = new Color(getRandomId(),colorsList.get(i));
            System.out.println("::::::::::::::Trying to Persist" + color.toString());
            em.persist(color);
            System.out.println("::::::::::Persisted" + color.getId());
            Brand brand = new Brand(getRandomId(),brandsList.get(i));
            System.out.println("::::::::::::::Trying to Persist" + brand.getId().toString());
            em.persist(brand);
            System.out.println("::::::::::Persisted" + brand.getId());
        }


    }

    public void createCars() {
        for (int i = 0; i < 5; i++) {
            Car car = new Car(getRandomId(), getRandomBrand(), getRandomYear(), getRandomColor(), 1, true);
            System.out.println("::::::::::::::Trying to Persist" + car.id);
            em.persist(car);
            System.out.println("::::::::::Persisted" + car.id);
        }
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

    private int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    private boolean getRandomSoldState() {
        return (Math.random() > 0.5) ? true : false;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

    public List<String> getBrands() {
        return Arrays.asList(brands);
    }
}
