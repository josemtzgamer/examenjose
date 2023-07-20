package Vista;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorJ;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class PANTALLA extends JFrame {

	private ControladorJ controlador = new ControladorJ();
	private JPanel contentPane;
	
	//datos
	private JTextField Nombre;
	private JTextField Id;
	private JTextField Altura;
	private JTextField Dorsal;
	
	//Etiquetas
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblAltura;
	private JLabel lblDorsal;
	
	
	private JMenuItem Delete;
	private JTable table;
	private JButton actualizarbarra;
	private JTable table_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PANTALLA frame = new PANTALLA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public PANTALLA() {
		
		setBackground(new Color(192, 192, 192));
		setTitle("Pantalla J");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PANTALLA.class.getResource("/img/ICON 1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 535);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Nombre = new JTextField();
		Nombre.setBounds(106, 278, 97, 20);
		Nombre.setFont(new Font("Arial", Font.PLAIN, 12));
		Nombre.setBorder(createCustomBorder(1, 1, 1, 1, new Color(0, 102, 204)));
		contentPane.add(Nombre);
		
		Id = new JTextField();
		Id.setBounds(106, 247, 30, 20);
		Id.setFont(new Font("Arial", Font.PLAIN, 12));
		Id.setBorder(createCustomBorder(1, 1, 1, 1, new Color(0, 102, 204)));
		contentPane.add(Id);
		
		Altura = new JTextField();
		Altura.setBounds(106, 309, 47, 20);
		Altura.setFont(new Font("Arial", Font.PLAIN, 12));
		Altura.setBorder(createCustomBorder(1, 1, 1, 1, new Color(0, 102, 204)));
		contentPane.add(Altura);
		
		Dorsal = new JTextField();
		Dorsal.setBounds(106, 340, 97, 20);
		Dorsal.setFont(new Font("Arial", Font.PLAIN, 12));
		Dorsal.setBorder(createCustomBorder(1, 1, 1, 1, new Color(0, 102, 204)));
		contentPane.add(Dorsal);
		
		lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.BOLD, 12));
		lblId.setBounds(55, 250, 46, 14);
		contentPane.add(lblId);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(41, 281, 60, 14);
		contentPane.add(lblNombre);
		
		lblAltura = new JLabel("ALTURA");
		lblAltura.setFont(new Font("Arial", Font.BOLD, 12));
		lblAltura.setBounds(41, 312, 60, 14);
		contentPane.add(lblAltura);
		
		lblDorsal = new JLabel("DORSAL");
		lblDorsal.setFont(new Font("Arial", Font.BOLD, 12));
		lblDorsal.setBounds(41, 343, 60, 14);
		contentPane.add(lblDorsal);
		
		// Estilos adicionales
		contentPane.setBackground(new Color(128, 128, 128));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 648, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem Anadir = new JMenuItem("Añadir");
		Anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Añade a la base de datos
				if(controlador.tamañoBD()>= 12) {
					JOptionPane.showMessageDialog(null, "Tamaño maximo alcanzado, elimina o modifica registros");
					
				}
				else {
				if(controlador.existeEnBaseDeDatos(Integer.parseInt(Id.getText()))) {
					
					controlador.modificarEnBaseDeDatos(Integer.parseInt(Id.getText()), Nombre.getText(), Integer.parseInt(Dorsal.getText()),Double.parseDouble(Altura.getText()));
				}else {
					controlador.guardarEnBaseDatos(controlador.maxBD()+1, Nombre.getText(), Integer.parseInt(Dorsal.getText()),Double.parseDouble(Altura.getText()));
				}
				
			}
			}
		});
		Anadir.setIcon(new ImageIcon(PANTALLA.class.getResource("/img/icono1.png")));
		Anadir.setSelectedIcon(new ImageIcon(PANTALLA.class.getResource("/img/icono1.png")));
		mnNewMenu.add(Anadir);
		
		Delete = new JMenuItem("Eliminar");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controlador.existeEnBaseDeDatos(Integer.parseInt(Id.getText()))) {
					
					controlador.eliminarDeDaseDatos(Integer.parseInt(Id.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "No existe");
				}
			}
		});
		Delete.setIcon(new ImageIcon(PANTALLA.class.getResource("/img/icono2.png")));
		mnNewMenu.add(Delete);
		
		JMenuItem Listar = new JMenuItem("listar");
		Listar.setIcon(new ImageIcon(PANTALLA.class.getResource("/img/icon5.png")));
		Listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controlador.listarBaseDeDatos());
			}
		});
		mnNewMenu.add(Listar);
		
		JMenu mtabla = new JMenu("Tabla");
		menuBar.add(mtabla);
		
		JMenuItem OpTabla = new JMenuItem("Cargar Tabla");
		OpTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controlador.volcar(table_1);
				
				
				
				
				
			}
		});
		OpTabla.setIcon(new ImageIcon(PANTALLA.class.getResource("/img/icono1.png")));
		mtabla.add(OpTabla);
		
		JProgressBar progressBar = new JProgressBar();
		
		progressBar.setValue(controlador.tamañoBD());
		
		
		
		progressBar.setMinimum(0);
		progressBar.setMaximum(12);
		progressBar.setBounds(10, 471, 146, 14);
		contentPane.add(progressBar);
		
		JLabel l5 = new JLabel("Espacio base de datos");
		l5.setBounds(21, 446, 115, 14);
		contentPane.add(l5);
		
		
		
		actualizarbarra = new JButton("Actualizar");
		actualizarbarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				progressBar.setValue(controlador.tamañoBD());
			}
		});
		actualizarbarra.setBounds(26, 412, 110, 23);
		contentPane.add(actualizarbarra);
	
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(260, 231, 388, 192);
		contentPane.add(table_1);
	}

	private Border createCustomBorder(int top, int left, int bottom, int right, Color color) {
		return BorderFactory.createMatteBorder(top, left, bottom, right, color);
	}
}
