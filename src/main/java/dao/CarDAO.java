package dao;

import model.ArticleRepository;
import model.Car;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CarDAO {

    Car car= new Car();

    @PersistenceContext(unitName = "sfb")
    protected EntityManager em;

    @Inject
    private ArticleRepository articleRepository;

    public void persisCar(Car car) {
        em.persist(car);
    }

    public void update(Car car) {
        em.merge(car);
    }

    /*public List<Car> getAllCars() {
        return em.createQuery("SELECT b FROM Car b").getResultList();
    }
    public void update(Car car){
        articleRepository.save(car);
    }*/
    public List<Car> getAllCarss() {
        return articleRepository.findAll();
    }
}
