package api.domain.endereco;

import api.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    @JsonIgnore
    @Getter
    private Long id;
    @Column(name = "logradouro")
    private String logradouro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "complemento")
    private String complemento;
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    @JsonIgnore
    private Usuario usuario;
}
