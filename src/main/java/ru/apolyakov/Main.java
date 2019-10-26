package ru.apolyakov;

import org.winterframework.beans.factory.BeanFactory;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, URISyntaxException, InstantiationException, IllegalAccessException {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("ru.apolyakov");
        ProductService productService = (ProductService) beanFactory.getBean("productService");
        System.out.println(productService);//ProductService@612
    }
}
