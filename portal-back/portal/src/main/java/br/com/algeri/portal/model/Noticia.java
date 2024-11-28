package br.com.algeri.portal.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "noticia")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_noticia")
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "corpo", nullable = false)
    private String corpo;

    @Column(name = "data_publicacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dataPublicacao;

    @Column(name = "imagem_url")
    private String imagemUrl;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "id_editor", referencedColumnName = "id_usuario")
    private Usuario editor;

    public Noticia(String titulo, String corpo, String imagemUrl, Categoria categoria, Usuario editor) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.dataPublicacao = LocalDateTime.now();
        this.imagemUrl = imagemUrl;
        this.categoria = categoria;
        this.editor = editor;
    }
}
