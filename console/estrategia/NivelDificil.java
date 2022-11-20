
package console.estrategia;

public class NivelDificil implements GrauDeDificuldade {

    @Override
    public double retornoMercadoAtual(Strategy strategy) {
        return 300;
    }


    
}
