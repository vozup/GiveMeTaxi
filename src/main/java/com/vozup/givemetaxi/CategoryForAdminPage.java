package com.vozup.givemetaxi;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named("category")
public class CategoryForAdminPage {
    private Map<String, String> categories;
    private String selectedCategory;

    @PostConstruct
    private void init() {
        categories = new HashMap<>();
        categories.put("index", "common.xhtml");
        categories.put("drivers", "drivers.xhtml");
        categories.put("operators", "operator.xhtml");
        categories.put("orders", "driver-statistic.xhtml");
        categories.put("site-managers", "site-managers.xhtml");
        categories.put("logs", "log.xhtml");

        selectedCategory = "index";
    }

    public String pageFromCategory() {
        return categories.get(selectedCategory);
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }
}
