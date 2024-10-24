Arquitetura do Projeto
O projeto segue uma arquitetura em camadas, que é amplamente utilizada em sistemas baseados em APIs REST. Isso significa que o código está organizado de maneira que cada camada tem uma responsabilidade bem definida, garantindo a separação de preocupações, facilitando a manutenção e a escalabilidade do sistema.
A arquitetura é composta pelas seguintes camadas principais:
Controller: Responsável por receber as requisições HTTP e repassar para as camadas apropriadas. Aqui são definidos os endpoints de cada recurso.
Service: Contém as regras de negócios. Essa camada realiza o processamento dos dados, validações e chama os repositórios.
Repository: Responsável por interagir diretamente com o banco de dados. Ela executa as consultas e operações de persistência.
Model: Representa as entidades do sistema, geralmente mapeadas diretamente para tabelas do banco de dados.
Essa organização em camadas segue os princípios de desenvolvimento de software orientado a objetos e de separação de responsabilidades, o que facilita o desenvolvimento e a escalabilidade da aplicação.
Linguagem Utilizada
O projeto foi desenvolvido utilizando a linguagem Java, uma escolha comum para sistemas que exigem robustez e performance em ambientes corporativos.
Framework Utilizado
O framework principal utilizado no desenvolvimento do projeto foi o Spring Boot, que oferece uma série de ferramentas e bibliotecas para desenvolvimento ágil de APIs RESTful, como:
Spring Data JPA: Para facilitar a integração com o banco de dados, utilizando o padrão JPA (Java Persistence API).
Spring Security: Para gerenciar a autenticação e autorização dos usuários, implementando a segurança da API com JWT (JSON Web Token).
Swagger: Para gerar a documentação automática da API, permitindo que os usuários possam testar os endpoints diretamente pela interface.
API REST
A arquitetura é baseada no conceito de API REST, onde as requisições são feitas por meio de verbos HTTP como GET, POST, PUT e DELETE. Cada uma dessas operações é mapeada para uma rota da aplicação, e as respostas são sempre em formato JSON.
Camadas do Backend
1. Model
Essa camada contém as classes que representam as entidades do sistema, como Aluno, Funcionario e Curso. Cada classe define os atributos dessas entidades, que são refletidos diretamente nas tabelas do banco de dados. As entidades são anotadas com @Entity, uma anotação do JPA, que indica que a classe será mapeada para uma tabela no banco.
2. Repository
Na camada de repositório, temos interfaces que estendem JpaRepository, o que permite realizar operações básicas de CRUD sem a necessidade de escrever SQL manualmente. Exemplo de repositórios no projeto:
FuncionarioRepository: Manipula dados da tabela de funcionários.
AlunoRepository: Manipula dados da tabela de alunos.
Essa camada facilita a interação com o banco de dados e permite a criação de consultas customizadas.
3. Service
Aqui ficam as regras de negócio. A camada de serviço processa os dados recebidos pelos controladores, faz validações, como a verificação de e-mails duplicados e, em seguida, chama os repositórios para persistir ou buscar dados. Exemplos de regras de negócios:
Impedir o cadastro de funcionários ou alunos com e-mails duplicados.
Garantir que cada aluno só possa se inscrever em um curso por vez.
Implementar a geração e validação de tokens JWT para controle de autenticação.
4. Controller
A camada Controller é responsável por mapear as requisições HTTP para métodos Java. Cada método no controller corresponde a um endpoint da API. Exemplo:
/api/funcionarios: Rota para cadastrar e gerenciar funcionários.
/api/alunos: Rota para gerenciamento de alunos.
Essa camada é o ponto de entrada das requisições e lida com a comunicação entre o cliente (frontend ou outro serviço) e o backend.
Banco de Dados e Tabelas
O banco de dados utilizado é o PostgreSQL, e as tabelas são estruturadas de acordo com as entidades do sistema. Algumas tabelas importantes incluem:
1. Funcionario
ID: Chave primária do funcionário.
Nome: Nome do funcionário.
Email: E-mail, que deve ser único.
Senha: Senha, usada para autenticação.
Cargo: Define o cargo do funcionário (pode influenciar nas permissões).
2. Aluno
ID: Chave primária do aluno.
Nome: Nome do aluno.
Email: Também único.
Curso_ID: Chave estrangeira que faz referência ao curso em que o aluno está matriculado.
3. Curso
ID: Chave primária do curso.
Nome: Nome do curso.
Descricao: Uma breve descrição do curso.
Duracao: Duração do curso.
Autenticação JWT
Para garantir a segurança da API, foi implementado um sistema de autenticação baseado em JWT (JSON Web Token). Esse mecanismo permite que um funcionário faça login e receba um token, que será usado em todas as requisições subsequentes para garantir que ele está autenticado.
O login gera um token JWT, que tem validade de 3 horas.
O Cadastro de Funcionários e o Login são as únicas rotas acessíveis sem autenticação.
A autenticação é implementada com Spring Security, que garante que todas as outras rotas só sejam acessíveis mediante a apresentação de um token válido.
Conclusão
Essa API foi projetada para ser escalável, segura e eficiente, com uma arquitetura modular que separa responsabilidades claras entre as camadas de Controller, Service, Repository e Model. O uso de tecnologias como Java, Spring Boot, JPA e JWT garante que o projeto seja robusto, seguro e de fácil manutenção, pronto para ser adaptado a diferentes contextos escolares.
