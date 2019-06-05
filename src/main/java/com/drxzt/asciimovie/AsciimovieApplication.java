package com.drxzt.asciimovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@SpringBootApplication
public class AsciimovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsciimovieApplication.class, args);
    }


}
