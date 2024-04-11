package softuni.exam.models.Dto;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)

public class SellerSeedRootDto {
@XmlElement (name = "seller")
   private List<SellerRootDto> sellers;

    public List<SellerRootDto> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerRootDto> sellers) {
        this.sellers = sellers;
    }
}
