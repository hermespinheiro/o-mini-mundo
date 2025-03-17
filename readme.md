# 🚀 Mini Mundo - Projeto de Laboratório para Testes e Avaliações Técnicas  

## 📌 Sobre o Projeto  

O **Mini Mundo** é um projeto de laboratório destinado a testes e implementações de validação técnica para seleção de desenvolvedores. Ele permite avaliar candidatos por meio da implementação de **issues específicas**, garantindo que sigam boas práticas de desenvolvimento, versionamento e deploy contínuo.  

Cada avaliação requer que o candidato implemente uma ou mais **issues**, seguindo um fluxo padronizado que envolve:  

✅ **Uso de Conventional Commit e Gitflow** para organização do histórico de commits.  
✅ **Criação de uma imagem Docker** para execução do projeto após a compilação.  
✅ **Registro da imagem no Docker Hub** para facilitar a distribuição.  
✅ **Configuração de CI/CD** para automação do build e versionamento da imagem.  

## 🛠️ Requisitos da Avaliação  

Durante a implementação, o candidato deverá:  

1️⃣ Implementar **uma ou duas issues**, conforme definido no processo de avaliação.  
2️⃣ Seguir a convenção de commits **Conventional Commit** e o fluxo **Gitflow**.  
3️⃣ Criar uma **imagem Docker** do projeto após a compilação.  
4️⃣ Registrar a imagem no **Docker Hub**.  
5️⃣ Implementar **CI/CD** para que, ao realizar um commit na branch `master` contendo uma **tag no padrão**:  

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