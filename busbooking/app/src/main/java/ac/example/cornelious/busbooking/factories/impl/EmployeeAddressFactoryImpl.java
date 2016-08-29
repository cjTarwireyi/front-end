package ac.example.cornelious.busbooking.factories.impl;

import ac.example.cornelious.busbooking.factories.IAddressFactory;
import ac.example.cornelious.busbooking.domain.EmpAddressVO;

/**
 * Created by Cornelious on 4/14/2016.
 */
public class EmployeeAddressFactoryImpl extends IAddressFactory {
    private static EmployeeAddressFactoryImpl objAddressFactory=null;
    public static EmployeeAddressFactoryImpl getInstance()
    {
        if (objAddressFactory==null)
            objAddressFactory=new EmployeeAddressFactoryImpl();
        return objAddressFactory;
    }
    @Override
    public EmpAddressVO createEmployeeAddress(Long id, String street, String city, String code){
        EmpAddressVO objAddress= new EmpAddressVO.AddressBuilder()
                .id(id)
                .street(street)
                .city(city)
                .code(code)
                .build();
        return objAddress;
        }


}
