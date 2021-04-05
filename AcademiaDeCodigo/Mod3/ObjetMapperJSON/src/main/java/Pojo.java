import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pojo {

    @JsonIgnore
    private success success = new success();
    private contents contents = new contents();

    @Override
    public String toString() {
        return "Pojo{" +
                "contents=" + contents +
                '}';
    }
}
