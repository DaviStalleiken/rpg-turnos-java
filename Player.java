public class Player extends Character{

    //Possibilidades de upgrades
    public int numAtkUpgrades, numDefUpgrades;

    //Coisas que o jogador pode fazer
    int gold, restsLeft, vocation;

    //Skills possíveis de se obter
    public String[] atkUpgrades = {"Espada", "Machado", "Lança", "Manoplas"};
    public String[] defUpgrades = {"Capacete", "Armadura de Peito", "Armadura de braços", "Armadura de Pernas"};

    //Construtor
    public Player(String name) {
        super(name, 100, 0);
        //Seta os upgrades para 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //Seta o número de tenda para descanso
        this.restsLeft = 1;

        //Deixa o jogador escolher um upgrade
        chooseTrait();
    }


    //Atacar e Defender
    @Override
    public int attack() {
        return (int) (Math.random() * ((double) xp /4 + numAtkUpgrades * 3 + 3) + (double) xp /10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * ((double) xp /4 + numDefUpgrades * 3 + 3) + (double) xp /10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    //Deixa o jogador escolhar um upgrade
    public void chooseTrait() {
        Logic.clearConsole();
        Logic.printHeading("Escolha um upgrade: ");
        System.out.println("1 - " + atkUpgrades[numAtkUpgrades]);
        System.out.println("2 - " + defUpgrades[numDefUpgrades]);

        //Escolha do jogador
        int input = Logic.readInt("- ", 2);
        Logic.clearConsole();
        //Lida com cada caso
        if (input == 1) {
            Logic.printHeading("Você escolheu " + atkUpgrades[numAtkUpgrades]);
            numAtkUpgrades++;
        } else {
            Logic.printHeading("Você escolheu " + defUpgrades[numDefUpgrades]);
            numDefUpgrades++;
        }
        Logic.anythingToContinue();
    }
}
