package service;

import dao.BrandDAO;
import dao.CarDAO;
import dao.ColorDAO;
import lombok.Data;
import model.Brand;
import model.Car;
import model.Color;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Named
@Transactional
@ApplicationScoped
@Data
public class CarService {

    @Inject
    CarDAO carDAO;

    @Inject
    ColorDAO colorDAO;

    @Inject
    BrandDAO brandDAO;

    public void edit(Car car) {
        carDAO.update(car);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCarss();
    }

   public List<String> getColorsdb(){
        List<String> ColorsNames = new ArrayList<>();
        for (Color c:
                colorDAO.getAllColors()) {
            ColorsNames.add(c.getColor());
        }
        return ColorsNames;

    }

    public List<String> getBrandsdb() {
        List<String> BrandsName = new ArrayList<>();
        for (Brand b :
                brandDAO.getAllBrands()) {
            BrandsName.add(b.getBrand());
        }
        return BrandsName;
    }
}