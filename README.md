<h1><a href="https://brazil.generation.org/"><img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/generation.png" alt="Generation" width="90" height="44"></a> CRUD Bootcamp AWS 2º Turma</h1>
<body>
  <p>Proposta de projeto desenvolvimento de uma API que realiza um CRUD e roda deploy no cloud do render. O projeto segue o padrão MVC</p>
  <h2>Desenvolvedores</h2>
    <div class="image-container">
        <a href="https://github.com/RodolfoGueiros" target="_blank">
          <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/nicole.jpeg" alt="Imagem 1" width="100" height="100">
        </a>
        <a href=https://github.com/Larissa-Fabiana" target="_blank">
          <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/rodolfo.jpeg" alt="Imagem 2" width="100" height="100">
        </a>
        <a href="https://github.com/NicXavier" target="_blank">
          <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/larissa.jpeg" alt="Imagem 3" width="100" height="100">
        </a>
    </div>
  <h2>Stacks usadas</h2>
 <!-- <p>Linguaguem <b>Java</b>, Framework , plugin usado foi o <b>Maven</b> com documentação <b>Swagger</b>, geração de token com o <b>jwt token</b>, <b>Docker</b> e deploy no <a href="https://render.com">Render.com</a></p>
    
  <div class="image-container">
        <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-logo-java-coffee-cup-48.png" alt="Imagem 1" width="48" height="48">
        <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-logotipo-da-primavera-48.png" alt="Imagem 2" width="48" height="48">
        <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-logotipo-do-docker-48.png" alt="Imagem 3" width="48" height="48">
        <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-jwt-48.png" alt="Imagem 3" width="48" height="48">
    </div> 
  -->
    <div class="image-container">
        <figure>
            <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-logo-java-coffee-cup-48.png" alt="Imagem 1">
            <figcaption>Liguagem <b>Java</b> utilizada para desenvolvimento da API.</figcaption>
        </figure><br>
        <figure>
            <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-logotipo-da-primavera-48.png" alt="Imagem 1">
            <figcaption><b>Spring Boot</b> framework usado de apoio ao desenvolvimento da API.</figcaption>
        </figure><br>
        <figure>
            <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-logotipo-do-docker-48.png" alt="Imagem 1">
            <figcaption><b>Docker</b> ferramenta para envio e execução de aplicações em imagens em forma de containers.</figcaption>
        </figure><br>
        <figure>
            <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-jwt-48.png" alt="Imagem 1">
            <figcaption><b>JWT Token</b> para autenticar os usuários sem precisar armazenar informações sobre ele.</figcaption>
        </figure><br>
        <figure>
            <img src="https://github.com/RodolfoGueiros/beaba_tech/blob/main/img/icons8-postgreesql-48.png" alt="Imagem 1">
            <figcaption><b>PostgreSql</b> Sistema de gerenciamento de banco de dados relacional.</figcaption>
        </figure><br>      
      <h2>Documentação</h2>
      <p>Foi utilizado o <b>Swagger</b> para facilitar a manutenção e leitura da aplicação.</p>
      <div class="snippet-clipboard-content notranslate position-relative overflow-auto"><pre class="notranslate"><code class="notranslate">https://beaba-tech.onrender.com/swagger-ui/index.html#/
</code></pre><div class="zeroclipboard-container position-absolute right-0 top-0">
    <clipboard-copy aria-label="Copy" class="ClipboardButton btn js-clipboard-copy m-2 p-0" data-copy-feedback="Copied!" data-tooltip-direction="w" value="{{#css}}<link rel=&quot;stylesheet&quot; type=&quot;text/css&quot; href=&quot;/body.css&quot; media=&quot;all&quot;>{{/css}}
{{#js}}<script type=&quot;text/javascript&quot; src=&quot;/body.js&quot;></script>{{/js}}" tabindex="0" role="button" style="display: inherit;">
      <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-copy js-clipboard-copy-icon m-2">
    <path d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"></path><path d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"></path>
</svg>
      <svg aria-hidden="true" height="16" viewBox="0 0 16 16" version="1.1" width="16" data-view-component="true" class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none m-2">
    <path d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"></path>
</svg>
    </clipboard-copy>
  </div></div>
  <h2>Estrutura</h2>
  <p>Foi criada em camadas garantindo a finalidade de uso de cada uma:</p>
  <ul>
    <li><b>Config:</b> Contém as configuração do Swagger e Spring Security.</li><br>
    <li><b>Controller:</b> Controller: Responsável por receber as requisições HTTP e repassar para as camadas apropriadas. Aqui são definidos os endpoints de cada recurso.</li><br>
    <li><b>DTO:</b> Responsável pela conversão e tráfego de dados de entrada e saida da API.</li><br>
    <li><b>Entity:</b> Responsável pormapear uma classe Java a uma tabela no banco de dados definindo a estrutura da tabela</li><br>
    <li><b>Exception:</b> Responsável pelo tratamento de excessões das requisições HTTP.</li><br>
    <li><b>Repository:</b> Responsável por interagir diretamente com o banco de dados. Ela executa as consultas e operações de persistência.</li><br>
    <li><b>Security:</b> Contém as configurações de segurança da API.</li><br>
    <li><b>Service:</b> Contém as regras de negócios. Essa camada realiza o processamento dos dados, validações e chama os repositórios.</li>
  </ul>
  <h2>Configuração para instalar</h2>
  <h3>Pré-requisitos:</h3>
  <table>
  <tr>
    <th>Software</th>
    <th>Versão</th>    
  </tr>
  <tr>
    <td>JDK</td>
    <td>21.X.X</td>    
  </tr>
  <tr>
    <td>Spring Boot</td>
    <td>3.3.4</td>
  </tr>
  <tr>
    <td>Maven</td>
    <td>4.X.X</td>
  </tr>
  <tr>
    <td>Postgresql</td>
    <td>16.X.X</td>
  </tr>
  <tr>
    <td>Docker</td>
    <td>4.34.X</td>
  </tr>  
</table>
</body>
