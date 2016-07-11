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

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip_code;

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public void setPhone_number(String phone_number)
    {
        this.phone_number = phone_number;
    }

    public String getAddress1()
    {
        return address1;
    }

    public void setAddress1(String address1)
    {
        this.address1 = address1;
    }

    public String getAddress2()
    {
        return address2;
    }

    public void setAddress2(String address2)
    {
        this.address2 = address2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZip_code()
    {
        return zip_code;
    }

    public void setZip_code(String zip_code)
    {
        this.zip_code = zip_code;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
        result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
        result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((zip_code == null) ? 0 : zip_code.hashCode());
        return result;
    }

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
        if (first_name == null)
        {
            if (other.first_name != null)
                return false;
        }
        else if (!first_name.equals(other.first_name))
            return false;
        if (last_name == null)
        {
            if (other.last_name != null)
                return false;
        }
        else if (!last_name.equals(other.last_name))
            return false;
        if (phone_number == null)
        {
            if (other.phone_number != null)
                return false;
        }
        else if (!phone_number.equals(other.phone_number))
            return false;
        if (state == null)
        {
            if (other.state != null)
                return false;
        }
        else if (!state.equals(other.state))
            return false;
        if (zip_code == null)
        {
            if (other.zip_code != null)
                return false;
        }
        else if (!zip_code.equals(other.zip_code))
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "PortalEnrollmentInfo [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone_number=" + phone_number + ", address1=" + address1 + ", address2="
                + address2 + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code + "]";
    }

}
