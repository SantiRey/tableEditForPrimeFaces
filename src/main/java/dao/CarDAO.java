package dao;

import model.Car;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CarDAO {

    @PersistenceContext(unitName="sfb")
    protected EntityManager em;

    public void persisCar(Car car){
        em.persist(car);
    }

    public void update(Car car){
        em.merge(car);
    }
    public List<Car> getAllCars(){
       return em.createQuery("SELECT b FROM Car b").getResultList();
    }

}
