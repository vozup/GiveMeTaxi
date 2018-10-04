package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.entities.OperatorEntity;
import com.vozup.givemetaxi.entities.SiteManagersEntity;
import com.vozup.givemetaxi.repository.OperatorRepository;
import org.apache.commons.lang3.RandomUtils;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("dtOperator")
public class AddViewOperator {
    private List<OperatorEntity> operatorEntityList;
    private OperatorEntity selectedOperator;
    @Inject
    OperatorRepository repository;

    public void onRowEdit(RowEditEvent event) throws Exception {
        OperatorEntity temp = (OperatorEntity) event.getObject();
        //System.out.println(sm.getLogin());
        //OperatorEntity operatorEntity = repository.findById(temp.getId()).orElseThrow(() ->new Exception("Empty object"));

        FacesMessage msg = new FacesMessage("Manager Edited", ((SiteManagersEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((SiteManagersEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        OperatorEntity operatorEntity = new OperatorEntity();
        int a = RandomUtils.nextInt(0, 100);
        operatorEntity.setLogin("operator" + a);
        operatorEntity.setPassword("operator" + a);

        repository.save(operatorEntity);

        FacesMessage msg = new FacesMessage("New Manager added", operatorEntity.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<OperatorEntity> getOperatorEntityList() {
        return operatorEntityList;
    }

    public void setOperatorEntityList(List<OperatorEntity> operatorEntityList) {
        this.operatorEntityList = operatorEntityList;
    }

    public OperatorEntity getSelectedOperator() {
        return selectedOperator;
    }

    public void setSelectedOperator(OperatorEntity selectedOperator) {
        this.selectedOperator = selectedOperator;
    }
}
