package api.domain.usuario;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_usuario", discriminatorType = DiscriminatorType.STRING)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "isPlanoAtivo")
    private Boolean isPlanoAtivo;
}
