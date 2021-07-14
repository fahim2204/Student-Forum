package luminous.StudentForum.model;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginData {
    @NotBlank(message = "User Name can't leave empty!!")
    // @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Please type valid Email Address!!")
    private String userName;
    // @Min(value = 6, message = "Length must be more than 6 character")
    // @Size(min=2, max=5)
    //@Min(value= 6)
    // @NotBlank(message = "Password can't leave empty")
    //@NotNull
	//@Min(8) //////Min is for the value; not character size
    @Size(min=6)
    private String password;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "LoginData [userName = " + userName + ", Password = " + password + "]";
    }

}
