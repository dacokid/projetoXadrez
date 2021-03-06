
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        Casa casa;
        Peca peca;

        casa = tabuleiro.getCasa(0,0);
        peca = new Torre(casa, 'b');

        casa = tabuleiro.getCasa(7,0);
        peca = new Torre(casa, 'b');

        casa = tabuleiro.getCasa(0,7);
        peca = new Torre(casa, 'p');

        casa = tabuleiro.getCasa(7,7);
        peca = new Torre(casa, 'p');
        
        casa = tabuleiro.getCasa(2,0);
        peca = new Bispo(casa, 'b');
        
        casa = tabuleiro.getCasa(5,0);
        peca = new Bispo(casa, 'b');
        
        casa = tabuleiro.getCasa(2,7);
        peca = new Bispo(casa, 'p');
        
        casa = tabuleiro.getCasa(5,7);
        peca = new Bispo(casa, 'p');
        
        

        /*for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {
                if(y == 0) {
                    if(x == 0 || x ==7) {
                        casa = tabuleiro.getCasa(x, y);
                        peca = new Peca(casa, Peca.TORRE_BRANCA);
                    }
                    else if(x == 1 || x == 6) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.CAVALO_BRANCO);
                    }
                    else if(x == 2 || x == 5) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.BISPO_BRANCO);
                    }
                    else if(x == 3) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.RAINHA_BRANCA);
                    }
                    else {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.REI_BRANCO);
                    }
                }
                else if(y == 7) {
                    if(x == 0 || x ==7) {
                        casa = tabuleiro.getCasa(x, y);
                        peca = new Peca(casa, Peca.TORRE_PRETA);
                    }
                    else if(x == 1 || x == 6) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.CAVALO_PRETO);
                    }
                    else if(x == 2 || x == 5) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.BISPO_PRETO);
                    }
                    else if(x == 3) {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.RAINHA_PRETA);
                    }
                    else {
                        casa = tabuleiro.getCasa(x,y);
                        peca = new Peca(casa, Peca.REI_PRETO);
                    }
                }
                else if(y == 1) {
                    casa = tabuleiro.getCasa(x,y);
                    peca = new Peca(casa, Peca.PEAO_BRANCO);
                }
                else if(y == 6) {
                    casa = tabuleiro.getCasa(x,y);
                    peca = new Peca(casa, Peca.PEAO_PRETO);
                }
            }
        }*/
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();

        if(!(peca.haPecas(tabuleiro, destino))) {
            if(peca.captura(destino)) {
                eliminarPeca(destino);
                peca.mover(destino);
            }
            else if(peca.podeMover(destino)) {
                peca.mover(destino);
            }
        }
    }

    public void eliminarPeca(Casa casa) {
        casa.removerPeca();
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
