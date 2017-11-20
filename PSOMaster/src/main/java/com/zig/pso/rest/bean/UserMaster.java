/************************************************************************************************************
 * Class Name :  UserMaster.java
 * Description:  
 * 
 * Author     :  Nilesh Patil
 * Date       :  Apr 8, 2017
 * **********************************************************************************************************
 */
package com.zig.pso.rest.bean;

import java.io.Serializable;

/**
 * 
 */
public class UserMaster implements Serializable
{
    private static final long serialVersionUID = 599983497115052464L;

    private Integer id;
    private String empId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String company;
    private int roleId;
    private String userRole;
    private int groupId;
    private String userGroup;
    private String status;
    private String tempPassword;
    
    
    /**
     * 
     */
    public UserMaster()
    {
        super();
    }


    /**
     * @param id
     * @param empId
     * @param username
     * @param password
     * @param email
     * @param firstName
     * @param lastName
     * @param company
     * @param roleId
     * @param userRole
     * @param groupId
     * @param userGroup
     */
    public UserMaster(Integer id, String empId, String username, String password, String email, String firstName, String lastName, String company, int roleId, String userRole, int groupId,
            String userGroup)
    {
        super();
        this.id = id;
        this.empId = empId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.roleId = roleId;
        this.userRole = userRole;
        this.groupId = groupId;
        this.userGroup = userGroup;
    }
    
   
    


    /**
     * @param empId
     * @param username
     * @param email
     * @param firstName
     * @param lastName
     * @param company
     * @param status
     */
    public UserMaster(String empId, String username, String email, String firstName, String lastName, String company, String status)
    {
        super();
        this.empId = empId;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.setStatus(status);
    }


    /**
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }


    /**
     * @param id the id to set
     */
    public void setId(Integer id)
    {
        this.id = id;
    }


    /**
     * @return the empId
     */
    public String getEmpId()
    {
        return empId;
    }


    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId)
    {
        this.empId = empId;
    }


    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }


    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
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
     * @return the company
     */
    public String getCompany()
    {
        return company;
    }


    /**
     * @param company the company to set
     */
    public void setCompany(String company)
    {
        this.company = company;
    }


    /**
     * @return the roleId
     */
    public int getRoleId()
    {
        return roleId;
    }


    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(int roleId)
    {
        this.roleId = roleId;
    }


    /**
     * @return the userRole
     */
    public String getUserRole()
    {
        return userRole;
    }


    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole)
    {
        this.userRole = userRole;
    }


    /**
     * @return the groupId
     */
    public int getGroupId()
    {
        return groupId;
    }


    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(int groupId)
    {
        this.groupId = groupId;
    }


    /**
     * @return the userGroup
     */
    public String getUserGroup()
    {
        return userGroup;
    }


    /**
     * @param userGroup the userGroup to set
     */
    public void setUserGroup(String userGroup)
    {
        this.userGroup = userGroup;
    }


    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }


    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the tempPassword
     */
    public String getTempPassword()
    {
        return tempPassword;
    }


    /**
     * @param tempPassword the tempPassword to set
     */
    public void setTempPassword(String tempPassword)
    {
        this.tempPassword = tempPassword;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((empId == null) ? 0 : empId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + groupId;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + roleId;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((tempPassword == null) ? 0 : tempPassword.hashCode());
        result = prime * result + ((userGroup == null) ? 0 : userGroup.hashCode());
        result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
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
        UserMaster other = (UserMaster) obj;
        if (company == null)
        {
            if (other.company != null)
                return false;
        }
        else if (!company.equals(other.company))
            return false;
        if (email == null)
        {
            if (other.email != null)
                return false;
        }
        else if (!email.equals(other.email))
            return false;
        if (empId == null)
        {
            if (other.empId != null)
                return false;
        }
        else if (!empId.equals(other.empId))
            return false;
        if (firstName == null)
        {
            if (other.firstName != null)
                return false;
        }
        else if (!firstName.equals(other.firstName))
            return false;
        if (groupId != other.groupId)
            return false;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (lastName == null)
        {
            if (other.lastName != null)
                return false;
        }
        else if (!lastName.equals(other.lastName))
            return false;
        if (password == null)
        {
            if (other.password != null)
                return false;
        }
        else if (!password.equals(other.password))
            return false;
        if (roleId != other.roleId)
            return false;
        if (status == null)
        {
            if (other.status != null)
                return false;
        }
        else if (!status.equals(other.status))
            return false;
        if (tempPassword == null)
        {
            if (other.tempPassword != null)
                return false;
        }
        else if (!tempPassword.equals(other.tempPassword))
            return false;
        if (userGroup == null)
        {
            if (other.userGroup != null)
                return false;
        }
        else if (!userGroup.equals(other.userGroup))
            return false;
        if (userRole == null)
        {
            if (other.userRole != null)
                return false;
        }
        else if (!userRole.equals(other.userRole))
            return false;
        if (username == null)
        {
            if (other.username != null)
                return false;
        }
        else if (!username.equals(other.username))
            return false;
        return true;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "UserMaster [id=" + id + ", empId=" + empId + ", username=" + username + ", password=" + password + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
                + ", company=" + company + ", roleId=" + roleId + ", userRole=" + userRole + ", groupId=" + groupId + ", userGroup=" + userGroup + ", status=" + status + ", tempPassword="
                + tempPassword + "]";
    }


    

}
