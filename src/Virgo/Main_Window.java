package Virgo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Window {
    private JPanel Main;
    private JTabbedPane MainTab;
    private JPanel Inputs;
    private JPanel Calculation;
    private JButton Generate;
    private JPanel GirlDet;
    private JPanel BoyDet;
    private JTextField BName;
    private JTextField GName;
    private JTextField BBD;
    private JTextField BBT;
    private JTextField GBD;
    private JTextField GBT;
    private JTextField BLat;
    private JTextField BLon;
    private JTextField GLat;
    private JTextField GLon;
    private JEditorPane Details;

    public Main_Window() {
        Generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Horoscope Boy = new Horoscope(BName.getText(),BBD.getText(),BBT.getText(),BLat.getText(),BLon.getText());
                Horoscope Girl = new Horoscope(GName.getText(),GBD.getText(),GBT.getText(),GLat.getText(),GLon.getText());
                Boy.process();
                Girl.process();
                //System.out.println(Boy.planetlist.get(1).Nakshatra);
                //System.out.println(Girl.planetlist.get(1).Nakshatra);
                Astakoot koot = new Astakoot(Integer.parseInt(Boy.planetlist.get(1).Nakshatra),Integer.parseInt(Girl.planetlist.get(1).Nakshatra),Integer.parseInt(Boy.planetlist.get(1).Raasi),Integer.parseInt(Girl.planetlist.get(1).Raasi));
                int a = koot.calcDinaKuta();
                Constants constants = new Constants();
                String HTMLMaker = "";
                Details.setContentType("text/html");
                HTMLMaker = "<html><body><table>";
                HTMLMaker +="<tr><td>Boy Name</td><td>"+Boy.Name+"</td></tr>";
                HTMLMaker +="<tr><td>Girl Name</td><td>"+Girl.Name+"</td></tr>";
                HTMLMaker +="<tr><td>Boy Nakshatra</td><td>"+constants.nakshatra[Integer.parseInt(Boy.planetlist.get(1).Nakshatra)]+"</td></tr>";
                HTMLMaker +="<tr><td>Girl Nakshatra</td><td>"+constants.nakshatra[Integer.parseInt(Girl.planetlist.get(1).Nakshatra)]+"</td></tr>";
                HTMLMaker +="<tr><td>Boy Raasi</td><td>"+Boy.planetlist.get(1).Raasi+"</td></tr>";
                HTMLMaker +="<tr><td>Girl Raasi</td><td>"+Girl.planetlist.get(1).Raasi+"</td></tr>";
                HTMLMaker +="<tr><td>Varna</td><td>"+String.valueOf(koot.calcVarnaKoota())+"</td></tr>";
                HTMLMaker +="<tr><td>Vaisya</td><td>"+String.valueOf(koot.calcVasyaKoota())+"</td></tr>";
                HTMLMaker +="<tr><td>Tara</td><td>"+String.valueOf(koot.calcTara())+"</td></tr>";
                HTMLMaker +="<tr><td>Yoni</td><td>"+String.valueOf(koot.calcYoni())+"</td></tr>";
                HTMLMaker +="<tr><td>Maitri</td><td>"+String.valueOf(koot.calcMaitri())+"</td></tr>";
                HTMLMaker +="<tr><td>Gana</td><td>"+String.valueOf(koot.calcGanaKuta())+"</td></tr>";
                HTMLMaker +="<tr><td>Bahkut</td><td>"+String.valueOf(koot.calcBahkut())+"</td></tr>";

                HTMLMaker+="</table>";
                HTMLMaker+="</center></body></html>";

                Details.setText(HTMLMaker);
            }
        });
    }
    public void Log(String s){
        System.out.println(s);
    }
    public static void main(String[] args) {
        Main_Window mainWin = new Main_Window();
        JFrame Frame = new JFrame("Virgo");
        Frame.setContentPane(mainWin.Main);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.setVisible(true);
        mainWin.BName.setText("Ravi");
        mainWin.GName.setText("Teja");
        mainWin.BBD.setText("16/9/1993");
        mainWin.GBD.setText("6/8/1995");
        mainWin.BBT.setText("17:55:00");
        mainWin.GBT.setText("0:7:00");
        mainWin.BLat.setText("16.9604");
        mainWin.GLat.setText("17.0052");
        mainWin.BLon.setText("82.2381");
        mainWin.GLon.setText("81.7778");
    }

}
