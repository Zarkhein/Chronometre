package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fenetre extends JFrame implements Runnable{

    int LargeurFenetre;
    int LongeurFenetre;

    //Ecran
    int longeurChronoX;
    int largeurChronoY;
    int ecranWidth;
    int ecranHeigth;

    //TextChrono

    int textChronoS;
    int textChronoMm;
    int textChronoDs;
    int textChronoX;
    int textChronoY;

    int[] PolyPointsX={100, 150, 200, 250};
    int[] PolyPointsY={100, 373, 100, 400};


    public Fenetre(){
        LargeurFenetre = 500;
        LongeurFenetre = 500;
        longeurChronoX = 50;
        largeurChronoY = 200;
        ecranWidth = 400;
        ecranHeigth = 100;

        //TextChrono
        textChronoDs = 0;
        textChronoS = 0;
        textChronoMm = 0;
        textChronoX = 200;
        textChronoY = 250;

        //PolyPointsX



        setVisible(true);
        //setResizable(false);
        setSize(LongeurFenetre, LargeurFenetre);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp = new JPanel(){
            public void paint(Graphics g)
            {
                super.paint(g);
                //g.drawRect(longeurChronoX, largeurChronoY, ecranWidth, ecranHeigth);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
                String minutes = String.format("%02d", textChronoMm);
                g.drawString(minutes +" : "+ String.valueOf(textChronoS)+" : "+String.valueOf(textChronoDs), textChronoX, textChronoY);
                g.draw3DRect(longeurChronoX, largeurChronoY, ecranWidth, ecranHeigth, true);
                g.drawPolygon(PolyPointsX, PolyPointsY, PolyPointsX.length);

            }

        };
        this.add(jp);
        }



        @Override
        public  void run() {

            int n =  0 ;
            while (n++ <  100) {
                try {
                    textChronoS += 1;

                    if(textChronoS == 60)
                    {
                        textChronoMm += 1;
                        textChronoS = 0;
                    }

                    if(textChronoDs == 60)
                    {
                        textChronoS += 1;
                        textChronoDs = 0;
                    }

                    if(textChronoMm == 60)
                    {
                        textChronoMm = 0;
                    }
                    repaint();
                    Thread.sleep(1000) ;
                }  catch (InterruptedException e) {

                    // gestion de l'erreur
                }
            }
        }
}
