/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistaJuego;

import ControladorJuegoMemoria.ControlCartaTablero.controladorCartaTablero.TableroControl;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;
import jugadores.Jugador;
import Cronometro.cronometro;
import ControladorJuegoMemoria.CronometroControl;
import ControladorJuegoMemoria.jugador;

public class frmJuego extends javax.swing.JFrame {

    private int dificultad;
    private JButton[] btns;
    private String nombreJugador;
    private int[] parejas;
    private int[] imagenCarta;
    private int cantidadBotones;
    private Cronometro.cronometro cronModelo;
    private Jugador jugadorModelo;
    private ControladorJuegoMemoria.jugador jugadorControlador;
    private ControladorJuegoMemoria.CronometroControl cronometro;
    private Timer timer;
    private TableroControl tableroControlador;
    private int primeraCarta = -1;
    private int segundaCarta = -1;
    private boolean esperando = false;

    private static final java.util.logging.Logger logger
            = java.util.logging.Logger.getLogger(frmJuego.class.getName());
    
    
    public frmJuego() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public frmJuego(int dificultad, String nombreJugador) {

        initComponents();

        this.dificultad = dificultad;
        this.nombreJugador = nombreJugador;

        jugadorModelo = new Jugador(nombreJugador);
        jugadorControlador = new jugador(jugadorModelo);

        cronModelo = new cronometro();
        cronometro = new CronometroControl(cronModelo);
        
        cargarBotones();
        configurarTablero();
        configurarEventos();

        lblnombreJugador.setText(nombreJugador);
        lblMovimientos.setText("0");
        lblParesEncontrados.setText(
                "0 / " + (cantidadBotones / 2)
        );
        
        lblTiempo.setText("00:00");
        lblPuntaje.setText("0");
         timer = new Timer(1000, e -> {

    lblTiempo.setText(cronometro.obtenerTiempo());
    

});
         cronometro.iniciar();
         timer.start();
        setLocationRelativeTo(null);
    }
    
    private void cargarBotones() {

        btns = new JButton[64];

        btns[0] = jButton4;
        btns[1] = jButton26;
        btns[2] = jButton34;
        btns[3] = jButton33;
        btns[4] = jButton32;
        btns[5] = jButton31;
        btns[6] = jButton30;
        btns[7] = jButton29;
        btns[8] = jButton5;
        btns[9] = jButton25;
        btns[10] = jButton27;
        btns[11] = jButton28;
        btns[12] = jButton42;
        btns[13] = jButton41;
        btns[14] = jButton40;
        btns[15] = jButton39;
        btns[16] = jButton3;
        btns[17] = jButton24;
        btns[18] = jButton38;
        btns[19] = jButton37;
        btns[20] = jButton36;
        btns[21] = jButton35;
        btns[22] = jButton114;
        btns[23] = jButton113;
        btns[24] = jButton6;
        btns[25] = jButton23;
        btns[26] = jButton112;
        btns[27] = jButton111;
        btns[28] = jButton108;
        btns[29] = jButton107;
        btns[30] = jButton122;
        btns[31] = jButton132;
        btns[32] = jButton7;
        btns[33] = jButton22;
        btns[34] = jButton110;
        btns[35] = jButton109;
        btns[36] = jButton115;
        btns[37] = jButton130;
        btns[38] = jButton129;
        btns[39] = jButton131;
        btns[40] = jButton8;
        btns[41] = jButton21;
        btns[42] = jButton121;
        btns[43] = jButton118;
        btns[44] = jButton128;
        btns[45] = jButton127;
        btns[46] = jButton126;
        btns[47] = jButton125;
        btns[48] = jButton9;
        btns[49] = jButton20;
        btns[50] = jButton120;
        btns[51] = jButton117;
        btns[52] = jButton124;
        btns[53] = jButton138;
        btns[54] = jButton136;
        btns[55] = jButton135;
        btns[56] = jButton10;
        btns[57] = jButton19;
        btns[58] = jButton119;
        btns[59] = jButton116;
        btns[60] = jButton123;
        btns[61] = jButton137;
        btns[62] = jButton134;
        btns[63] = jButton133;
    }
    private void configurarTablero() {

        switch (dificultad) {

            case 1:
                cantidadBotones = 16;
                break;

            case 2:
                cantidadBotones = 32;
                break;

            case 3:
                cantidadBotones = 64;
                break;

            default:
                cantidadBotones = 16;
                break;
        }

        for (int i = 0; i < btns.length; i++) {

            JButton boton = btns[i];

            boton.setVisible(i < cantidadBotones);

            if (i < cantidadBotones) {
                Dimension tamaño = boton.getSize();

                if (tamaño.width <= 0 || tamaño.height <= 0) {
                    tamaño = new Dimension(75, 72);
                }

                boton.setPreferredSize(tamaño);
                boton.setMinimumSize(tamaño);
                boton.setMaximumSize(tamaño);

                boton.setText("");
                boton.setIcon(null);
                boton.setEnabled(true);
            }
        }

        asignarParejas();

        pnlTablero.revalidate();
        pnlTablero.repaint();
    }

    private void asignarParejas() {

        int cantidadParejas = cantidadBotones / 2;

        parejas = new int[cantidadParejas];
        imagenCarta = new int[cantidadBotones];

        for (int i = 0; i < cantidadParejas; i++) {
            parejas[i] = 0;
        }

        for (int i = 0; i < cantidadBotones; i++) {

            int val = (int) (Math.random() * cantidadParejas);

            if (parejas[val] < 2) {

                parejas[val]++;
                imagenCarta[i] = val + 3;

            } else {

                i--;
            }
        }
    }
    private void configurarEventos() {

        for (int i = 0; i < cantidadBotones; i++) {

            final int posicion = i;

            btns[i].addActionListener(
                    e -> seleccionarCarta(posicion)
            );
        }
    }
    private void seleccionarCarta(int posicion) {

        if (esperando) {
            return;
        }

        if (posicion == primeraCarta) {
            return;
        }

        if (!btns[posicion].isEnabled()) {
            return;
        }

        mostrarCarta(posicion);

        if (primeraCarta == -1) {

            primeraCarta = posicion;

        } else {

            segundaCarta = posicion;

          jugadorControlador.intentosEjecutados();

            lblMovimientos.setText(
                    String.valueOf(jugadorControlador.obtenerMovimientos())
            );
            lblPuntaje.setText(
        String.valueOf(jugadorControlador.obtenerPuntaje())
       );

            comprobarPareja();
        }
    }
    private void mostrarCarta(int posicion) {

        JButton boton = btns[posicion];

        int ancho = boton.getWidth();
        int alto = boton.getHeight();

        if (ancho <= 0) {
            ancho = 75;
        }

        if (alto <= 0) {
            alto = 72;
        }

        URL ruta = getClass().getResource(
                "/icons/" + imagenCarta[posicion] + ".jpg"
        );

        ImageIcon iconoOriginal = new ImageIcon(ruta);

        Image imagenAjustada = iconoOriginal
                .getImage()
                .getScaledInstance(
                        ancho - 6,
                        alto - 6,
                        Image.SCALE_SMOOTH
                );

        ImageIcon iconoAjustado
                = new ImageIcon(imagenAjustada);

        boton.setText("");
        boton.setIcon(iconoAjustado);
        boton.setDisabledIcon(iconoAjustado);
    }
    private void comprobarPareja() {

    esperando = true;

    if (imagenCarta[primeraCarta] == imagenCarta[segundaCarta]) {

        btns[primeraCarta].setEnabled(false);
        btns[segundaCarta].setEnabled(false);

        jugadorControlador.ParejasEncontradas();
        
        lblPuntaje.setText(
        String.valueOf(jugadorControlador.obtenerPuntaje())
        );

        lblParesEncontrados.setText(
                jugadorControlador.obtenerPareja()
                + " / "
                + (cantidadBotones / 2)
        );

        limpiarSeleccion();

        if (jugadorControlador.obtenerPareja() == cantidadBotones / 2) {
            juegoTerminado();
        }

    } else {

        Timer tiempoEspera = new Timer(2000, e -> {

            ocultarCarta(primeraCarta);
            ocultarCarta(segundaCarta);

            limpiarSeleccion();

        });

        tiempoEspera.setRepeats(false);
        tiempoEspera.start();
    }
}
    private void ocultarCarta(int posicion) {

        if (posicion >= 0
                && posicion < cantidadBotones) {

            btns[posicion].setIcon(null);
            btns[posicion].setText("");
        }
    }
    private void limpiarSeleccion() {

        primeraCarta = -1;
        segundaCarta = -1;
        esperando = false;
    }

    private void juegoTerminado() {

    cronometro.parar();
    timer.stop();

    String tiempoFinal = cronometro.obtenerTiempo();

    frmFinal finalJuego = new frmFinal(
            nombreJugador,
            jugadorControlador.obtenerMovimientos(),
            jugadorControlador.obtenerPareja(),
            tiempoFinal,
            jugadorControlador.obtenerPuntaje(),
            dificultad
    );

    finalJuego.setVisible(true);
    dispose();
}
    private void reiniciarJuego() {
        
        
        cronometro.reiniciarTiempo();
        cronometro.iniciar();
        primeraCarta = -1;
        segundaCarta = -1;

       jugadorControlador.reiniciar();

        esperando = false;

        lblMovimientos.setText("0");
        

        lblParesEncontrados.setText(
                "0 / " + (cantidadBotones / 2)
        );
        lblPuntaje.setText("0");

        for (int i = 0; i < cantidadBotones; i++) {

            btns[i].setIcon(null);
            btns[i].setText("");
            btns[i].setEnabled(true);
        }
        

        asignarParejas();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlTablero = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jButton109 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jButton113 = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();
        jButton115 = new javax.swing.JButton();
        jButton116 = new javax.swing.JButton();
        jButton117 = new javax.swing.JButton();
        jButton118 = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        jButton120 = new javax.swing.JButton();
        jButton121 = new javax.swing.JButton();
        jButton122 = new javax.swing.JButton();
        jButton123 = new javax.swing.JButton();
        jButton124 = new javax.swing.JButton();
        jButton125 = new javax.swing.JButton();
        jButton126 = new javax.swing.JButton();
        jButton127 = new javax.swing.JButton();
        jButton128 = new javax.swing.JButton();
        jButton129 = new javax.swing.JButton();
        jButton130 = new javax.swing.JButton();
        jButton131 = new javax.swing.JButton();
        jButton132 = new javax.swing.JButton();
        jButton133 = new javax.swing.JButton();
        jButton134 = new javax.swing.JButton();
        jButton135 = new javax.swing.JButton();
        jButton136 = new javax.swing.JButton();
        jButton137 = new javax.swing.JButton();
        jButton138 = new javax.swing.JButton();
        pnlNombre = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblnombreJugador = new javax.swing.JLabel();
        pnlMovimientos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblMovimientos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlPares = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblParesEncontrados = new javax.swing.JLabel();
        pnlTiempo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlPuntaje = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblPuntaje = new javax.swing.JLabel();
        btnVolverInicio = new javax.swing.JButton();
        btnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        pnlTablero.setBackground(new java.awt.Color(42, 62, 120));

        jButton3.setText("jButton3");

        jButton4.setText("jButton3");

        jButton5.setText("jButton3");

        jButton6.setText("jButton3");

        jButton7.setText("jButton3");

        jButton8.setText("jButton3");

        jButton9.setText("jButton3");

        jButton10.setText("jButton3");

        jButton19.setText("jButton3");

        jButton20.setText("jButton3");

        jButton21.setText("jButton3");

        jButton22.setText("jButton3");

        jButton23.setText("jButton3");

        jButton24.setText("jButton3");

        jButton25.setText("jButton3");

        jButton26.setText("jButton3");

        jButton27.setText("jButton3");

        jButton28.setText("jButton3");

        jButton29.setText("jButton3");

        jButton30.setText("jButton3");

        jButton31.setText("jButton3");

        jButton32.setText("jButton3");

        jButton33.setText("jButton3");

        jButton34.setText("jButton3");

        jButton35.setText("jButton3");

        jButton36.setText("jButton3");

        jButton37.setText("jButton3");

        jButton38.setText("jButton3");

        jButton39.setText("jButton3");

        jButton40.setText("jButton3");

        jButton41.setText("jButton3");

        jButton42.setText("jButton3");

        jButton107.setText("jButton3");

        jButton108.setText("jButton3");

        jButton109.setText("jButton3");

        jButton110.setText("jButton3");

        jButton111.setText("jButton3");

        jButton112.setText("jButton3");

        jButton113.setText("jButton3");

        jButton114.setText("jButton3");

        jButton115.setText("jButton3");

        jButton116.setText("jButton3");

        jButton117.setText("jButton3");

        jButton118.setText("jButton3");

        jButton119.setText("jButton3");

        jButton120.setText("jButton3");

        jButton121.setText("jButton3");

        jButton122.setText("jButton3");

        jButton123.setText("jButton3");

        jButton124.setText("jButton3");

        jButton125.setText("jButton3");

        jButton126.setText("jButton3");

        jButton127.setText("jButton3");

        jButton128.setText("jButton3");

        jButton129.setText("jButton3");

        jButton130.setText("jButton3");

        jButton131.setText("jButton3");

        jButton132.setText("jButton3");

        jButton133.setText("jButton3");

        jButton134.setText("jButton3");

        jButton135.setText("jButton3");

        jButton136.setText("jButton3");

        jButton137.setText("jButton3");

        jButton138.setText("jButton3");

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableroLayout.createSequentialGroup()
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTableroLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton10)
                            .addComponent(jButton9)
                            .addComponent(jButton8)
                            .addComponent(jButton7)
                            .addComponent(jButton6)
                            .addComponent(jButton3)
                            .addComponent(jButton5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTableroLayout.createSequentialGroup()
                                .addComponent(jButton25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton39))
                            .addGroup(pnlTableroLayout.createSequentialGroup()
                                .addComponent(jButton21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton121)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton118)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton128)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton127)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton126)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton125))
                            .addGroup(pnlTableroLayout.createSequentialGroup()
                                .addComponent(jButton20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton120)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton117)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton138)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton136)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton135))
                            .addGroup(pnlTableroLayout.createSequentialGroup()
                                .addComponent(jButton19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton119)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton116)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton123)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton137)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton134)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton133))
                            .addGroup(pnlTableroLayout.createSequentialGroup()
                                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlTableroLayout.createSequentialGroup()
                                        .addComponent(jButton22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton110)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton109)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton131)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton115))
                                    .addGroup(pnlTableroLayout.createSequentialGroup()
                                        .addComponent(jButton23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton112)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton111)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton132)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton108))
                                    .addGroup(pnlTableroLayout.createSequentialGroup()
                                        .addComponent(jButton24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton35)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlTableroLayout.createSequentialGroup()
                                        .addComponent(jButton114)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton113))
                                    .addGroup(pnlTableroLayout.createSequentialGroup()
                                        .addComponent(jButton107)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton122))
                                    .addGroup(pnlTableroLayout.createSequentialGroup()
                                        .addComponent(jButton130)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton129))))))
                    .addGroup(pnlTableroLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton29)))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTableroLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton4)
                    .addContainerGap(591, Short.MAX_VALUE)))
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableroLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton114, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton112, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton111, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton108, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton107, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton122, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton132, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton110, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton109, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton115, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton130, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton129, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton131, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton121, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton118, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton128, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton127, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton126, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton125, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton120, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton124, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton138, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton136, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton135, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton119, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton116, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton123, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton137, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton134, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton133, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTableroLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(574, Short.MAX_VALUE)))
        );

        pnlNombre.setBackground(new java.awt.Color(42, 62, 120));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");

        lblnombreJugador.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblnombreJugador.setForeground(new java.awt.Color(255, 255, 255));
        lblnombreJugador.setText("jLabel2");

        javax.swing.GroupLayout pnlNombreLayout = new javax.swing.GroupLayout(pnlNombre);
        pnlNombre.setLayout(pnlNombreLayout);
        pnlNombreLayout.setHorizontalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNombreLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        pnlNombreLayout.setVerticalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnombreJugador)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlMovimientos.setBackground(new java.awt.Color(204, 204, 204));
        pnlMovimientos.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setText("Movimientos:");

        lblMovimientos.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblMovimientos.setText("jLabel2");

        javax.swing.GroupLayout pnlMovimientosLayout = new javax.swing.GroupLayout(pnlMovimientos);
        pnlMovimientos.setLayout(pnlMovimientosLayout);
        pnlMovimientosLayout.setHorizontalGroup(
            pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovimientosLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlMovimientosLayout.setVerticalGroup(
            pnlMovimientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMovimientosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMovimientos)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        pnlPares.setBackground(new java.awt.Color(42, 62, 120));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Parejas:");

        lblParesEncontrados.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblParesEncontrados.setForeground(new java.awt.Color(255, 255, 255));
        lblParesEncontrados.setText("jLabel2");

        javax.swing.GroupLayout pnlParesLayout = new javax.swing.GroupLayout(pnlPares);
        pnlPares.setLayout(pnlParesLayout);
        pnlParesLayout.setHorizontalGroup(
            pnlParesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlParesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblParesEncontrados, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        pnlParesLayout.setVerticalGroup(
            pnlParesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlParesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblParesEncontrados)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlTiempo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel4.setText("Tiempo:");

        lblTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblTiempo.setText("j");

        javax.swing.GroupLayout pnlTiempoLayout = new javax.swing.GroupLayout(pnlTiempo);
        pnlTiempo.setLayout(pnlTiempoLayout);
        pnlTiempoLayout.setHorizontalGroup(
            pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTiempoLayout.setVerticalGroup(
            pnlTiempoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTiempoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 153, 255));
        jLabel5.setText("Memoria Mágica");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/estrellita.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setForeground(new java.awt.Color(153, 153, 0));
        jLabel7.setText("★");

        jLabel8.setForeground(new java.awt.Color(153, 153, 0));
        jLabel8.setText("★");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/estrellita.jpg"))); // NOI18N
        jLabel9.setText("jLabel6");

        pnlPuntaje.setBackground(new java.awt.Color(42, 62, 120));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Puntaje");

        lblPuntaje.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        lblPuntaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntaje.setText("j");

        javax.swing.GroupLayout pnlPuntajeLayout = new javax.swing.GroupLayout(pnlPuntaje);
        pnlPuntaje.setLayout(pnlPuntajeLayout);
        pnlPuntajeLayout.setHorizontalGroup(
            pnlPuntajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPuntajeLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnlPuntajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlPuntajeLayout.setVerticalGroup(
            pnlPuntajeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPuntajeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrincipalLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnlMovimientos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlPuntaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(pnlTiempo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnlPares, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(pnlNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)))
                        .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(217, 217, 217)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(768, Short.MAX_VALUE)))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                                .addComponent(pnlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pnlMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(pnlPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(pnlTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(pnlPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)))
                        .addComponent(jLabel6))
                    .addComponent(pnlTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPrincipalLayout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(jLabel9)
                    .addContainerGap(639, Short.MAX_VALUE)))
        );

        btnVolverInicio.setBackground(new java.awt.Color(245, 248, 255));
        btnVolverInicio.setText("Volver al Inicio");
        btnVolverInicio.addActionListener(this::btnVolverInicioActionPerformed);

        btnReiniciar.setBackground(new java.awt.Color(245, 248, 255));
        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(this::btnReiniciarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReiniciar)
                .addGap(245, 245, 245)
                .addComponent(btnVolverInicio)
                .addGap(167, 167, 167))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReiniciar)
                    .addComponent(btnVolverInicio))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverInicioActionPerformed
    frmInicio inicio = new frmInicio();
    inicio.setVisible(true);
    inicio.setLocationRelativeTo(null);

    dispose();
    }//GEN-LAST:event_btnVolverInicioActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
    frmJuego juego = new frmJuego(dificultad, nombreJugador);
    juego.setVisible(true);
    juego.setLocationRelativeTo(null);

    dispose();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmJuego().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnVolverInicio;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton115;
    private javax.swing.JButton jButton116;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton120;
    private javax.swing.JButton jButton121;
    private javax.swing.JButton jButton122;
    private javax.swing.JButton jButton123;
    private javax.swing.JButton jButton124;
    private javax.swing.JButton jButton125;
    private javax.swing.JButton jButton126;
    private javax.swing.JButton jButton127;
    private javax.swing.JButton jButton128;
    private javax.swing.JButton jButton129;
    private javax.swing.JButton jButton130;
    private javax.swing.JButton jButton131;
    private javax.swing.JButton jButton132;
    private javax.swing.JButton jButton133;
    private javax.swing.JButton jButton134;
    private javax.swing.JButton jButton135;
    private javax.swing.JButton jButton136;
    private javax.swing.JButton jButton137;
    private javax.swing.JButton jButton138;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblMovimientos;
    private javax.swing.JLabel lblParesEncontrados;
    private javax.swing.JLabel lblPuntaje;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblnombreJugador;
    private javax.swing.JPanel pnlMovimientos;
    private javax.swing.JPanel pnlNombre;
    private javax.swing.JPanel pnlPares;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlPuntaje;
    private javax.swing.JPanel pnlTablero;
    private javax.swing.JPanel pnlTiempo;
    // End of variables declaration//GEN-END:variables
}
