### **História de Usuário: CRUD de Projetos**

**Como** usuário autenticado,  
**Quero** criar, visualizar, editar e excluir projetos no sistema,  
**Para** organizar e gerenciar as informações de cada projeto de forma eficiente.

#### **Critérios de Aceitação:**
- O sistema deve **restringir o acesso** à tela de gerenciamento de projetos apenas para usuários autenticados.
- O sistema deve permitir a **criação** de um projeto informando os atributos necessários.
- O sistema deve permitir a **edição** dos atributos de um projeto já cadastrado.
- O sistema deve permitir a **visualização** de um projeto específico e a listagem de todos os projetos.
- O sistema deve permitir a **exclusão** de um projeto, garantindo que não haja dependências que impeçam a remoção.
- As ações de **criação** e **edição** devem validar campos obrigatórios e evitar duplicidades, conforme regras de negócio.
- O sistema deve garantir que apenas usuários autorizados possam criar, editar ou excluir projetos.
- Deve ser possível pesquisar projetos pelo nome ou outros critérios relevantes.

#### **Regras de Negócio:**
1. **Autenticação obrigatória**: Somente usuários autenticados podem acessar a tela de gerenciamento de projetos.
2. **Atributos do Projeto**:
   - **Nome do projeto**: Obrigatório e único.
   - **Descrição do projeto**: Opcional.
   - **Status do projeto**: Pode ser **Ativo** ou **Inativo**.
   - **Orçamento disponível**: Opcional.
3. A criação e edição de projetos devem respeitar as permissões do usuário logado.
4. A exclusão de um projeto só deve ser permitida se não houver registros dependentes associados.
