package ui;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlABMPersona;
import entity.Persona;
import util.AppDataException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class formulogin extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrase�a;

	/**
	 * Launch the application.
	 */
	public void start() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formulogin frame = new formulogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public formulogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSdf = new JLabel("Usuario");
		
		JLabel lblContrasea = new JLabel("Contrase�a");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		txtContrase�a = new JPasswordField();
		txtContrase�a.setColumns(10);
		
		JButton btnAceptar = new JButton("Iniciar Sesion");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					iniciarSesion();
				} catch (AppDataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			
			
			//INICIA SESION DESDE CONTROLERS PERSONA, NO SE SI ESTARA BIEN
			private void iniciarSesion() throws AppDataException {
				CtrlABMPersona ctrl = new CtrlABMPersona();
				Persona p = new Persona ();
				p = mapearDeForm();
				Boolean valido = ctrl.validarUSR(p);
				if (valido==true) {ctrl.principalFrame(); contentPane.setVisible(false);} else {
					JOptionPane.showMessageDialog(contentPane, "Usuario erroneo o no habilitado, intente nuevamente");
					cleanscreen();
				}				
				// TODO Auto-generated method stub
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSdf)
								.addComponent(lblContrasea))
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtContrase�a)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAceptar)
							.addGap(58)))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSdf)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblContrasea)
						.addComponent(txtContrase�a, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAceptar)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	@SuppressWarnings("deprecation")
	private Persona mapearDeForm(){
		Persona p=new Persona();
		p.setUsuario(this.txtUsuario.getText());
		p.setContrase�a(this.txtContrase�a.getText());
		return p;
	}

	private void cleanscreen(){
		this.txtUsuario.setText("");
		this.txtContrase�a.setText("");
		
	}

	
}

