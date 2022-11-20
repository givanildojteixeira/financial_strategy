package console.estrategia;

public class NivelModerado implements GrauDeDificuldade {

    @Override
    public double retornoMercadoAtual(Strategy strategy) {
        return 200;
    }


    
}
