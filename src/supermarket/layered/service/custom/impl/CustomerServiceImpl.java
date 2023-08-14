/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket.layered.service.custom.impl;

import java.util.ArrayList;
import supermarket.layered.dao.DaoFactory;
import supermarket.layered.dao.custom.CustomerDao;
import supermarket.layered.dto.CustomerDto;
import supermarket.layered.entity.CustomerEntity;
import supermarket.layered.service.custom.CustomerService;

/**
 *
 * @author sachinthadilshan
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getInstance().getDao(DaoFactory.DaoType.CUSTOMER);

    @Override
    public String addCustomer(CustomerDto customer) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                customer.getId(),
                customer.getTitle(),
                customer.getName(),
                customer.getDob(),
                customer.getSalary(),
                customer.getAddress(),
                customer.getCity(),
                customer.getProvince(),
                customer.getZip()
        );
        if (customerDao.add(customerEntity)) {
            return "Customer Added Successfully";
        } else {
            return "Customer Addition Failed";
        }

    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws Exception {
        ArrayList<CustomerDto> customers = new ArrayList<>();
        ArrayList<CustomerEntity> customerEntitys = customerDao.getAll();
        for (CustomerEntity customer : customerEntitys) {
            customers.add(new CustomerDto(
                    customer.getId(),
                    customer.getTitle(),
                    customer.getName(),
                    customer.getDob(),
                    customer.getSalary(),
                    customer.getAddress(),
                    customer.getCity(),
                    customer.getProvince(),
                    customer.getZip()
            ));
        }
        return customers;
    }

    @Override
    public CustomerDto getCustomer(String customerId) throws Exception {
        CustomerEntity customer = customerDao.get(customerId);
        return new CustomerDto(
                customer.getId(),
                customer.getTitle(),
                customer.getName(),
                customer.getDob(),
                customer.getSalary(),
                customer.getAddress(),
                customer.getCity(),
                customer.getProvince(),
                customer.getZip());

    }

    @Override
    public String updateCustomer(CustomerDto customer) throws Exception {
        CustomerEntity customerEntity = new CustomerEntity(
                customer.getId(),
                customer.getTitle(),
                customer.getName(),
                customer.getDob(),
                customer.getSalary(),
                customer.getAddress(),
                customer.getCity(),
                customer.getProvince(),
                customer.getZip());
        if(customerDao.update(customerEntity)){
            return "Customer Updated Successfully";
        }else{
            return "Customer Update Failed";
        }
    }

    @Override
    public String deleteCustomer(String customerId) throws Exception {
          if(customerDao.delete(customerId)){
              return "Customer Deleted Successfully";
          }else{
              return "Customer Deletion Failed";
          }  
    }

    @Override
    public String getLastId() throws Exception {
        return "C" + String.format("%03d", Integer.parseInt(customerDao.getLastID().substring(1)) + 1);

    }

}
