package agentes;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import java.util.Random;

public class RegresionSimpleAgent extends Agent {
    protected void setup() {
        double [] x = {13, 16, 19, 25, 28, 38, 50, 55, 60};
        double [] y = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
        
        Regresion regresion = new Regresion(x, y);
        regresion.ecuacion();

        addBehaviour(new OneShotBehaviour() {
            public void action() {
                System.out.println("Correlacion: " + regresion.getCorrelacion());
                System.out.println("Coeficiente de determinacion: " + regresion.getDeterminacion());

                double[] predicciones = {10, 20, 30, 40, 50};
                for (int i = 0; i < predicciones.length; i++) {
                    double prediccion = regresion.resultado(predicciones[i]);
                    System.out.println("Prediccion para Advertising = " + predicciones[i] + ": " + prediccion);
                }
            }
        });
    }
}
