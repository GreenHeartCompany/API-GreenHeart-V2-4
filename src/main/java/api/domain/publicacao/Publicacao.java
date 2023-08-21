package api.domain.publicacao;

import api.domain.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacao")
    private Long id;
    private String titulo;
    private String descricao;
    private String tipoAcao;
    private Time totalHrTrabalho;
    private String nomeOrganizador;
    private String emailOrganizador;
    private String telOrganizador;
    @ManyToOne
    @JoinColumn(name = "fk_empresa")
    private Empresa fkEmpresa;
}
