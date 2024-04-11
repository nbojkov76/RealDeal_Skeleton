package softuni.exam.models.Dto;

import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import softuni.exam.models.entity.Rating;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class SellerRootDto {

@XmlElement(name = "first-name")
    private String firstName;
@XmlElement(name = "last-name")
    private String lastName;
@XmlElement
    private String email;
@XmlElement
    private Rating rating;
@XmlElement
    private String town;

    @Size(min = 2,max = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Size(min = 2,max = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
@Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
@NotNull
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
@NotBlank
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
