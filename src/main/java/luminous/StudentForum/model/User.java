package luminous.StudentForum.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank
    private String userName;

    @Column(nullable = false, length = 60)
    @NotBlank
    private String name;

    @Column(nullable = false, length = 200)
    @NotBlank
    @Size(min = 4)
    private String password;

    @Transient
    private String confirmPassword;

    @Column(nullable = false, columnDefinition = "varchar(50) default 'student'")
    private String type = "student";

    @Column(nullable = false, columnDefinition = "smallint(6) default 1")
    private short status = 1;


    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
    public short getStatus() {
        return status;
    }
    public void setStatus(short status) {
        this.status = status;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
	@Override
	public String toString() {
		return "UserData [id=" + id + ", userName=" + userName + ", name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", type=" + type + ", status=" + status + "]";
	}

}
