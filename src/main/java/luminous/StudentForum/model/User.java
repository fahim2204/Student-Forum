package luminous.StudentForum.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;




@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 3, message = "Value must be greater than 3 character!!")
    private String username;

    @Column(nullable = false, length = 60)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 3, message = "Value must be greater than 3 character!!")
    private String name;

    @Column(nullable = false, length = 200)
    @NotNull(message = "Field can''t leave empty!!")
    @Size(min = 4, message = "Value must be greater than 4 character!!")
    private String password;

    @Transient
    @NotNull(message = "Field can''t leave empty!!")
    private String confirmPassword;

    @Column(nullable = false, columnDefinition = "varchar(50) default 'student'")
    private String type = "student";

    @Column(nullable = false, columnDefinition = "smallint(6) default 1")
    private int status = 1;

    @OneToMany(targetEntity = Post.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_user_id", referencedColumnName = "id" )
    private List<Post> posts;



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }




	@Override
	public String toString() {
		return "UserData [id=" + id + ", username=" + username + ", name=" + name + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", type=" + type + ", status=" + status + "]";
	}

}
