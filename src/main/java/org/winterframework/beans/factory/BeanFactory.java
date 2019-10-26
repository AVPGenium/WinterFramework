package org.winterframework.beans.factory;

import org.winterframework.beans.factory.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    private Map<String, Object> singletons = new HashMap();

    public Object getBean(String beanName){
        return singletons.get(beanName);
    }

    public void instantiate(String basePackage) throws IOException, URISyntaxException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String path = basePackage.replace('.', '/'); //"ru.apolyakov" -> "ru/apolyakov"
        Enumeration<URL> resources = classLoader.getResources(path);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File file = new File(resource.toURI());
            for(File classFile : file.listFiles()){
                String fileName = classFile.getName();//ProductService.class
                if(fileName.endsWith(".class")){
                    String className = fileName.substring(0, fileName.lastIndexOf("."));
                    Class classObject = Class.forName(basePackage + "." + className);
                    if(classObject.isAnnotationPresent(Component.class)){
                        System.out.println("Component: " + classObject);
                        Object instance = classObject.newInstance();//=new CustomClass()
                        String beanName = className.substring(0, 1).toLowerCase() + className.substring(1);
                        singletons.put(beanName, instance);
                    }
                }
            }
        }
    }
}
