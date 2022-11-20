package console.estrategia;

public class NivelTaDeSacanagem implements GrauDeDificuldade {

    @Override
    public double retornoMercadoAtual(Strategy strategy) {
        return 400;
    }
    
}
