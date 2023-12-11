package cl.litscl.clipboardswingapp;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class StartFrame extends JFrame {
	private JPanel contentPane;
	private JButton btnCopiar;
	private JTextArea textAreaTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartFrame frame = new StartFrame();
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
	public StartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCopiar = new JButton("Copiar");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtener el texto seleccionado en el JTextArea.
                String texto = textAreaTexto.getText();

                //Obtener el sistema de transferencia de datos.
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

                //Crear un objeto de tipo Transferable.
                Transferable transferable = new StringSelection(texto);

                //Establecer el objeto de tipo Transferable en el portapapeles.
                clipboard.setContents(transferable, null);
                
                System.out.println("¡Texto copiado!");
			}
		});
		btnCopiar.setBounds(169, 157, 89, 23);
		contentPane.add(btnCopiar);
		
		textAreaTexto = new JTextArea();
		textAreaTexto.setBounds(10, 11, 414, 135);
		textAreaTexto.setText("Escribe tu texto aquí...");
		contentPane.add(textAreaTexto);
	}
}