import java.util.Scanner;

public class Logic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;
    public static boolean isRunning;

    //Encontros aleatórios
    public static String[] encounters = {"Batalha", "Batalha", "Batalha", "Tenda", "Tenda"};

    //Nomes de inimigos
    public static String[] enemies = {"Goblin", "Goblin", "Troll", "Troll", "Fantasma"};

    //Partes da história
    public static int place = 0, act = 1;
    public static String[] places = {"Floresta Assombrada", "Minas Destruídas", "Cidade Perdida", "Castelo Infernal"};

    //Pega as ações do usuário
    public static int readInt(String prompt, int userChoices) {
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.nextLine());
            } catch(Exception e){
                input = -1;
                System.out.println("Por favor, informe um número.");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //Limpa o console
    public static void clearConsole() {
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //Separa texto
    public static void printSeparator() {
        System.out.println("------------------------------");
    }

    //Faz um título
    public static void printHeading(String title) {
        printSeparator();
        System.out.println(title.toUpperCase());
        printSeparator();
    }

    //Para o jogo
    public static void anythingToContinue() {
        System.out.println("\nPressione qualquer tecla...");
        scanner.nextLine();
    }

    //Começa o jogo
    public static void startGame() {
        boolean nameSet = false;
        String name;

        //Tela de título
        clearConsole();
        printSeparator();
        System.out.println("RPG DE TURNOS EM JAVA");
        printSeparator();
        anythingToContinue();

        //Pega o nome do jogador
        do{
            clearConsole();
            System.out.println("Seu nome é: ");
            name = scanner.nextLine();
            //Confirma se o nome está correto
            clearConsole();
            printHeading("Seu nome é " + name + ", certo?");
            System.out.println("1 - Isso");
            System.out.println("2 - Não, calma aí");
            int input = readInt("- ", 2);
            if(input == 1) {
                nameSet = true;
            }
        }while (!nameSet);

        //Introdução da história
        Story.printIntro();

        //Cria o jogador com seu nome
        player = new Player(name);

        //Escreve o primeiro ato
        Story.firstActIntro();

        //Faz o jogo em si iniciar
        isRunning = true;

        //Começa o loop do jogo
        gameLoop();
    }

    //Altera o que acontece no jogo de acordo com o nível do personagem
    public static void checkAct() {
        //Faz o jogador subir de nível e muda o capítulo do jogo baseado no XP do personagem
        if (player.xp >= 10 && act == 1) {
            //Incrementa capítulo e o local
            act = 2;
            place = 1;
            Story.firstActOutro();
            //Aumenta o nível do jogador
            System.out.println("Você ganhou" + player.xp + " e subiu ao nível 2!");
            player.chooseTrait();
            Story.secondActIntro();
            //Muda os inimigos
            enemies[0] = "Troll de Gelo";
            enemies[1] = "Goblin Carniceiro";
            enemies[2] = "Matilha de lobos";
            enemies[3] = "Troll de Gelo";
            enemies[4] = "Cultista";
        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            Story.secondActOutro();
            //Aumenta o nível do jogador
            System.out.println("Você ganhou" + player.xp + " e subiu ao nível 3!");
            player.chooseTrait();
            Story.thirdActIntro();
            //Novos inimigos
            enemies[0] = "Troll de Fogo";
            enemies[1] = "Troll de Gelo";
            enemies[2] = "Espectro";
            enemies[3] = "Espectro";
            enemies[4] = "Lobisomem";
            //Novos eventos
            encounters[0] = "Batalha";
            encounters[1] = "Batalha";
            encounters[2] = "Batalha";
            encounters[3] = "Batalha";
            encounters[4] = "Tenda";
            //Faz o jogador voltar a ter vida completa
            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3) {
            act = 4;
            place = 3;
            Story.thirdActOutro();
            //Aumenta o nível do jogador
            System.out.println("Você ganhou" + player.xp + " e subiu ao nível 4!");
            player.chooseTrait();
            Story.fourthActIntro();
            //Deixa o jogador com vida total
            System.out.println("Você descansa pela última vez, sua vida foi restaurada por completo.");
            player.hp = player.maxHp;
            System.out.println(player.hp + "/" + player.maxHp);
            //Chama a batalha final
            System.out.println("Agora se prepare para a batalha final.");
            finalBattle();
        }
    }

    //Calcula um encontro aleatório
    public static void randomEncounter() {
        //Calcula um número aleatório dentro do array de eventos
        int encounter = (int) (Math.random() * encounters.length);
        //Chama o evento que foi escolhido
        if(encounters[encounter].equals("Batalha")) {
            randomBattle();
        } else if (encounters[encounter].equals("Tenda")) {
            takeRest();
        }
    }

    //Continua o jogo e checa se o capítulo deve avançar
    public static void continueJourney() {
        checkAct();
        //Checa se não é o último capítulo
        if(act != 4) {
            randomEncounter();
        }
    }

    //Informações sobre o personagem
    public static void characterInfo() {
        clearConsole();
        printHeading("INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator();
        //Experiência do jogador
        System.out.println("XP: " + player.xp);
        printSeparator();

        //Mostrando os itens recebidos
        if(player.numAtkUpgrades > 0) {
            System.out.println("Itens de ataque: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
        }
        if(player.numDefUpgrades > 0) {
            System.out.println("Itens de defesa: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }

    //Permite ao jogador usar uma tenda para descansar
    public static void takeRest() {
        clearConsole();
        if(player.restsLeft >= 1) {
            printHeading("Você quer descansar? (" + player.restsLeft + " descanso(s) restante(s)");
            System.out.println("1- Sim \n2- Não");
            int input = readInt("-", 2);
            if(input == 1) {
                //Descansa
                clearConsole();
                if(player.hp < player.maxHp) {
                    int hpRestored = (int) ((Math.random() * (((double) player.maxHp / 4) + 1)) + 10);
                    player.hp += hpRestored;
                    if(player.hp >= player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("Você descansou e recuperou " + hpRestored + "pontos de vida.");
                    System.out.println("Você agora tem " + player.hp + "/" + player.maxHp + "pontos de vida.");
                    player.restsLeft--;
                } else {
                    System.out.println("Você teve uma bom descanso, mas seus pontos de vida já estavam no máximo.");
                }
            }
            anythingToContinue();
        }
    }

    //Cria uma batalha aleatória
    public static void randomBattle() {
        clearConsole();
        printHeading("Um monstro se aproxima!");
        anythingToContinue();
        //Cria um inimigo aleatório dentro do array
        battle(new Enemy(enemies[(int) (Math.random()*enemies.length)], player.xp));
    }

    //Batalha principal
    public static void battle(Enemy enemy) {
        //Loop de batalha
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Escolha uma ação: ");
            printSeparator();
            System.out.println("1 - Lutar\n2 - Fugir");
            int input = readInt("-", 3);
            //Reage de acordo com o input
            if (input == 1) {
                //Lutar
                //Calcula dano feito e recebido
                int dmg = player.attack() - enemy.defend();
                int dmgTaken = enemy.attack() - player.defend();
                //Checa se o dano não é negativo
                if (dmgTaken < 0) {
                    //Adiciona dano crítico se o jogador defender bem
                    dmg -= (dmgTaken / 2);
                    dmgTaken = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                player.hp -= dmgTaken;
                enemy.hp -= dmg;
                //Mostra a informação da batalha
                clearConsole();
                printHeading("Batalha");
                System.out.println("Você ocasionou " + dmg + " pontos de dano ao " + enemy.name + "!");
                printSeparator();
                System.out.println("O " + enemy.name + " ocasionou " + dmgTaken + " pontos de dano a você!");
                anythingToContinue();
                //Verifica se o jogador está vivo ou morto
                if (player.hp <= 0) {
                    playerDied(); //Encerra o jogo
                    break;
                } else if (enemy.hp <= 0) {
                    //Diz ao jogador que ele ganhou
                    clearConsole();
                    printHeading("Você derrotou o " + enemy.name + "!");
                    //Aumenta o XP do jogador
                    player.xp += enemy.xp;
                    System.out.println("Você recebeu " + enemy.xp + "XP!");
                    //Calcula se o jogador ganha uma tenda a mais
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    if(addRest) {
                        player.restsLeft++;
                        System.out.println("Você ganhou uma tenda adicional!");
                    }
                    anythingToContinue();
                    break;
                }

            } else {
                //Fugir
                clearConsole();
                if (act != 4) {
                    //35% de chance de fugir
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printHeading("Você fugiu do " + enemy.name + "!");
                        anythingToContinue();
                        break;
                    } else {
                        printHeading("Você ficou preso!");
                        //Calcula o dano que o jogador recebe
                        int dmgTaken = enemy.attack();
                        System.out.println("Você recebeu " + dmgTaken + " de dano ao tentar fugir.");
                        anythingToContinue();
                        //Checa se o jogador ainda está vivo
                        if (player.hp <= 0) {
                            playerDied();
                        } else {
                            printHeading("Não há escapatória.");
                            anythingToContinue();
                        }
                    }
                }
            }
        }
    }

    //Menu Principal
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Escolha uma ação");
        printSeparator();
        System.out.println("1 - Continuar jornada");
        System.out.println("2 - Info do personagem");
        System.out.println("3 - Sair do jogo");
    }

    //Batalha final
    public static void finalBattle() {
        //Cria o chefe final
        battle(new Enemy("Imperador Supremo", 300));
        //Fim do jogo
        Story.printEnd(player);
        isRunning = false;
    }

    //Jogador morre
    public static void playerDied() {
            clearConsole();
            printHeading("Você morreu.");
            printHeading("Volte no tempo e veja se então consegue sua vingança.");
            System.out.println("Obrigado por jogar!");
            isRunning = false;
        }

    //Loop principal do jogo
    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("->", 3);
            if(input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }
}
