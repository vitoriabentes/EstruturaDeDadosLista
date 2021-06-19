import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter @Setter @ToString @NoArgsConstructor
@AllArgsConstructor @EqualsAndHashCode
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String email;

}
