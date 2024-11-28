package br.com.algeri.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer id;

    @Column(name = "texto", nullable = false)
    private String texto;

    @Column(name = "data_comentario", nullable = false)
    private LocalDateTime dataComentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_noticia", nullable = false)
    private Noticia noticia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Comentario(String texto, Noticia noticia, Usuario usuario) {
        this.texto = texto;
        this.dataComentario = LocalDateTime.now();
        this.noticia = noticia;
        this.usuario = usuario;
    }
}
