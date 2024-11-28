// Função para carregar notícias
function carregarNoticias() {
  const container = document.getElementById("news-container");

  // Limpa o container antes de renderizar
  container.innerHTML = "";

  fetch("http://localhost:8080/noticia/listar")
    .then(response => {
      if (!response.ok) {
        throw new Error(`Erro ao buscar notícias: ${response.statusText}`);
      }
      return response.json(); // Converter para JSON
    })
    .then(noticias => {
      imprimirMensagensNaTela(noticias); // Renderizar as notícias
    })
    .catch(err => {
      console.error("Erro de solicitação:", err);
      container.innerHTML = `<div class="w3-red w3-padding">Erro ao carregar notícias. Tente novamente mais tarde.</div>`;
    });

  // Função para renderizar notícias na tela
  function imprimirMensagensNaTela(noticias) {
    if (noticias.length === 0) {
      container.innerHTML = `<div class="w3-yellow w3-padding">Nenhuma notícia disponível no momento.</div>`;
      return;
    }

    noticias.forEach((noticia) => {
      const newsItem = document.createElement("div");
      newsItem.classList.add("w3-card", "w3-margin", "w3-padding");

      newsItem.innerHTML = `
        <h2 class="news-title w3-text-green">${noticia.titulo}</h2>
        <p class="news-category"><strong>Categoria:</strong> ${noticia.categoria}</p>
        <p class="news-date"><strong>Publicado em:</strong> ${noticia.dataPublicacao}</p>
      `;

      container.appendChild(newsItem);
    });
  }
}

// Chama a função ao carregar o script
carregarNoticias();

// Função para redirecionar para login
function fazerLogin() {
  alert("Redirecionando para a página de login...");
  window.location.href = "login.html";
}
