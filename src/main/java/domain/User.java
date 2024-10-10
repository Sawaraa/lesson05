package domain;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private boolean isUser;

    public User(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = "user";  // Автоматично встановлюється роль "user"
        this.isUser = true;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString(){
        return "First name: " + firstName + ";  " +
                "Last name: " + lastName + ";  " +
                "Email" + email + ";  " +
                "Password: " + password;
    }
}
