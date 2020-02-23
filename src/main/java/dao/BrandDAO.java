package dao;

import model.Brand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BrandDAO {
    @PersistenceContext(unitName="sfb")
    protected EntityManager em;

    public void persisCar(Brand brand){
        em.persist(brand);
    }

    public void update(Brand brand){
        em.merge(brand);
    }

    public List<Brand> getAllBrands(){
        return em.createQuery("SELECT b FROM Brand b").getResultList();
    }
}
