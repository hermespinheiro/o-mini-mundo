# 🚀 Mini Mundo - Projeto de Laboratório para Testes e Avaliações Técnicas  

## 📌 Sobre o Projeto  

O **Mini Mundo** é um projeto de laboratório destinado a testes e implementações de validação técnica para seleção de desenvolvedores. Ele permite avaliar candidatos por meio da implementação de **issues específicas**, garantindo que sigam boas práticas de desenvolvimento, versionamento e deploy contínuo.  

Cada avaliação requer que o candidato implemente uma ou mais **issues**, seguindo um fluxo padronizado que envolve:  

✅ **Uso de Conventional Commit e Gitflow** para organização do histórico de commits.  
✅ **Uso container Docker para desenvolvimento** deixando a máquina do dev livre de instalações de ferramentas do projeto.  
✅ **Criação de uma imagem Docker** para execução do projeto após a compilação.  
✅ **Registro da imagem no Docker Hub** para facilitar a distribuição.  
✅ **Configuração de CI/CD** para automação do build e versionamento da imagem.  

## 🛠️ Requisitos da Avaliação  

Durante a implementação, o candidato deverá:  

1. Fazer as devidas implementações:
   1.1. Implementar tela de login, utilizando Token JWT para manter a sessão;
   1.2. Implementar CRUD de projeto;
   1.3. Implementar CRUD de tarefa, associado a projeto;
   1.4. Cada implementação deve seguir o arquivo md com as instruções correspondentes;
   1.5. Cada implementação deve ser considerada com uma Issue.
   1.6. Seguir a convenção de commits **Conventional Commit** e o fluxo **Gitflow**.  

2. Criar uma **imagem Docker** do projeto após a compilação.  

   O docker deve ser pensado para o ambiente de desenvolvimento, evitando que o dev tenha que fazer instalações de quaisquer ferramentas para desenvolver o projeto. Um novo dev precisa ser capaz de desenvolver o projeto apenas baixando o projeto e seguindo as instruções no **readme.md**.

3. Registrar a imagem no **Docker Hub**.  

   Deve ser gerada uma imagem para execução do sistema a partir do Docker Hub. É importante que seja possível fazer ajustes de configurações simples para executar a imagem de forma local. Exemplo: Configuração de banco de dados e porta. É importante que hajam instruções para tal configuração.

4. Implementar **CI/CD** para que, ao realizar um commit na branch `master` contendo uma **tag no padrão**:  

   ```regex
   /^(v|V)?(\d+\.)?(\d+\.)?(\*|\d+).?(hf\d+|Hf\d+|HF\d+)?$/
   ```  
   
   a pipeline gere e publique automaticamente uma **nova imagem Docker no Docker Hub**.  

## 🔥 Tecnologias Utilizadas  

- **Git e Gitflow** 📂 (Organização do versionamento)  
- **Docker** 🐳 (Containerização do projeto)  
- **Docker Hub** 📦 (Registro das imagens)  
- **CI/CD** ⚡ (Automação de build e deploy)  

## 🎯 Objetivo  

Este projeto simula um ambiente de desenvolvimento real, avaliando as habilidades do candidato em:  

🔹 Implementação de funcionalidades conforme **requisitos técnicos**.  
🔹 Uso correto de **versionamento e boas práticas de Git**.  
🔹 **Criação e publicação de imagens Docker** para execução do projeto.  
🔹 Automação de processos via **CI/CD** para gerar versões consistentes.  

## 🚀 Como Participar?  

Os candidatos receberão **instruções específicas** para a implementação das **issues** e deverão seguir as diretrizes acima para concluir a avaliação com sucesso.  