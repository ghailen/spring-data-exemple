package com.sig.springdata;

import com.sig.springdata.dao.EtudiantRepository;
import com.sig.springdata.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;

    public static void main(String[] args) {

        // ApplicationContext context = SpringApplication.run(SpringdataApplication.class, args);
        /** on dit à spring cherche moi une classe qui impélemnte l'interface
         * etudiant repositroy
         */
        //EtudiantRepository etudiantRepository = context.getBean(EtudiantRepository.class);
        SpringApplication.run(SpringdataApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {

        etudiantRepository.save(new Etudiant(null, "mohamed", "mohamed@gmail.com", new Date(), 45));

        etudiantRepository.save(new Etudiant(null, "ghailene", "ghailene@gmail.com", new Date(), 100));
        etudiantRepository.save(new Etudiant(null, "mariem", "mariem@gmail.com", new Date(), 50));

        etudiantRepository.findAll().forEach(et -> {
            System.out.println(et.toString());
        });
        System.out.println("************************");
        Etudiant et = etudiantRepository.findById(1L).get();
        System.out.println(et.getName());
        System.out.println("*********************");
        etudiantRepository.findByScore(100).forEach(el->{
            System.out.println(el.getName());
        });

    }
}
