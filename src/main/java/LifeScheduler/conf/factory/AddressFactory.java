package LifeScheduler.conf.factory;

import LifeScheduler.Domain.Address;

/**
 * Created by Michael on 05/05/2015.
 */
public class AddressFactory
{
    public static Address createAddress(String streetName,String houseNumber,String suburb,String postalCode)
    {
        Address address = new Address.Builder(streetName,houseNumber,suburb,postalCode).build();
        return address;
    }
}
