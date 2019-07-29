package io.jmlim.usingjeongmukbootstarter;

import io.jmlim.jeongmukbootstarter.Jeongmuk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class JeongmukRunner implements ApplicationRunner {

    @Autowired
    Jeongmuk jeongmuk;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(jeongmuk);
    }
}
