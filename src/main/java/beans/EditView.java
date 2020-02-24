package beans;

import lombok.Data;
import model.Car;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import service.CarService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named("dtEditView")
@ViewScoped
@Data
@Transactional
public class EditView implements Serializable {

    private List<Car> cars1;
    private List<Car> cars2;

    private String text;

    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars1 = service.getAllCars();
        cars2 = service.getAllCars();

    }

    public void exampleButton(){
        text="You have druck a Bottom :D";
        //return "index?faces-redirect=true";
    }
    public List<Car> getCars1() {
        return cars1;
    }

    public List<Car> getCars2() {
        return cars2;
    }

    public List<String> getBrands() {
        List<String> brands= service.getBrandsdb();
        return brands;
    }

    public List<String> getColors() {
        List<String> colors= service.getColorsdb();
        return colors;
    }

    public void onRowEdit(RowEditEvent event) {
        service.edit((Car) event.getObject());
        FacesMessage msg = new FacesMessage("Car Edited", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {

        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}