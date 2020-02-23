package service;

import dao.CarDAO;
import model.ArticleRepository;
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

    @Inject
    ArticleRepository articleRepository;

    @PersistenceContext
    EntityManager em;


    private List<String> colorsList = new ArrayList<>();
    private List<String> brandsList = new ArrayList<>();


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

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}
