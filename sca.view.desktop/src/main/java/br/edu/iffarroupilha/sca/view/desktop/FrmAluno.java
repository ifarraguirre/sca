package br.edu.iffarroupilha.sca.view.desktop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import br.edu.iffarroupilha.sca.controle.AlunoControle;
import br.edu.iffarroupilha.sca.controle.TurmaControle;
import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

/**
 * <p>
 * Interface para cadastro e edição de alunos
 * </p>
 * 
 * @since 22/03/2016 21:43
 */

public class FrmAluno extends JFrame {
	

	private JTextField jtfNome;
	private JTextField jtfEmail;
	private JTextField jtfTelefone;
	private JTextField jtfData;	
	private JButton btnGravar;
	private JScrollPane scrollPane;
	private JTable tableAlunos;
	
	
	

	public FrmAluno() {
		setTitle("Cadastro Aluno");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		desenhaComponentes();
		getContentPane().setLayout(null);
		setVisible(true);	
		
		
	}
	
	private void desenhaComponentes() {
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(45, 11, 67, 14);
		getContentPane().add(lblNome);
		
		jtfNome = new JTextField();
		jtfNome.setToolTipText("");
		jtfNome.setBounds(102, 8, 390, 20);
		getContentPane().add(jtfNome);
		jtfNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(45, 39, 58, 14);
		getContentPane().add(lblEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setBounds(102, 36, 390, 20);
		getContentPane().add(jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(36, 70, 58, 14);
		getContentPane().add(lblTelefone);
		
		jtfTelefone = new JTextField();
		jtfTelefone.setBounds(101, 67, 157, 20);
		getContentPane().add(jtfTelefone);
		jtfTelefone.setColumns(10);
		
		JLabel lblDataAniversario = new JLabel("Data Nasc:");
		lblDataAniversario.setBounds(27, 96, 67, 14);
		getContentPane().add(lblDataAniversario);
		
		jtfData = new JTextField();
		jtfData.setBounds(102, 93, 121, 20);
		getContentPane().add(jtfData);
		jtfData.setColumns(10);		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 181, 566, 190);
		getContentPane().add(scrollPane);

		// tabela
		tableAlunos = new JTable();
		tableAlunos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matr\u00EDcula", "Nome", "Email", "Telefone", "Data Nasc"
			}
		));
		tableAlunos.getColumnModel().getColumn(1).setPreferredWidth(200);
		scrollPane.setViewportView(tableAlunos); 
		
		
		//botão que grava no banco
				btnGravar = new JButton("Gravar");
				btnGravar.setBounds(101, 124, 89, 23);
				getContentPane().add(btnGravar);
		
		//ação do botão gravar
		
		btnGravar.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Turma t = new Turma();
				Aluno a = new Aluno();
				a.setNome( jtfNome.getText()  );
				a.setEmail( jtfEmail.getText()  );
				a.setTelefone( jtfTelefone.getText()  );				
				//a.setDataNascimento( jtfData.getText()  );
				//a.setTurma(t);
				
				new AlunoControle().gravar(a);
				JOptionPane.showMessageDialog(null, "Gravado com sucesso!");}
		});
           
			
           }
           

	
	public static void main(String[] args) {
		new FrmAluno();
	}
	
           }
	
	
	


