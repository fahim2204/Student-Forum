package luminous.StudentForum.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistrationData {
    @NotBlank
    @Size(min=3)
    private String userName;
    @NotBlank
    @Size(min=3)
    private String name;
    @NotBlank
    @Size(min=6)
    private String password;

    private String confirmPassword;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    




}
