package App.Entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JokeForm {

    @NotNull
    @Size(min = 1)
    private String content;
    @NotNull
    private Integer category;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.content + " : " + this.category;
    }
}
