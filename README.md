
# COLONIARPG V2.2024b
---
Nome: Stéfano Camargo Squarcieri 
---
Curso: Sistemas de informação
### **Sobre  o jogo**

---
Primeiramente créditos ao colega Luis Henrique Cardoso (https://github.com/xXLuisHenriqueXx) que desenvolveu no segundo semestre de 2023 a v1 do COLONIA RPG ( https://github.com/elc117/game-2023b-coloniarpg) , jogo no qual eu decidi fazer extensões ou pelo menos tentar xd.

Um RPG por turnos tendo como ideia os jogos de pokemons antigos, porém no momento do ataque são aplicadas perguntas sobre os lugares onde as batalhas se passam, São João do Polesine e Pinhal Grande e Vila Belga os quizzes substituem a mecânica de stamina e determinam quem irá receber dano, no erro o jogador recebe e no acerto o inimigo. O mesmo é composto por uma tela de menu principal, uma tela de exibição de itens (prêmios),  uma tela de seleção de fase, uma tela de texto que informa a vitória ou derrota, uma tela de quiz e três telas de batalha.

## **📖 Desenvolvimento**  
**BUILD E AMBIENTAÇÃO DA LIBGDX (mini relato dos bastidores):**  
> De ínicio foi hard a parte de ambientação e build do projeto, eu tentei iniciar algo autoral mas acabei tendo problemas no meu jogo com colisões e também não tava legal a exibição em web e acabei desistindo. Como essa parte incremental do inicio eu fiquei fazendo muitos builds acabei pegando a manha entao executar algo pronto tinha se tornado facil, como opão também dava p incrementar algum jogo do semestre passado então eu eu foquei em entender o jogo e em como extender ele sem destruir ou alterar o fluxo geral.

---
Com assets também tive alguns problemas de carregamento, ou que no desktop saiam formatados e no html nao, com a classe AssetUtils do projeto me deu um norte em como organizar e entender também como foi carregado/liberado. O projeto original conta com dois niveis , criar as battlescreens nao foi dificil em si pq na real era so uma extensao da condição, o chato foi integrar os botoes dos levels na selectmapscreen, oq foi arrumado com um table. Bom, indo direto pras minhas implementações do jogo, eu adicionei mais dois levels, sendo um deles completo ( Vila Belga ) e o outro só a Screen pra BattleScreen4, a ideia era tornar o level4 diferente ou trazer coisas da minha ideia original mas nao deu tempo entao só ficou a tela mesmo. Ja tinha o efeito hover, pus um listener que da mais um efeito visual na hora do click. Por fim a classe SettingsScreen era pra ser algo pra extensao do menu sla configuracao de som ou dificuldade  mas pensei que ia fugir muito do requisito entao acabou virando um "inventário" pra exibir as recompensas depois de ganhar em cada nivel, nao integrei a vitoria com ganhar o item mas os assets e descricao de cada item consta la. Em resumo consegui ligar os pontos e entender como foi desenvolvido o projeto original.


## **💡 Referências**  
 https://stackoverflow.com/questions/45121913/libgdx-table-structure
 https://libgdx.com/wiki/app/the-life-cycle
 https://itch.io/game-assets/free
trecho das descrições dos itens retirado parcialmente de :
 https://www.pinhalgrande.rs.gov.br/home
 http://www.belgianclub.com.br/pt-br/heritage/vila-belga-santa-maria
 https://saojoaodopolesine.rs.gov.br/




### **C
