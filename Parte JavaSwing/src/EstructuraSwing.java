import javax.swing.*;
import java.awt.*;

/*
A estructura queda organizada así:

EstructuraSwing (JFrame)
├── header (JPanel)
│   └── JLabel ("<header>")
├── central (JPanel)
│   ├── nav (JPanel)
│   │   └── JLabel ("<nav>")
│   ├── section (JPanel)
│   │   ├── JLabel ("<section>")
│   │   ├── centro (JPanel)
│   │   │   ├── sectionHeader (JPanel)
│   │   │   │   └── JLabel ("<header>")
│   │   │   ├── article (JPanel)
│   │   │   │   └── JLabel ("<article>")
│   │   │   └── sectionFooter (JPanel)
│   │   │       └── JLabel ("<footer>")
│   └── aside (JPanel)
│       └── JLabel ("<aside>")
└── footer (JPanel)
    └── JLabel ("<footer>")
 */

public class EstructuraSwing extends JFrame {

    public EstructuraSwing() {
        setTitle("Estructura HTML en Swing");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Co null aparece no centro
        setLayout(new BorderLayout());

        //Creo o header
        JPanel header = new JPanel();
        header.add(new JLabel("<html><font color='white'>Cabeceira</font></html>"));
        header.setBorder(BorderFactory.createMatteBorder(10,0,10,0,Color.decode("#CD5C5C")));
        header.setBackground(Color.decode("#CD5C5C"));


        /*
         Creo o nav
         Co gridBagLayout consigo que quede centrado o texto
         */
        JPanel nav = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        //JLabel nav = new JLabel("<html><font color='white'>&lt;nav></font></html>");
        JLabel navLabel = new JLabel("<html><div style='color: white; text-align: center;'>Menú de <br> Navegación</div></html>", SwingConstants.CENTER);
        //Co setPreferredSize establece a dimension preferente para igualar o ancho
        //Co setMinimumSize consigue que non rompa o pasar do PreferredSize
        navLabel.setPreferredSize(new Dimension(80,100));
        navLabel.setMinimumSize(new Dimension(80,100));

        nav.add(navLabel, gbc);
        nav.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 5, Color.white));
        nav.setBackground(Color.decode("#CD5C5C"));

        /*
        Creo o Section
         */
        JPanel section = new JPanel(new BorderLayout());
        /*
        Creo o header dentro de Section
         */
        JPanel sectionHeader = new JPanel();
        sectionHeader.add(new JLabel("<html><div style='color: white;'>Artigo</div></html>"));
        sectionHeader.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#CD5C5C"), 2),
                BorderFactory.createLineBorder(Color.decode("#7ABCDE"), 5)
        ));
        sectionHeader.setBackground(Color.decode("#7ABCDE"));
        sectionHeader.setForeground(Color.white);

        /*
        Creo o article e centro o texto
         */
        JPanel article = new JPanel(new GridBagLayout());
        GridBagConstraints gbcArticle = new GridBagConstraints();
        gbcArticle.gridx = 0;
        gbcArticle.gridy = 0;
        gbcArticle.weightx = 1;
        gbcArticle.weighty = 1;
        gbcArticle.anchor = GridBagConstraints.CENTER;
        gbcArticle.fill = GridBagConstraints.NONE;

        JLabel articleLabel = new JLabel("<html><div style='color: white;'>Artigo</div></html>", SwingConstants.CENTER);
        article.add(articleLabel, gbcArticle);
        article.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#CD5C5C"), 2),
                BorderFactory.createLineBorder(Color.decode("#7ABCDE"), 5)
        ));
        article.setBackground(Color.decode("#7ABCDE"));

        /*
        Creo o footer dentro de Section
         */
        JPanel sectionFooter = new JPanel();
        sectionFooter.add(new JLabel("<html><font color='white'>Artigo</font></html>"));
        sectionFooter.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#CD5C5C"), 2),
                BorderFactory.createMatteBorder(20,10,20,10,Color.decode("#7ABCDE"))
        ));
        sectionFooter.setBackground(Color.decode("#7ABCDE"));


        //Mete o do section en Centro
        JPanel centro = new JPanel(new BorderLayout());
        centro.add(sectionHeader, BorderLayout.NORTH);
        centro.add(article, BorderLayout.CENTER);
        centro.add(sectionFooter, BorderLayout.SOUTH);
        centro.setBorder(BorderFactory.createMatteBorder(0,5,0,5,Color.decode("#CD5C5C")));
        centro.setBackground(Color.decode("#CD5C5C"));


        //Mete Centro dentro do section
        section.add(centro);
        section.setBorder(BorderFactory.createMatteBorder(10,2,20,1,Color.decode("#CD5C5C")));
        section.setBackground(Color.decode("#CD5C5C"));

        //Mete dentro de central o Nav, Section e o Aside, máis o arreglo feito con grid
        JPanel central = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.3;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        central.add(nav, c);

        c.gridx = 1;
        c.gridwidth = 1;
        c.weightx = 0.7;
        central.add(section, c);

        central.setBorder(BorderFactory.createMatteBorder(5,0,5,0,Color.WHITE));
        central.setBackground(Color.decode("#CD5C5C"));

        /*
        Creo o footer
         */
        JPanel footer = new JPanel();
        footer.add(new JLabel("<html><font color='white'>Pé</font></html>"));
        footer.setBackground(Color.decode("#CD5C5C"));

        // Añadir los paneles al JFrame
        add(header, BorderLayout.NORTH);
        add(central, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EstructuraSwing frame = new EstructuraSwing();
            frame.setVisible(true);
        });
    }
}