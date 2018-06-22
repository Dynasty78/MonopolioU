package login;

import java.io.Serializable;

/**
 *
 * @author samuel
 */
public class User implements Serializable{
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String action;
    
    /*Registration*/
    public User(String name, String lastname, String username, String password,String action){
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.action = action;
    }
    
    /*Login*/
    public User(String username, String password, String action){
        this.username = username;
        this.password = password;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getAction(){
        return action;
    }
    
    public void setAction(String action){
        this.action = action;
    }
        
}
