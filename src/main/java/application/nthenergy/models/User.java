/*
 * User.java
 * User class which encapsulates attributes and methods of the User class.
 *
 * @author: Ashwin Gurung
 */
package application.nthenergy.models;

import application.nthenergy.core.enums.AccountStatus;
import application.nthenergy.core.enums.UserType;

import java.io.Serializable;
import java.security.Timestamp;

public class User implements Serializable {
    // private attributes of the user class
    private int userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private UserType userType;
    private String email;
    private String username;
    private String password;
    private String mobNo;
    private AccountStatus accountStatus;
    private String remarks;
    private long createdAt;
    private long updatedAt;

    // getters and setters for the attributes
    /**
     * This method is used to return user id.
     * @param none
     * @return int userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * This method is used to set user id.
     * @param int userId
     * @return void
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * This method is used to return first name.
     * @param none
     * @return String firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method is used to set user's first name.
     * @param String firstName
     * @return void
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method is used to return middle name.
     * @param none
     * @return String middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * This method is used to set user's middle name.
     * @param String middleName
     * @return void
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * This method is used to return user's last name.
     * @param none
     * @return String lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method is used to set user's last name.
     * @param String lastName
     * @return void
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method is used to return user type.
     * @param none
     * @return UserType userType
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * This method is used to set user type.
     * @param UserType userType
     * @return void
     */
    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * This method is used to return user's email.
     * @param none
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method is used to set user's email.
     * @param String email
     * @return void
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method is used to return username.
     * @param none
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method is used to set username.
     * @param String username
     * @return void
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method is used to return password.
     * @param none
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to set user's password.
     * @param String password
     * @return void
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method is used to return user's mobile number.
     * @param none
     * @return String mobNo
     */
    public String getMobNo() {
        return mobNo;
    }

    /**
     * This method is used to set user's mobile number.
     * @param String mobNo
     * @return void
     */
    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    /**
     * This method is used to return user's account status.
     * @param none
     * @return AccountStatus accountStatus
     */
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    /**
     * This method is used to set user's account status.
     * @param AccountStatus accountStatus
     * @return void
     */
    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * This method is used to return remarks.
     * @param none
     * @return String remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method is used to set remarks.
     * @param String remarks
     * @return void
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method is used to return the timestamp of created at.
     * @param none
     * @return long createdAt
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * This method is used to set created at timestamp.
     * @param long createdAt
     * @return void
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method is used to return the timestamp of updated at.
     * @param none
     * @return long updatedAt
     */
    public long getUpdatedAt() {
        return updatedAt;
    }


    public User() {

    }

    public User(int userId, String firstName, String middleName, String lastName, UserType userType, String email, String username, String password, String mobNo, AccountStatus accountStatus, String remarks, long createdAt, long updatedAt) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userType = userType;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobNo = mobNo;
        this.accountStatus = accountStatus;
        this.remarks = remarks;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /**
     * This method is used to set updated at.
     * @param long updatedAt
     * @return void
     */
    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

}
