package dao;

import model.Color;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ColorDAO {
    @PersistenceContext(unitName="sfb")
    protected EntityManager em;

    public void persisColor(Color color){
        em.persist(color);
    }

    public void update(Color Color){
        em.merge(Color);
    }
    public List<Color> getAllColors(){
        return em.createQuery("SELECT b FROM Color b").getResultList();
    }

}
