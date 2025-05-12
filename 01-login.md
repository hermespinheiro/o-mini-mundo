### **Login:**  

**"Como um usuário, quero fazer login no sistema usando JWT e ter a opção de me cadastrar fornecendo nome, e-mail e senha."**  

### **Descrição:**  
**Critérios de Aceitação (Requisitos):**  
1. **Tela de Login:**  
   - Campos obrigatórios: **E-mail** e **Senha**.  
   - Validação de campos em tempo real (formato de e-mail, senha não vazia).  
   - Botão de **"Entrar"** que envia as credenciais para autenticação via **JWT (JSON Web Token)**.  
   - Link para **"Cadastrar-se"** (redireciona para a tela de cadastro).  

2. **Autenticação com JWT:**  
   - O sistema deve retornar um **token JWT** válido após login bem-sucedido.  
   - O token deve ser armazenado no **localStorage/sessionStorage** para uso em requisições subsequentes.  
   - Em caso de falha (credenciais inválidas), exibir mensagem clara: *"E-mail ou senha incorretos."*.  

3. **Tela de Cadastro:**  
   - Campos obrigatórios:  
     - **Nome completo** (mín. 3 caracteres).  
     - **E-mail** (validar formato).  
     - **Senha** (mín. 6 caracteres, com confirmação).  
   - Validação em tempo real:  
     - Senha e confirmação devem coincidir.  
     - Feedback visual para campos inválidos.  
   - Botão **"Cadastrar"** que envia os dados para o backend (sem autologin).  
   - Após cadastro, redirecionar para a tela de login com mensagem: *"Cadastro realizado! Faça login para continuar."*.  

4. **Segurança:**  
   - A senha deve ser armazenada no banco de dados de forma **criptografada** (ex: bcrypt).  
   - O JWT deve ter um **tempo de expiração** (ex: 1h) e ser invalidado no logout.  

5. **Extras (Opcionais):**  
   - Link para **"Esqueci minha senha"** na tela de login.  
   - Verificação de e-mail duplicado durante o cadastro.  
   - Loaders durante requisições assíncronas.  

### **Notas Adicionais:**  
- **Backend:** Deve fornecer endpoints para:  
  - `POST /auth/login` (retorna JWT).  
  - `POST /auth/register` (valida e cria usuário).  
- **Frontend:**  
  - Tratar erros de API (ex: e-mail já cadastrado).  
  - Redirecionar usuários autenticados para uma dashboard (se tentarem acessar login/cadastro).  

