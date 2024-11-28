package br.com.algeri.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @Column(name = "permissao", nullable = false)
    private String permissao;

    public Permissao(TipoUsuario tipoUsuario, String permissao) {
        this.tipoUsuario = tipoUsuario;
        this.permissao = permissao;
    }


}
