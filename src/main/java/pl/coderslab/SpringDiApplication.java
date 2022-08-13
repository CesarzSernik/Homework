package pl.coderslab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.coderslab.beans.Customer;
import pl.coderslab.beans.FileCustomerLogger;
import pl.coderslab.beans.MemoryCustomerRepository;

public class SpringDiApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);

        FileCustomerLogger fcl = ctx.getBean(FileCustomerLogger.class);
        fcl.log();

        MemoryCustomerRepository mcr = ctx.getBean(MemoryCustomerRepository.class);
        mcr.add(new Customer(1,"Mateusz","Bruzgo"));
        mcr.add(new Customer(2,"Wezewiusz","Kakabumba"));
        mcr.add(new Customer(3,"Henryk","Haihachi"));
        mcr.add(new Customer(4,"Yoshimitsu","Daikatsu"));

        mcr.delete(new Customer(1,"Mateusz","Bruzgo"));

        mcr.list();
        ctx.close();
    }
}
