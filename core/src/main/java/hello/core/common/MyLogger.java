package hello.core.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requesURL;

    public void setRequesURL(String requesURL) {
        this.requesURL = requesURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requesURL + "] " +  message);
    }


    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }


    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "]" + "[close]" + this);
    }
}
