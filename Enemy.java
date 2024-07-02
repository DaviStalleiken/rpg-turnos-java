public class Enemy  extends Character{

    //Verifica o xp atual do jogador e calcula ataques de acordo
    int playerXp;

    //Construtor
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random()*playerXp + (double) playerXp /3 + 5), (int) (Math.random()*playerXp + (double) playerXp /4 + 2) + 1);
        this.playerXp = playerXp;
    }

    //Ataque e defesa para inimigos
    @Override
    public int attack() {
        return (int) (Math.random()*((double) playerXp /4 + 1) + (double) xp /4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*((double) playerXp /4 + 1) + (double) xp /4 + 3);
    }
}
