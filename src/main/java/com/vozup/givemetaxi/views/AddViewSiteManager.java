package com.vozup.givemetaxi.views;

import com.vozup.givemetaxi.entities.SiteManagersEntity;
import com.vozup.givemetaxi.repository.SiteManagersRepository;
import org.apache.commons.lang3.RandomUtils;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named("dtAddViewSiteManager")
public class AddViewSiteManager {
    private List<SiteManagersEntity> siteManager;
    private SiteManagersEntity SelectedSiteManager;
    @Inject
    SiteManagersRepository repository;

    @PostConstruct
    private void init(){

    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((SiteManagersEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((SiteManagersEntity) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new car to the table:
        SiteManagersEntity managersEntity = new SiteManagersEntity();
        int a = RandomUtils.nextInt(0, 100);
        managersEntity.setLogin("admin" + a);
        managersEntity.setPassword("admin" + a);


        siteManager.add(managersEntity);
        repository.save(managersEntity);

        FacesMessage msg = new FacesMessage("New Manager added", managersEntity.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<SiteManagersEntity> getSiteManager() {
        siteManager = new ArrayList<>(repository.findAll());
        return siteManager;
    }

    public void setSiteManager(List<SiteManagersEntity> siteManager) {
        this.siteManager = siteManager;
    }

    public SiteManagersEntity getSelectedSiteManager() {
        return SelectedSiteManager;
    }

    public void setSelectedSiteManager(SiteManagersEntity selectedSiteManager) {
        SelectedSiteManager = selectedSiteManager;
    }
}
