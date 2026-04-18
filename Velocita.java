package ES1;

public enum Velocita {
    BASSA (60),
    MEDIOBASSA (80),
    MEDIA (120),
    MEDIOALTA (180),
    ALTA (250),
    ALTISSIMA (300);

    private final int kmh;
    Velocita(int kmh){
        this.kmh = kmh;
    }

    public int getVelocita(){return kmh;}
}
