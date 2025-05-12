### **História de Usuário: CRUD de Tarefas**

**Como** usuário autenticado,  
**Quero** criar, visualizar, editar e excluir tarefas associadas a um projeto,  
**Para** organizar e gerenciar o progresso do trabalho dentro dos projetos.

#### **Critérios de Aceitação:**
- O sistema deve **restringir o acesso** à tela de gerenciamento de tarefas apenas para usuários autenticados.
- O sistema deve permitir a **criação** de uma tarefa informando os atributos obrigatórios.
- O sistema deve permitir a **edição** dos atributos de uma tarefa já cadastrada.
- O sistema deve permitir a **visualização** de uma tarefa específica e a listagem de todas as tarefas de um projeto.
- O sistema deve permitir a **exclusão** de uma tarefa, garantindo que não haja dependências que impeçam a remoção.
- As ações de **criação** e **edição** devem validar campos obrigatórios e evitar duplicidades, conforme regras de negócio.
- O sistema deve garantir que apenas usuários autorizados possam criar, editar ou excluir tarefas.
- Deve ser possível pesquisar tarefas por **descrição, projeto, status ou outros critérios relevantes**.

#### **Regras de Negócio:**
1. **Autenticação obrigatória**: Somente usuários autenticados podem acessar a tela de gerenciamento de tarefas.
2. **Atributos da Tarefa**:
   - **Descrição da tarefa**: Obrigatório.
   - **Projeto**: Obrigatório (toda tarefa deve estar associada a um projeto existente).
   - **Data de Início**: Opcional.
   - **Data de Fim**: Opcional.
   - **Tarefa Predecessora**: Opcional (uma tarefa pode estar vinculada a outra anterior, indicando dependência).
   - **Status**: Pode ser **Concluída** ou **Não Concluída**.
3. O sistema deve garantir que a **Data de Fim** não seja anterior à **Data de Início**.
4. A exclusão de uma tarefa só deve ser permitida se ela **não for predecessora de outra tarefa**.
5. Deve ser possível listar todas as tarefas de um projeto e filtrá-las por **status (Concluída | Não Concluída)**.
6. O sistema deve permitir a **atualização do status da tarefa**, garantindo que apenas usuários autorizados possam marcá-la como "Concluída".
7. O sistema pode permitir a visualização do **progresso do projeto** com base nas tarefas concluídas e não concluídas.
