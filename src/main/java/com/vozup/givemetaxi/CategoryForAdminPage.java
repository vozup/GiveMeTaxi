package com.vozup.givemetaxi;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named("category")
public class CategoryForAdminPage {
    private Map<String, String> categories;
    private String page;
    private String selectedCategory;

    @PostConstruct
    private void init() {
        categories = new HashMap<>();
        categories.put("index", "hello.xhtml");
        categories.put("drivers", "drivers.xhtml");
        categories.put("operators", "operators.xhtml");
        categories.put("orders", "order-statistic.xhtml");
        categories.put("site-managers", "site-managers.xhtml");
        categories.put("logs", "log.xhtml");

        selectedCategory = "index";
    }

    public String getPage() {
        return page = categories.get(selectedCategory);
    }

    public void setPage(String page) {
        this.page = page;
    }

    private void pageFromCategory() {
        page = categories.get(selectedCategory);
    }

    public String getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(String selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }
}
