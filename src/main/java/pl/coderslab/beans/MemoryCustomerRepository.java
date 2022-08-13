package pl.coderslab.beans;

import java.util.ArrayList;
public class MemoryCustomerRepository implements CustomerRepository {

    private final ArrayList<Customer> customerList = new ArrayList<>();

    private FileCustomerLogger fileCustomerLogger;

    public MemoryCustomerRepository(FileCustomerLogger fileCustomerLogger) {
        this.fileCustomerLogger = fileCustomerLogger;
    }

    public FileCustomerLogger getFileCustomerLogger() {
        return fileCustomerLogger;
    }

    public void setFileCustomerLogger(FileCustomerLogger fileCustomerLogger) {
        this.fileCustomerLogger = fileCustomerLogger;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
        fileCustomerLogger.log();
    }

    @Override
    public void delete(Customer customer) {
        customerList.removeIf(c -> c.getId() == customer.getId());
        fileCustomerLogger.log();
    }

    @Override
    public void list() {
        customerList.forEach(System.out::println);
        fileCustomerLogger.log();
    }
}
