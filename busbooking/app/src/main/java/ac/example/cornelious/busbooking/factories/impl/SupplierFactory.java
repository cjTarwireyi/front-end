package ac.example.cornelious.busbooking.factories.impl;

import ac.example.cornelious.busbooking.domain.Supplier;

/**
 * Created by Cornelious on 5/12/2016.
 */
public class SupplierFactory {
    private  SupplierFactory supplierFactory=null;

    public SupplierFactory getInstance(){
        if (supplierFactory==null)
            supplierFactory=new SupplierFactory();
        return  supplierFactory;
    }
    public Supplier createSupplier(Long id,String name,String contact){
        Supplier supplier=new Supplier.SupplierBuilder()
                .id(id)
                .name(name)
                .contactNumber(contact)
                .build();
        return supplier;
    }
}
