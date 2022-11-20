package console.estrategia;

public class NivelFacil implements GrauDeDificuldade {

    @Override
    public double retornoMercadoAtual(Strategy strategy) {
        return 100;
    }


    
}
