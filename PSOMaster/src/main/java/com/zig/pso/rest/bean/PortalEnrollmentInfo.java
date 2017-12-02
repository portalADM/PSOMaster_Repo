/************************************************************************************************************
 * Class Name : PortalEnrollmentInfo.java Description:
 * 
 * Author : Ankita Mishra Date : Jul 7, 2016 **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class PortalEnrollmentInfo implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 5078977241507762853L;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    /**
     * 
     */
    public PortalEnrollmentInfo()
    {
        super();
    }
    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param zipCode
     */
    public PortalEnrollmentInfo(String firstName, String lastName, String email, String phoneNumber, String address1, String address2, String city, String state, String zipCode)
    {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    /**
     * @return the address1
     */
    public String getAddress1()
    {
        return address1;
    }
    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }
    /**
     * @return the address2
     */
    public String getAddress2()
    {
        return address2;
    }
    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }
    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(String city)
    {
        this.city = city;
    }
    /**
     * @return the state
     */
    public String getState()
    {
        return state;
    }
    /**
     * @param state the state to set
     */
    public void setState(String state)
    {
        this.state = state;
    }
    /**
     * @return the zipCode
     */
    public String getZipCode()
    {
        return zipCode;
    }
    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
        result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
        return result;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PortalEnrollmentInfo other = (PortalEnrollmentInfo) obj;
        if (address1 == null)
        {
            if (other.address1 != null)
                return false;
        }
        else if (!address1.equals(other.address1))
            return false;
        if (address2 == null)
        {
            if (other.address2 != null)
                return false;
        }
        else if (!address2.equals(other.address2))
            return false;
        if (city == null)
        {
            if (other.city != null)
                return false;
        }
        else if (!city.equals(other.city))
            return false;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (phoneNumber == null)
        {
            if (other.phoneNumber != null)
                return false;
        }
        else if (!phoneNumber.equals(other.phoneNumber))
            return false;
        if (state == null)
        {
            if (other.state != null)
                return false;
        }
        else if (!state.equals(other.state))
            return false;
        if (zipCode == null)
        {
            if (other.zipCode != null)
                return false;
        }
        else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "PortalEnrollmentInfo [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", address1=" + address1 + ", address2=" + address2
                + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
    }

    

}
