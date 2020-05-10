package shoppingList.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class ProductDTO {
    @NotNull(groups = {Update.class})
    @Null(groups = {Create.class})
    private Long id;
    @NotEmpty(groups = {Update.class, Create.class}, message = "Name must be not blank.")
    private String name;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public interface Update {
        // empty interface
    }

    public interface Create {
        // empty interface
    }
}
