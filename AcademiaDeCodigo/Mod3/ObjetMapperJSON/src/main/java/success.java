import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class success {

    @JsonIgnore
    private String total;

    public String getTotal() {
        return total;
    }

    public void setSuccess(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Success{" +
                "success='" + getTotal() + '\'' +
                '}';
    }
}
