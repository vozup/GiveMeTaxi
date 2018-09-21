package com.vozup.givemetaxi.views;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Named
public class AdditionalService {
    private Set<String> additionalServiceSet;
    private List<String> selectedAdditionalService;

    @PostConstruct
    public void init(){
        additionalServiceSet = new HashSet<>();
        additionalServiceSet.add("Водитель не курит");
        additionalServiceSet.add("Багаж");
        additionalServiceSet.add("Перевозка животного");
        additionalServiceSet.add("Драйвер");
        additionalServiceSet.add("Неразговорчивый водитель");
    }

    public List<String> getSelectedAdditionalService() {
        return selectedAdditionalService;
    }

    public void setSelectedAdditionalService(List<String> selectedAdditionalService) {
        this.selectedAdditionalService = selectedAdditionalService;
    }

    public Set<String> getAdditionalServiceList() {
        return additionalServiceSet;
    }

    public void setAdditionalServiceList(Set<String> additionalServiceList) {
        this.additionalServiceSet = additionalServiceList;
    }
}
