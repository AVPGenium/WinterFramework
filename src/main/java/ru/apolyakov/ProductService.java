package ru.apolyakov;

import org.winterframework.beans.factory.annotation.Autowired;
import org.winterframework.beans.factory.stereotype.Component;

@Component
public class ProductService {
    @Autowired
    private PromotionsService promotionsService;

    public PromotionsService getPromotionsService() {
        return promotionsService;
    }

    public void setPromotionsService(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }
}
