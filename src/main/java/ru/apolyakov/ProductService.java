package ru.apolyakov;

import org.winterframework.beans.factory.stereotype.Component;

@Component
public class ProductService {
    private PromotionsService promotionsService;

    public PromotionsService getPromotionsService() {
        return promotionsService;
    }

    public void setPromotionsService(PromotionsService promotionsService) {
        this.promotionsService = promotionsService;
    }
}