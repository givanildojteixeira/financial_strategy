package console.estrategia;

public class Strategy {
    public static final int INICIANTE = 1;
    public static final int FACIL = 2;
    public static final int MODERADO = 3;
    public static final int DIFICIL = 4;
    public static final int TADESACANAGEM = 5;

    protected GrauDeDificuldade estrategiaNivelDificuldade;

    public Strategy(int nivelDificuldade) {
        switch (nivelDificuldade) {
            case INICIANTE:
                estrategiaNivelDificuldade = new NivelIniciante();
                break;
            case FACIL:
                estrategiaNivelDificuldade = new NivelFacil();
                break;
            case MODERADO:
                estrategiaNivelDificuldade = new NivelModerado();
                break;
            case DIFICIL:
                estrategiaNivelDificuldade = new NivelDificil();
                break;
            case TADESACANAGEM:
                estrategiaNivelDificuldade = new NivelTaDeSacanagem();
                break;
            default:
                estrategiaNivelDificuldade = new NivelIniciante();
                break;
        }
    }
    public double calcularValorPerdido(){
        return estrategiaNivelDificuldade.retornoMercadoAtual(this);
        
    }

}
