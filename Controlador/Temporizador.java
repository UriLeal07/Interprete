package Controlador;

import java.util.TimerTask;

public class Temporizador extends TimerTask
{
    private int i = 0;
    
    @Override
    public void run()
    {
        System.out.println("Task Done! "+i);
        
        Interprete.timer.cancel();
        Interprete.timer.purge();
    }
}