[33mcommit 9265f3f101c91604893799a51335e7523f5e16e6[m[33m ([m[1;36mHEAD -> [m[1;32mmaster[m[33m, [m[1;31morigin/master[m[33m)[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 23:18:49 2019 -0300

    Update issue templates

[33mcommit 5eba83b75c8efb747cfe55f72f14119f1c7519a3[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 23:18:19 2019 -0300

    Create LICENSE

[33mcommit 60b269a3800aece68459ef0b1eef91cdc29224aa[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 23:17:43 2019 -0300

    Create CONTRIBUTING.md

[33mcommit 1e4a6ad9640919297ee6882be5a7dd5c30adcaf2[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 23:15:22 2019 -0300

    Create CODE_OF_CONDUCT.md

[33mcommit e638a9acf795a9ab67819187f654e50e52f96513[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 23:10:19 2019 -0300

    Fix do conflito gerado com controle de erros dos inputs de Aluno.

[33mcommit bb36f9abea4b0c12ab5707fadeb49bc89a1c958c[m
Merge: 39b3b33 d3ed1f9
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 22:55:42 2019 -0300

    Merge dos branchs da nuvem com o local.

[33mcommit 39b3b3331f0c931bc69944d4ec41a2aad4d016af[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 22:46:20 2019 -0300

    Lógica para ler e listar os arquivos cursos.csv e alunos.csv e listá-los juntamente com as entradas do console.

[33mcommit d41e3aeb5b07978d591753406b93d6319eeabcaa[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 21 22:35:58 2019 -0300

    Correção na lógica de listar curso. CsvAluno consertado. CsvCurso criado. ListaCurso criado.

[33mcommit d3ed1f963d484b7e00ee5f3bc706f0c554d37270[m
Author: Daniel K Yamamoto <48425390+danielkeizoy@users.noreply.github.com>
Date:   Tue May 21 00:47:44 2019 -0300

    commit inicial de EscreveCsv.java
    
    A classe funciona para escrever uma lista, porém estou tentando implementar que escreva a partir de um Hashmap importado de outro lugar.
    
    
    No protótipo de teste está sendo feito o método para escrever o alunos.csv;
    
    Como os objetos Aluno, possuem apenas dois parametros (id e nome), dando certo para alunos, é só adaptar para Cursos posteriomente.
    
    
    O terceiro metodo de escrita de csv será o de rendimentos, que escreve como :
    
    id_aluno; np1; np2; sub; exame
    
    e terá o nome como sendo um String nomeArquivo = String.valueof(curso.nomeDoCurso + "_" + curso.tipoDoCurso + "_" + curso.anoDoCurso)

[33mcommit 0ef97b7b2d2c1e9841fed4bf6455e99ac9d1c07c[m
Author: vitorpiosilva <vitorpiosilva@protonmail.com>
Date:   Mon May 20 23:17:09 2019 -0300

[33mcommit dc008f3698593829a79fe761de9dd9783dc08412[m
Author: vitorpiosilva <vitorpiosilva@protonmail.com>
Date:   Mon May 20 23:08:35 2019 -0300

[33mcommit f1cefeef462241fb6d85ed5746f38b6943f389da[m
Author: vitorpiosilva@hotmail.com <>
Date:   Mon May 20 22:58:31 2019 -0300

    Mudanças de interface do menu inicial;
    
    Realocação do método PedirAluno do AlunoView para o AlunoControl;
    Criação de Exception para a inserção de nomes e ids nulos, com caracteres
    especiais e/ou vazios.

[33mcommit 60f42f1fbe2df96a75577d224260233ed576fd39[m
Author: Daniel K Yamamoto <48425390+danielkeizoy@users.noreply.github.com>
Date:   Sun May 19 23:36:31 2019 -0300

    Csv.java dividida
    
    Classe dividida entre classe que lê (LerCsv.java) e classe que escreve (EscreveCsv.java)
    Mudança necessária para análise e construção organizada e eficiente de novo código.
    Se necessário, ou quando possível, nova classe Csv.java será criada, com a união das duas funcionalidades.

[33mcommit d01966f84b88c1ee18f849e4a7b6c91aeb9f32a4[m
Author: Daniel K Yamamoto <48425390+danielkeizoy@users.noreply.github.com>
Date:   Sun May 19 23:31:56 2019 -0300

    CsvAluno.java obsoleto
    
    Classe [DEPRECATED] -> métodos inclusos na classe LerCsv.java

[33mcommit 9455dd2702c373630b8adf3fec34318434ba84ec[m
Author: Daniel K Yamamoto <48425390+danielkeizoy@users.noreply.github.com>
Date:   Sun May 19 23:25:51 2019 -0300

    Lê alunos.csv e cursos.csv, porem
    
    ...porem ainda não lê os arquivos especificos de cada curso,
    o problema pode estar de duas formas:
     - ou realmente não lê e está dando como Null;
     - ou há problemas no metodo setNotas, na classe Rendimento;

[33mcommit d0408d7d8b4af5b0e39c1df2498f19d3619a971d[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sun May 19 12:28:53 2019 -0300

    Delete Csv.class

[33mcommit dfbfd2a4e33bb4c325e3175e2a0f7a66c790dba0[m
Merge: 2828899 759d631
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sun May 19 12:15:31 2019 -0300

    Merge branch 'master' of https://github.com/glaydsonp/TrabalhoNP2TerceiroSemestre

[33mcommit 282889993aa48a07cadc21da0f2ddd8b4e1d60dd[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sun May 19 12:13:53 2019 -0300

    Correção na implementação da classe Notas de Map<Prova, Double> para Map<Prova, Nota>. Refatoração subsequênte dos métodos getNota() e da classe Media.

[33mcommit 759d63138f08f4fe7192630ff528f24dfb3f5c9f[m
Author: Daniel K Yamamoto <48425390+danielkeizoy@users.noreply.github.com>
Date:   Sun May 19 02:06:33 2019 -0300

    commit dia 18-05-19 referente a csv
    
    Classe Csv.java sendo trabalhada,
    Métodos de leitura e transformação em dados do arquivo alunos.csv implementados com sucesso. (classe CsvAluno.java)
    A seguir, criar o leitor de csv para cursos (cadastro de cursos) e das notas de cada curso.
    E também, o escritor de csv.

[33mcommit d8c84c12ebd91ae9ee9253955068b21a70ac15f8[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sun May 19 00:49:38 2019 -0300

    Começo da implementação das classes HistoricoView e HistoricoControl. Ainda a finalizar.

[33mcommit ec8e15f69cadbd9b6d3c7f7cb80fd88bfbb73b4c[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sun May 19 00:08:19 2019 -0300

    Criação da classe Historico para mapear os Cursos que cada Aluno fez juntamente com suas respectivas notas.
    Adição dos arquivos .csv na pasta files.

[33mcommit 2366e7736e0bece1143a55df622058d00924329b[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sun May 19 00:06:34 2019 -0300

    Criação da classe Historico para mapear os Alunos em relação aos Cursos que cada Aluno cursou juntamente com suas notas.

[33mcommit 7cd2ef5363a06d3cd5c81d1daf77a98d4c4cf158[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sat May 18 22:53:54 2019 -0300

    Otimização nas exibições da Grade de Curso e do Corpo de Alunos. Melhorias do código.

[33mcommit 1a4873bed1c835f3d84ca30e00f4bf3b0ef22db4[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Sat May 18 15:27:57 2019 -0300

    Criação das classes HistoricoControl, HistoricoView e DomainExceptions. Implementados e testados os métodos para listar alunos e cursos.

[33mcommit f79cb5ce9241568540d21cda540558ad63475cbb[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Fri May 17 11:45:23 2019 -0300

    ListaAfazeres.txt atualizada.

[33mcommit ae9b7762e09aacc32f3066ef46f42627ab51f361[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Fri May 17 11:44:20 2019 -0300

    Adicionado a classe Media e a classe StatusAluno. Refatorado todo o código referente a classe Media e seus métodos. Classe Rendimento também refatorada.

[33mcommit d468c3e6971b3e4edc08d4a1df321ce1111873c3[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Fri May 17 10:47:02 2019 -0300

    Adicionado o arquivo Lista de coisas que faltam fazer.

[33mcommit b1ebb6c19249908299a36fa26a0ae4c987b17057[m
Merge: 8ef8820 c18e7fd
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Thu May 16 16:11:06 2019 -0300

    Merge branch 'master' of https://github.com/glaydsonp/TrabalhoNP2TerceiroSemestre

[33mcommit 8ef88200ce075b854a97b0707bbb7023bd173841[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Thu May 16 16:08:35 2019 -0300

    Implementação dos métodos de listar Alunos e Cursos no Menu Principal.

[33mcommit 33555991ad0742a0a7168457ef3604c34c779082[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Thu May 16 16:05:20 2019 -0300

    status

[33mcommit c18e7fd0be2211ab7a0fbc738daef0fb6207912f[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Thu May 16 14:11:16 2019 -0300

    Create README.md

[33mcommit c37f4dbe92fe00bf851ac38450d9a33297008099[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Thu May 16 14:04:40 2019 -0300

    Caminho das entities alterado. Adicionado a função de calcular média do aluno. Adicionado enum de MEDIA.

[33mcommit a98c365e35d6300765480911188fca2ad0d8d553[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 14 22:32:52 2019 -0300

    commit final dia 14-05

[33mcommit 0a24a6f8e7c0e20b19c736dc8b773fb78092ba5d[m
Author: glaydsonp <38405677+glaydsonp@users.noreply.github.com>
Date:   Tue May 14 21:30:05 2019 -0300

    primeiro commit
