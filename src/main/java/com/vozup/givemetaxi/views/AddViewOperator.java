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
import javax.transaction.Transactional;
import java.util.List;

@Named("dtOperator")
public class AddViewOperator {
    private List<OperatorEntity> operatorEntityList;
    private OperatorEntity selectedOperator;
    @Inject
    OperatorRepository repository;

    @Transactional
    public void onRowEdit(RowEditEvent event){
        OperatorEntity updated = (OperatorEntity) event.getObject();

        repository.updateOperator(updated.getId(), updated.getLogin(), updated.getPassword(),
                updated.getName(), updated.getLastName());

        FacesMessage msg = new FacesMessage("Operator Edited", ((OperatorEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((OperatorEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        OperatorEntity operatorEntity = new OperatorEntity();
        int a = RandomUtils.nextInt(0, 100);
        operatorEntity.setLogin("operator" + a);
        operatorEntity.setPassword("operator" + a);

        repository.save(operatorEntity);

        FacesMessage msg = new FacesMessage("New Operator added", operatorEntity.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<OperatorEntity> getOperatorEntityList() {
        operatorEntityList = repository.findAll();
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
