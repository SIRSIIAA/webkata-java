package sirsiiaa.webkata.java.service.servicefactorybean;

import org.springframework.beans.factory.FactoryBean;
import sirsiiaa.webkata.java.service.ComplexService;

public class ComplexServiceFactoryBean implements FactoryBean<ComplexService> {

    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ComplexService getObject() throws Exception {
        return new ComplexService(name, id);
    }

    @Override
    public Class<?> getObjectType() {
        return ComplexService.class;
    }
}
