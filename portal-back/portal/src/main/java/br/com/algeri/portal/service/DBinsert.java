package br.com.algeri.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.algeri.portal.model.Categoria;
import br.com.algeri.portal.model.Usuario;
import br.com.algeri.portal.model.TipoUsuario;
import br.com.algeri.portal.model.Noticia;
import br.com.algeri.portal.model.Comentario;
import br.com.algeri.portal.model.Permissao;
import br.com.algeri.portal.repository.CategoriaRepository;
import br.com.algeri.portal.repository.UsuarioRepository;
import br.com.algeri.portal.repository.NoticiaRepository;
import br.com.algeri.portal.repository.ComentarioRepository;
import br.com.algeri.portal.repository.PermissaoRepository;


@Component
public class DBinsert implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    NoticiaRepository noticiaRepository;

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    PermissaoRepository permissaoRepository;

    @Override
    public void run(String... args) throws Exception {

        // Inserção de Categorias
        Categoria c1 = new Categoria("esportes", "notícias de esporte", null);
        categoriaRepository.save(c1);

        Categoria c2 = new Categoria("cinema", "notícias sobre cinema", null);
        categoriaRepository.save(c2);

        Categoria c3 = new Categoria("atualidades", "notícias de atualidades", null);
        categoriaRepository.save(c3);

        Categoria c4 = new Categoria("policial", "notícias de policial", null);
        categoriaRepository.save(c4);
 
        // Inserção de Usuários
        Usuario u1 = new Usuario("João Silva", "joao@email.com", "senha123", TipoUsuario.ADMINISTRADOR);
        usuarioRepository.save(u1);
        Usuario u2 = new Usuario("Maria Oliveira", "maria@email.com", "senha456", TipoUsuario.VISITANTE);
        usuarioRepository.save(u2);
        Usuario u3 = new Usuario("Pedro Souza", "pedro@email.com", "senha789", TipoUsuario.EDITOR);
        usuarioRepository.save(u3);

        // Inserção de Notícias
        Noticia n1 = new Noticia("Jogo histórico", "O time venceu por 3 a 0.", "...", c1, u3);
        noticiaRepository.save(n1);

        Noticia n2 = new Noticia("Lançamento de filme", "O novo filme da Marvel foi lançado.","...",  c2,u3);
        noticiaRepository.save(n2);

        Noticia n3 = new Noticia("Guerra em Gaza", "Atualizações sobre o conflito.", "...", c3,u3);
        noticiaRepository.save(n3);

        Noticia n4 = new Noticia("Assalto em banco", "Bandidos fazem reféns e roubam banco.","...",  c4, u3);
        noticiaRepository.save(n4);

        // Inserção de Comentários
        Comentario com1 = new Comentario("Que jogo incrível!", n1, u3);
        comentarioRepository.save(com1);
        Comentario com2 = new Comentario("Eu estava esperando por esse filme!", n3, u2);
        comentarioRepository.save(com2);
        Comentario com3 = new Comentario("Que situação horrível em Gaza!", n2, u3);
        comentarioRepository.save(com3);
        Comentario com4 = new Comentario("Espero que a polícia consiga resolver logo.", n1, u2);
        comentarioRepository.save(com4);
        
        // Inserção de Permissões
        Permissao p1 = new Permissao(TipoUsuario.EDITOR, "Pode editar e publicar notícias");
        permissaoRepository.save(p1);

        Permissao p2 = new Permissao(TipoUsuario.ADMINISTRADOR, "Pode editar, publicar e administrar");
        permissaoRepository.save(p2);

        Permissao p3 = new Permissao(TipoUsuario.VISITANTE, "Pode visualizar as notícias");
        permissaoRepository.save(p3);
    }
}
