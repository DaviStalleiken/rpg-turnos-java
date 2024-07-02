public class Story {

    public static void printIntro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("INTRODUÇÃO");
        Logic.printSeparator();
        System.out.println("Você acorda entorpecido. Sua cidade está reduzida a cinzas à sua volta.");
        System.out.println("Você vaga pelos destroços até encontrar sua casa, também completamente arrasada.");
        System.out.println("Você decide descobrir quem foi o responsável por isso.");
        Logic.anythingToContinue();
    }

    public static void firstActIntro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CAPÍTULO 1 - INTRO");
        Logic.printSeparator();
        System.out.println("Você inicia sua jornado entrando na Floresta Assomabrada.");
        System.out.println("Ao andar pelo mato, você ouve sons estranhos.");
        System.out.println("Você sente que algo se aproxima de sua localização.");
        Logic.anythingToContinue();
    }

    public static void firstActOutro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CAPÍTULO 1 - OUTRO");
        Logic.printSeparator();
        System.out.println("Você desbravou a floresta, mas lá não encontrou respostas.");
        System.out.println("Ao sair dela, o rastr de destruição te levou até antigas minas.");
        System.out.println("Você consegue ouvir ecos de gritos distantes");
        Logic.anythingToContinue();
    }

    public static void secondActIntro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CAPÍTULO 2 - INTRO");
        Logic.printSeparator();
        System.out.println("Você busca por sinais de vida na mina, tendo seguido os gritos.");
        System.out.println("Era uma armadilha!");
        Logic.anythingToContinue();
    }

    public static void secondActOutro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CHAPTER 2 - OUTRO");
        Logic.printSeparator();
        System.out.println("Você lutou e se libertou da armadilha.");
        System.out.println("Mas você sente que isso não irá durar muito.");
        System.out.println("Você sente o cheiro de sangue e o segue para a próxima área.");
        Logic.anythingToContinue();
    }

    public static void thirdActIntro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CAPÍTULO 3 - INTRO");
        Logic.printSeparator();
        System.out.println("Você chega a uma gigantesca cidade abandonada.");
        System.out.println("Você sente o cheiro podre que as ruas exalam.");
        System.out.println("Você sente que se aproxima do fim.");
        Logic.anythingToContinue();
    }

    public static void thirdActOutro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CAPÍTULO 3 - OUTRO");
        Logic.printSeparator();
        System.out.println("Você matou todos que se oporam até aqui.");
        System.out.println("Agora, você encontra um castelo destruído no limite da cidade.");
        System.out.println("Você se aproxima dele e o portão abre sozinho.");
        Logic.anythingToContinue();
    }

    public static void fourthActIntro() {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("CAPÍTULO 4 - INTRO");
        Logic.printSeparator();
        System.out.println("O imperador se revela, mostrando-se como o responsável por tudo que houve.");
        System.out.println("Ele levanta sua arma sem uma palavra.");
        System.out.println("Essa é a última batalha.");
        Logic.anythingToContinue();
    }

    public static void printEnd(Player player) {
        Logic.clearConsole();
        Logic.printSeparator();
        System.out.println("Com muito esforço, " + player.name + " derrota o Imperador Supremo.");
        Logic.printSeparator();
        System.out.println("Com a maldade do Imperador desfeita, a paz retorna.");
        System.out.println("Obrigado por jogar!");
    }
}
