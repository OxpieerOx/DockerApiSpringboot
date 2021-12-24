package ApiAnuncioAlbergue.dto;

        import lombok.Data;

@Data
public class Dto<T> {

    private String message;

    private boolean success;

    private String estado;

    private T data;

}
