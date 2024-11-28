document.getElementById("login-form").addEventListener("submit", async (e) => {
    e.preventDefault(); // Evita o reload da página
  
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
  
    try {
      // Faz a requisição para o back-end
      const response = await fetch("http://localhost:8080/usuario/listar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email: email, senha: password }),
      });
  
      const data = await response.json();
  
      if (response.ok) {
        alert("passei aqui")
        // Sucesso: salva o token no localStorage e redireciona
        localStorage.setItem("token", data.token);
        alert("Login bem-sucedido!");
        window.location.href = "index.html"; // Redireciona para a página inicial
      } else {
        // Falha: exibe a mensagem de erro
        document.getElementById("login-message").textContent = data.message || "Erro ao fazer login.";
      }
    } catch (error) {
      // Exibe erro de conexão
      document.getElementById("login-message").textContent = "Erro ao conectar ao servidor.";
    }
  });
  