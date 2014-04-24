package de.coderebell.tts.client.domain;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by MALPI on 24.04.2014.
 */
@Entity
@Portable
@Bindable
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9056681606113744909L;

    @Version
    private Integer version;

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String name;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", firstName=" + firstName + ", name="
                + name + ", userName=" + userName + ", password=" + password
                + "]";
    }
}
