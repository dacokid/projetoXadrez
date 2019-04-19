public class Bispo extends Peca {

    public Bispo(Casa casa, char cor) {
        super(casa, cor);
    }

    public boolean haPecas(Tabuleiro tabuleiro, Casa destino) {
        boolean haPecas = false;
        
        if(destino.getX() > casa.getX() && destino.getY() > casa.getY()) {    
                for(int x = casa.getX() + 1, y = casa.getY() + 1; y < destino.getY(); y++) {
                        if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null) {
                               haPecas = true;
                               break;
                        }
                }                    
        }
        else if(destino.getX() > casa.getX() && destino.getY() < casa.getY()){
                for(int y = casa.getY() - 1 ; y > destino.getY(); y--){
                        if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null) {
                               haPecas = true;
                               break;
                             }
                } 
        }
        else if(destino.getX() < casa.getX() && destino.getY() < casa.getY()){   
               for(int y = casa.getY() - 1; y > destino.getY(); y--) {
                       if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null) {
                              haPecas = true;
                              break;
                       }
               }
        }
        else if(destino.getX() < casa.getX() && destino.getY() > casa.getY()){
                for(int y = casa.getY() + 1; y < destino.getY(); y++) {
                         if(tabuleiro.getCasa(casa.getX(), y).getPeca() != null) {
                               haPecas = true;
                               break;
                         }   
                }
        }          

        else {
                haPecas = true;
        }
        
        return haPecas;
        
    }

    public boolean captura(Casa destino) {
        if(destino.getPeca() != null && destino.getPeca().getCor() != cor) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean podeMover(Casa destino) {
        int deltaX = Math.abs(destino.getX() - casa.getX());
        int deltaY = Math.abs(destino.getY() - casa.getY());
        if(destino.getPeca() == null && deltaX == deltaY) {
            return true;
        }
        else {
            return false;
        }
    }

}