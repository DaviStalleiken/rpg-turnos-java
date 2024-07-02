public class Warrior extends Character{
    int numAtkUpgrades, numDefUpgrades;

    public Warrior(String name, int maxHp, int xp) {
        super(name, maxHp, xp);
    }

    @Override
    public int attack() {
        return (int) (Math.random() * ((double) xp /4 + numAtkUpgrades * 3 + 3) + (double) xp /10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * ((double) xp /4 + numDefUpgrades * 3 + 3) + (double) xp /10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }
}
