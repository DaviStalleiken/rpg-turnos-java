public class Character {
    public String name;
    public int maxHp, hp, xp;

    //Construtor
    public Character(String name, int maxHp, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
    }

    //Métodos de ataque e defesa para todos os personagens
    public int attack() {
        return 0;
    }

    public int defend() {
        return 0;
    }
}
