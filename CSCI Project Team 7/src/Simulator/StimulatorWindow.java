/*
 * The Simulator Window class is used to create the GUI with buttons to Load Store and Run
 * It also has display box to show the values present in each of the component in the system
 * The switch buttons are used to enter commands in binary
 * The values entered are processed and the results are displayed in the screen
 */
package Simulator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ALU.Operations;
import Memory.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import Registers.*;
import Utils.*;
import javax.swing.JRadioButton;
import java.awt.Component;



public class StimulatorWindow {

	private JFrame CSCIProjectTeam7;
	private JLabel Operation;
	private JPanel AddressPanel;
	private JPanel GPRPanel;
	private JPanel IXRPanel;
	private JPanel IPanel;
	private JButton OperationBit15;
	private JButton OperationBit14;
	private JButton OperationBit13;
	private JButton OperationBit12;
	private JButton OperationBit11;
	private JButton OperationBit10;
	private JButton GPRBit09;
	private JLabel GPR;
	private JButton GPRBit08;
	private JLabel IXR;
	private JButton IXRBit07;
	private JButton IXRBit06;
	private JLabel I;
	private JButton IBit05;
	private JLabel Address;
	private JButton AddressBit04;
	private JButton AddressBit03;
	private JButton AddressBit02;
	private JButton AddressBit01;
	private JButton AddressBit00;
	private JPanel GPRIXRPanel;
	private JPanel AddressRegisterPanel;
	private JTextField GPR0;
	private JTextField GPR1;
	private JTextField GPR2;
	private JTextField GPR3;
	private ArrayList<JTextField> GPRTextList = new ArrayList<JTextField>();
	private JTextField IXR1;
	private JTextField IXR2;
	private JTextField IXR3;
	private ArrayList<JTextField> IXRTextList = new ArrayList<JTextField>();
	private JTextField PC;
	private JTextField MAR;
	private JTextField MBR;
	private JTextField IR;
	private JTextField MFR;
	private JPanel ButtonPanel;
	private JLabel GPR0Label;
	private JLabel GPR1Label;
	private JLabel GPR2Label;
	private JLabel GPR3Label;
	private JLabel IXR1Label;
	private JLabel IXR2Label;
	private JLabel IXR3Label;
	private JLabel ProgramCounter;
	private JLabel MemoryAddressRegister;
	private JLabel MemoryBufferRegister;
	private JLabel InstructionRegister;
	private JLabel MemoryFaultRegister;
	private JButton StoreButton;
	private JButton StorePlus;
	private JButton LoadButton;
	private JButton RunButton;
	private JButton SingleStep;
	private JButton IPLButton;
	private JButton LoadButtonGPR0;
	private JButton LoadButtonGPR1;
	private JButton LoadButtonGPR2;
	private JButton LoadButtonGPR3;
	private JButton LoadButtonIXR1;
	private JButton LoadButtonIXR2;
	private JButton LoadButtonIXR3;
	private JButton LoadButtonPC;
	private JButton LoadButtonMAR;
	private JButton LoadButtonMBR;
	private JLabel RunLabel;
	private JLabel HaltLabel;
	private JButton[] bitArray = new JButton[16];
	private MemoryAddressRegister mar = new MemoryAddressRegister(0);
	private MemoryBufferRegister mbr = new MemoryBufferRegister(0);
	private MemoryFaultRegister mfr = new MemoryFaultRegister(0);
	private InstructionRegister ir = new InstructionRegister(0);
	private PCRegister pc = new PCRegister(0);
	private Memory memory = new Memory();
	private ConsoleLog console = new ConsoleLog();
	private ConsolePrinter consolePrinter = new ConsolePrinter();
	private Operations operations = new Operations(memory, console, consolePrinter);
	private GPRegister gpr0 = new GPRegister(0);
	private GPRegister gpr1 = new GPRegister(1);
	private GPRegister gpr2 = new GPRegister(2);
	private GPRegister gpr3 = new GPRegister(3);
	private ArrayList<GPRegister> gprList = new ArrayList<GPRegister>();
	private IndexRegister ixr0 = new IndexRegister(0);
	private IndexRegister ixr1 = new IndexRegister(1);
	private IndexRegister ixr2 = new IndexRegister(2);
	private IndexRegister ixr3 = new IndexRegister(3);
	private ArrayList<IndexRegister> ixrList = new ArrayList<IndexRegister>();
	private FPRegister fpr0 = new FPRegister(0);
	private FPRegister fpr1 = new FPRegister(1);
	private ArrayList<FPRegister> fprList = new ArrayList<FPRegister>();
	private ConditionCode cc0 = new ConditionCode(0);
	private ConditionCode cc1 = new ConditionCode(1);
	private ConditionCode cc2 = new ConditionCode(2);
	private ConditionCode cc3 = new ConditionCode(3);
	private ArrayList<ConditionCode> ccList = new ArrayList<ConditionCode>();
	StringBuilder fileContent = new StringBuilder();
	private ConvertHexToBinary H2B = new ConvertHexToBinary();
	private JButton ConsoleLogButton;
	private JRadioButton CC0;
	private JLabel ConditionCode0;
	private JLabel ConditionCode1;
	private JRadioButton CC1;
	private JLabel ConditionCode2;
	private JRadioButton CC2;
	private JLabel ConditionCode3;
	private JRadioButton CC3;
	private ArrayList<JRadioButton> ccbuttonList = new ArrayList<JRadioButton>();
	private JButton ConsolePrinterButton;
	private JLabel FPR0Label;
	private JTextField FPR0;
	private JButton LoadButtonFPR0;
	private JLabel FPR1Label;
	private JTextField FPR1;
	private JButton LoadButtonFPR1;
	private ArrayList<JTextField> FPRTextList = new ArrayList<JTextField>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StimulatorWindow window = new StimulatorWindow();
					window.CSCIProjectTeam7.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StimulatorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Frame title
		CSCIProjectTeam7 = new JFrame();
		CSCIProjectTeam7.getContentPane().setFont(new Font("Lucida Calligraphy", Font.PLAIN, 12));
		CSCIProjectTeam7.setBackground(new Color(105, 105, 105));
		CSCIProjectTeam7.setFont(new Font("Dialog", Font.BOLD, 12));
		CSCIProjectTeam7.setTitle("CSCI 6461 Project Team 7 Stimulator");
		console.setVisible(false);
		consolePrinter.setVisible(false);
		CSCIProjectTeam7.getContentPane().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		CSCIProjectTeam7.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		CSCIProjectTeam7.getContentPane().setBackground(new Color(105, 105, 105));
		
		JPanel OperationPanel = new JPanel();
		OperationPanel.setBackground(new Color(192, 192, 192));
		OperationPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		//Address panel has the switch bits to hold the memory address values
		AddressPanel = new JPanel();
		AddressPanel.setBackground(new Color(192, 192, 192));
		AddressPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		//GPR panel has the switch bits to access the respective GPRs
		GPRPanel = new JPanel();
		GPRPanel.setBackground(new Color(192, 192, 192));
		GPRPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		//IXR panel has the switch bits to access the respective IXRs
		IXRPanel = new JPanel();
		IXRPanel.setBackground(new Color(192, 192, 192));
		IXRPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		//The Direct Indirect Switch Bit is used to show direct/indirect addressing
		IPanel = new JPanel();
		IPanel.setBackground(new Color(192, 192, 192));
		IPanel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
	
		
		Address = new JLabel();
		Address.setFont(new Font("Calibri", Font.BOLD, 18));
		Address.setToolTipText("");
		Address.setText("Address");
		Address.setHorizontalAlignment(SwingConstants.CENTER);
		Address.setForeground(Color.BLACK);
		Address.setBackground(new Color(221, 160, 221));
		
		AddressBit04 = new JButton("4");
		AddressBit04.setBackground(Color.WHITE);
		AddressBit04.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[4]=AddressBit04;
		AddressBit04.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackgroundColourOnClick(AddressBit04);
			}
		});
		
		AddressBit03 = new JButton("3");
		AddressBit03.setBackground(Color.WHITE);
		AddressBit03.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[3]=AddressBit03;
		AddressBit03.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackgroundColourOnClick(AddressBit03);
			}
		});
		
		
		AddressBit02 = new JButton("2");
		AddressBit02.setBackground(Color.WHITE);
		AddressBit02.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[2]=AddressBit02;
		AddressBit02.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackgroundColourOnClick(AddressBit02);
			}
		});
		
		AddressBit01 = new JButton("1");
		AddressBit01.setBackground(Color.WHITE);
		AddressBit01.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[1]=AddressBit01;
		AddressBit01.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				setBackgroundColourOnClick(AddressBit01);
			}
		});
		
		AddressBit00 = new JButton("0");
		AddressBit00.setBackground(Color.WHITE);
		AddressBit00.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[0]=AddressBit00;
		AddressBit00.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(AddressBit00);
				
			}
		});
		//Adjusting the panel dimensions
		GroupLayout gl_AddressPanel = new GroupLayout(AddressPanel);
		gl_AddressPanel.setHorizontalGroup(
			gl_AddressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressPanel.createSequentialGroup()
					.addGap(131)
					.addComponent(Address, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
					.addGap(145))
				.addGroup(gl_AddressPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(AddressBit04, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit03, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit02, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit01, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(AddressBit00, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(4, Short.MAX_VALUE))
		);
		gl_AddressPanel.setVerticalGroup(
			gl_AddressPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressPanel.createSequentialGroup()
					.addComponent(Address, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AddressPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddressBit04)
						.addComponent(AddressBit03)
						.addComponent(AddressBit02)
						.addComponent(AddressBit01)
						.addComponent(AddressBit00))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		AddressPanel.setLayout(gl_AddressPanel);
		
		I = new JLabel();
		I.setFont(new Font("Calibri", Font.BOLD, 18));
		I.setToolTipText("");
		I.setText("I");
		I.setHorizontalAlignment(SwingConstants.CENTER);
		I.setForeground(Color.BLACK);
		I.setBackground(new Color(221, 160, 221));
		
		IBit05 = new JButton("5");
		IBit05.setBackground(Color.WHITE);
		IBit05.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[5]=IBit05;
		IBit05.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(IBit05);
			}
		});
		//Adjusting the panel dimensions
		GroupLayout gl_IPanel = new GroupLayout(IPanel);
		gl_IPanel.setHorizontalGroup(
			gl_IPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_IPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(I, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(IBit05, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
					.addGap(26))
		);
		gl_IPanel.setVerticalGroup(
			gl_IPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IPanel.createSequentialGroup()
					.addComponent(I, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IBit05)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		IPanel.setLayout(gl_IPanel);
		
		IXR = new JLabel();
		IXR.setFont(new Font("Calibri", Font.BOLD, 18));
		IXR.setToolTipText("");
		IXR.setText("IXR");
		IXR.setHorizontalAlignment(SwingConstants.CENTER);
		IXR.setForeground(Color.BLACK);
		IXR.setBackground(new Color(221, 160, 221));
		
		IXRBit07 = new JButton("7");
		IXRBit07.setBackground(Color.WHITE);
		IXRBit07.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[7]=IXRBit07;
		IXRBit07.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
					setBackgroundColourOnClick(IXRBit07);
			}
		});
		
		IXRBit06 = new JButton("6");
		IXRBit06.setBackground(Color.WHITE);
		IXRBit06.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[6]=IXRBit06;
		IXRBit06.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
					setBackgroundColourOnClick(IXRBit06);
			}
		});
		//Adjusting the panel dimensions
		GroupLayout gl_IXRPanel = new GroupLayout(IXRPanel);
		gl_IXRPanel.setHorizontalGroup(
			gl_IXRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IXRPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(IXR, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
					.addGap(23))
				.addGroup(gl_IXRPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(IXRBit07, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(IXRBit06, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_IXRPanel.setVerticalGroup(
			gl_IXRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_IXRPanel.createSequentialGroup()
					.addComponent(IXR, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_IXRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(IXRBit07)
						.addComponent(IXRBit06))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		IXRPanel.setLayout(gl_IXRPanel);
		
		GPRBit09 = new JButton("9");
		GPRBit09.setBackground(Color.WHITE);
		GPRBit09.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[9]=GPRBit09;
		GPRBit09.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(GPRBit09);
			}
		});;
		
		GPR = new JLabel();
		GPR.setFont(new Font("Calibri", Font.BOLD, 18));
		GPR.setToolTipText("");
		GPR.setText("GPR");
		GPR.setHorizontalAlignment(SwingConstants.CENTER);
		GPR.setForeground(Color.BLACK);
		GPR.setBackground(new Color(192, 192, 192));
		
		GPRBit08 = new JButton("8");
		GPRBit08.setBackground(Color.WHITE);
		GPRBit08.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[8]=GPRBit08;
		GPRBit08.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(GPRBit08);
			}
		});;
		//Adjusting the panel dimensions
		GroupLayout gl_GPRPanel = new GroupLayout(GPRPanel);
		gl_GPRPanel.setHorizontalGroup(
			gl_GPRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GPRPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(GPR, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addGap(39))
				.addGroup(gl_GPRPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(GPRBit09, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(GPRBit08, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		gl_GPRPanel.setVerticalGroup(
			gl_GPRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GPRPanel.createSequentialGroup()
					.addComponent(GPR, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_GPRPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(GPRBit09)
						.addComponent(GPRBit08))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		GPRPanel.setLayout(gl_GPRPanel);
		
		Operation = new JLabel();
		Operation.setFont(new Font("Calibri", Font.BOLD, 18));
		Operation.setForeground(new Color(0, 0, 0));
		Operation.setBackground(new Color(221, 160, 221));
		Operation.setHorizontalAlignment(SwingConstants.CENTER);
		Operation.setToolTipText("");
		Operation.setText("Operation");
		
		OperationBit15 = new JButton("15");
		OperationBit15.setBackground(Color.WHITE);
		OperationBit15.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[15]=OperationBit15;
		OperationBit15.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(OperationBit15);
			}
		});
		
		OperationBit14 = new JButton("14");
		OperationBit14.setBackground(Color.WHITE);
		OperationBit14.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[14]=OperationBit14;
		OperationBit14.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(OperationBit14);
			}
		});
		
		OperationBit13 = new JButton("13");
		OperationBit13.setBackground(Color.WHITE);
		OperationBit13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[13]=OperationBit13;
		OperationBit13.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(OperationBit13);
			}
		});
		
		OperationBit12 = new JButton("12");
		OperationBit12.setBackground(Color.WHITE);
		OperationBit12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[12]=OperationBit12;
		OperationBit12.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(OperationBit12);
			}
		});
		
		OperationBit11 = new JButton("11");
		OperationBit11.setBackground(Color.WHITE);
		OperationBit11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[11]=OperationBit11;
		OperationBit11.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(OperationBit11);
			}
		});
		
		OperationBit10 = new JButton("10");
		OperationBit10.setBackground(Color.WHITE);
		OperationBit10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bitArray[10]=OperationBit10;
		OperationBit10.addActionListener(new ActionListener() {
			//On click the color of the switch is changed to indicate change in status
			@Override
			public void actionPerformed(ActionEvent e) {
				
				setBackgroundColourOnClick(OperationBit10);
			}
		});
		//Adjusting the panel dimensions
		GroupLayout gl_OperationPanel = new GroupLayout(OperationPanel);
		gl_OperationPanel.setHorizontalGroup(
			gl_OperationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OperationPanel.createSequentialGroup()
					.addGroup(gl_OperationPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_OperationPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(OperationBit15, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit14, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit13, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit12, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit11, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OperationBit10, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_OperationPanel.createSequentialGroup()
							.addGap(162)
							.addComponent(Operation, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
							.addGap(170)))
					.addContainerGap())
		);
		gl_OperationPanel.setVerticalGroup(
			gl_OperationPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OperationPanel.createSequentialGroup()
					.addComponent(Operation, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_OperationPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(OperationBit15)
						.addComponent(OperationBit14)
						.addComponent(OperationBit13)
						.addComponent(OperationBit12)
						.addComponent(OperationBit11)
						.addComponent(OperationBit10))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		OperationPanel.setLayout(gl_OperationPanel);
		
		GPRIXRPanel = new JPanel();
		GPRIXRPanel.setBorder(null);
		GPRIXRPanel.setBackground(new Color(105, 105, 105));
		
		AddressRegisterPanel = new JPanel();
		AddressRegisterPanel.setBackground(new Color(105, 105, 105));
		
		//Adjusting the panel dimensions
		
		ButtonPanel = new JPanel();
		ButtonPanel.setToolTipText("MFR");
		ButtonPanel.setBackground(new Color(105, 105, 105));
		GroupLayout groupLayout = new GroupLayout(CSCIProjectTeam7.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(OperationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(GPRPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(GPRIXRPanel, GroupLayout.PREFERRED_SIZE, 606, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(ButtonPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(IXRPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(IPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(AddressPanel, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
						.addComponent(AddressRegisterPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(AddressRegisterPanel, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ButtonPanel, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addGap(14))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(GPRIXRPanel, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(GPRPanel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(IXRPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(AddressPanel, 0, 0, Short.MAX_VALUE)
						.addComponent(OperationPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(IPanel, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
					.addContainerGap())
		);
		//Store Button is used to store the value into the specified memory address
		StoreButton = new JButton("STORE");
		StoreButton.setFont(new Font("Calibri", Font.BOLD, 26));
		StoreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//On click the MAR and MBR value are fetched and the value is written into the specified address
				operations.store();
				MAR.setText(operations.getMAR().getBitValue());
				MFR.setText(operations.getMFR().getBitValue());
				resetBitValue();
			}
			});
		//Performs the Same action as Store but also increments the value of MAR by 1
		StorePlus = new JButton("S+");
		StorePlus.setFont(new Font("Calibri", Font.BOLD, 26));
		StorePlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//On click the MAR and MBR value are fetched and the value is written into the specified address and the MAR is auto incremented by 1
				operations.storePlus();
				MAR.setText(operations.getMAR().getBitValue());
				MFR.setText(operations.getMFR().getBitValue());
				resetBitValue();
			}
			});
		//Load button is used to fetch the data from memory
		LoadButton = new JButton("LOAD");
		LoadButton.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//On click the MAR value is fetched and the value present in the corresponding memory address is displayed
				operations.loadFromMemory();
				MBR.setText(operations.getMBR().getBitValue());
				resetBitValue();
			}
			});
		//Run button runs the set of instructions from the specified location given by the Program Counter until it hits a HALT instruction
		RunButton = new JButton("RUN");
		RunButton.setFont(new Font("Calibri", Font.BOLD, 26));
		RunButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//On click the PC value is fetched and the subsequent instructions are executed until a HALT instruction is encountered
				do {
					HaltLabel.setForeground(Color.BLACK);
					operations.singleStep();
					setAllValues();					
				}while(operations.getIr().getValue() != 0);
				//Once HALT is encountered the IR displays HALT code value and Halt Glows Green
				HaltLabel.setForeground(Color.GREEN);
				resetBitValue();
			}
			});
		//Single Step is used to execute the instructions step by step manually until a HALT instruction is encountered
		SingleStep = new JButton("SS");
		SingleStep.setFont(new Font("Calibri", Font.BOLD, 26));
		SingleStep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//On Click gets the PC value and executed the operation retrieved form that location
				//PC value is auto incremented after execution of one instruction
				HaltLabel.setForeground(Color.BLACK);
				operations.singleStep();
				if(operations.getIr().getValue() == 0) {
					HaltLabel.setForeground(Color.GREEN);
				}
				setAllValues();
				resetBitValue();
			}
			});
		
		//The init button or IPL is used to reset the memory and then load the instructions specified in the file onto the memory
		IPLButton = new JButton("IPL");
		IPLButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				///On click a pop-up window is displayed to choose a .txt file
				FileReader newPopUpScreen = new FileReader();
				fileContent = newPopUpScreen.fileText;
				try {
					newPopUpScreen.chooseFile();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				//The contents of the file is loaded onto the memory
				if (!(fileContent.toString().isEmpty()||fileContent.toString().equalsIgnoreCase("No File was Selected"))) {
					memory.clearMemory();
					resetBitValue();
					resetTextbox();
					operations.clearAll();
					String[] fileLines = newPopUpScreen.getCommands();
					for( int i = 0; i<fileLines.length;i++) {
						String[] command = fileLines[i].toUpperCase().split("\\s");
						memory.setValue(H2B.hexToBinary(command[0]).substring(4), H2B.hexToBinary(command[1]));
					}
							
				}
			}
		});
		IPLButton.setFont(new Font("Calibri", Font.BOLD, 26));
		
		RunLabel = new JLabel("RUN");
		RunLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		RunLabel.setForeground(Color.BLACK);
		
		HaltLabel = new JLabel("HALT");
		HaltLabel.setForeground(Color.BLACK);
		HaltLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		ConsoleLogButton = new JButton("Console Log");
		ConsoleLogButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				console.setVisible(true);
			}
		});
		ConsoleLogButton.setFont(new Font("Calibri", Font.BOLD, 26));
		
		ConsolePrinterButton = new JButton("Console Printer");
		ConsolePrinterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consolePrinter.setVisible(true);
			}
		});
		ConsolePrinterButton.setFont(new Font("Calibri", Font.BOLD, 26));
		GroupLayout gl_ButtonPanel = new GroupLayout(ButtonPanel);
		gl_ButtonPanel.setHorizontalGroup(
			gl_ButtonPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ButtonPanel.createSequentialGroup()
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addGap(28)
							.addComponent(StoreButton, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(StorePlus, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(ConsoleLogButton)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addComponent(LoadButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(RunButton, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addComponent(ConsolePrinterButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(7)
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addComponent(RunLabel)
							.addGap(26))
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addComponent(SingleStep, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(HaltLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(IPLButton, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_ButtonPanel.setVerticalGroup(
			gl_ButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPanel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(StoreButton, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
						.addComponent(StorePlus, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(RunButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(IPLButton, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(SingleStep, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(ConsoleLogButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ConsolePrinterButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_ButtonPanel.createSequentialGroup()
							.addGroup(gl_ButtonPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(RunLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(HaltLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
							.addGap(14))))
		);
		ButtonPanel.setLayout(gl_ButtonPanel);
		
		PC = new JTextField();
		PC.setFont(new Font("Tahoma", Font.PLAIN, 26));
		PC.setText("000000000000");
		PC.setEditable(false);
		PC.setColumns(10);
		PC.setBackground(SystemColor.menu);
		
		MAR = new JTextField();
		MAR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MAR.setText("000000000000");
		MAR.setEditable(false);
		MAR.setColumns(10);
		MAR.setBackground(SystemColor.menu);
		
		MBR = new JTextField();
		MBR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MBR.setText("0000000000000000");
		MBR.setEditable(false);
		MBR.setColumns(10);
		MBR.setBackground(SystemColor.menu);
		
		IR = new JTextField();
		IR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IR.setText("0000000000000000");
		IR.setEditable(false);
		IR.setColumns(10);
		IR.setBackground(SystemColor.menu);
		
		MFR = new JTextField();
		MFR.setFont(new Font("Tahoma", Font.PLAIN, 26));
		MFR.setText("0000");
		MFR.setEditable(false);
		MFR.setColumns(10);
		MFR.setBackground(SystemColor.menu);
		
		ProgramCounter = new JLabel("PC");
		ProgramCounter.setVerticalAlignment(SwingConstants.BOTTOM);
		ProgramCounter.setHorizontalAlignment(SwingConstants.CENTER);
		ProgramCounter.setFont(new Font("Calibri", Font.BOLD, 24));
		
		MemoryAddressRegister = new JLabel("MAR");
		MemoryAddressRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		MemoryAddressRegister.setHorizontalAlignment(SwingConstants.CENTER);
		MemoryAddressRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		MemoryBufferRegister = new JLabel("MBR");
		MemoryBufferRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		MemoryBufferRegister.setHorizontalAlignment(SwingConstants.CENTER);
		MemoryBufferRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		InstructionRegister = new JLabel("IR");
		InstructionRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		InstructionRegister.setHorizontalAlignment(SwingConstants.CENTER);
		InstructionRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		MemoryFaultRegister = new JLabel("MFR");
		MemoryFaultRegister.setToolTipText("");
		MemoryFaultRegister.setVerticalAlignment(SwingConstants.BOTTOM);
		MemoryFaultRegister.setHorizontalAlignment(SwingConstants.CENTER);
		MemoryFaultRegister.setFont(new Font("Calibri", Font.BOLD, 24));
		
		//The Program counter points to the address of the next instruction
		LoadButtonPC = new JButton("LD");
		LoadButtonPC.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonPC.setBackground(Color.LIGHT_GRAY);
		LoadButtonPC.addActionListener(new ActionListener() {
			//On click the PC is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				operations.setPc(pc);
				PC.setText(GetBitValue12());
				pc.setValue(GetBitValue12());
				resetBitValue();
			}
		});
		//The MAR holds the address of the memory location in which the operation or values are recorded
		LoadButtonMAR = new JButton("LD");
		LoadButtonMAR.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonMAR.setBackground(Color.LIGHT_GRAY);
		LoadButtonMAR.addActionListener(new ActionListener() {
			//On click the MAR is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MAR.setText(GetBitValue12());
				mar.setValue(GetBitValue12());
				operations.setMar(mar);
				resetBitValue();
			}
		});
		//The MBR is a buffer that hold values to and from the memory
		LoadButtonMBR = new JButton("LD");
		LoadButtonMBR.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonMBR.setBackground(Color.LIGHT_GRAY);
		LoadButtonMBR.addActionListener(new ActionListener() {
			//On click the MBR is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MBR.setText(GetBitValue16());
				mbr.setValue(GetBitValue16());
				operations.setMbr(mbr);
				resetBitValue();
			}
		});
		
		JLabel ConditionCode = new JLabel("CC");
		ConditionCode.setVerticalAlignment(SwingConstants.BOTTOM);
		ConditionCode.setHorizontalAlignment(SwingConstants.CENTER);
		ConditionCode.setFont(new Font("Calibri", Font.BOLD, 24));
		
		CC0 = new JRadioButton("");
		CC0.setHorizontalTextPosition(SwingConstants.CENTER);
		CC0.setHorizontalAlignment(SwingConstants.CENTER);
		CC0.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		ConditionCode0 = new JLabel("0");
		ConditionCode0.setVerticalAlignment(SwingConstants.TOP);
		ConditionCode0.setHorizontalTextPosition(SwingConstants.CENTER);
		ConditionCode0.setHorizontalAlignment(SwingConstants.CENTER);
		ConditionCode0.setFont(new Font("Calibri", Font.BOLD, 24));
		
		ConditionCode1 = new JLabel("1");
		ConditionCode1.setVerticalAlignment(SwingConstants.TOP);
		ConditionCode1.setHorizontalTextPosition(SwingConstants.CENTER);
		ConditionCode1.setHorizontalAlignment(SwingConstants.CENTER);
		ConditionCode1.setFont(new Font("Calibri", Font.BOLD, 24));
		
		CC1 = new JRadioButton("");
		CC1.setHorizontalTextPosition(SwingConstants.CENTER);
		CC1.setHorizontalAlignment(SwingConstants.CENTER);
		CC1.setAlignmentX(0.5f);
		
		ConditionCode2 = new JLabel("2");
		ConditionCode2.setVerticalAlignment(SwingConstants.TOP);
		ConditionCode2.setHorizontalTextPosition(SwingConstants.CENTER);
		ConditionCode2.setHorizontalAlignment(SwingConstants.CENTER);
		ConditionCode2.setFont(new Font("Calibri", Font.BOLD, 24));
		
		CC2 = new JRadioButton("");
		CC2.setHorizontalTextPosition(SwingConstants.CENTER);
		CC2.setHorizontalAlignment(SwingConstants.CENTER);
		CC2.setAlignmentX(0.5f);
		
		ConditionCode3 = new JLabel("3");
		ConditionCode3.setVerticalAlignment(SwingConstants.TOP);
		ConditionCode3.setHorizontalTextPosition(SwingConstants.CENTER);
		ConditionCode3.setHorizontalAlignment(SwingConstants.CENTER);
		ConditionCode3.setFont(new Font("Calibri", Font.BOLD, 24));
		
		CC3 = new JRadioButton("");
		CC3.setHorizontalTextPosition(SwingConstants.CENTER);
		CC3.setHorizontalAlignment(SwingConstants.CENTER);
		CC3.setAlignmentX(0.5f);
		ccbuttonList.add(CC0); ccbuttonList.add(CC1); ccbuttonList.add(CC2); ccbuttonList.add(CC3); 
		ccList.add(cc0); ccList.add(cc1); ccList.add(cc2); ccList.add(cc3); 
		GroupLayout gl_AddressRegisterPanel = new GroupLayout(AddressRegisterPanel);
		gl_AddressRegisterPanel.setHorizontalGroup(
			gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(MemoryAddressRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(MemoryBufferRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(InstructionRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(MemoryFaultRegister, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(ProgramCounter, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addComponent(ConditionCode, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(MFR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
						.addComponent(IR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(MAR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonMAR, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(PC, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonPC, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(MBR, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(LoadButtonMBR, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ConditionCode0, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CC0, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(ConditionCode1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CC1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(ConditionCode2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CC2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(ConditionCode3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CC3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_AddressRegisterPanel.setVerticalGroup(
			gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(ConditionCode, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(ConditionCode0, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(CC2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(CC0, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(ConditionCode1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(CC1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(ConditionCode2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(ConditionCode3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(CC3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
							.addComponent(LoadButtonPC, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(LoadButtonMAR, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(MemoryAddressRegister, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_AddressRegisterPanel.createSequentialGroup()
								.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(PC, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
									.addComponent(ProgramCounter, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(MAR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(MBR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(MemoryBufferRegister, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonMBR, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(IR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(InstructionRegister, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_AddressRegisterPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(MemoryFaultRegister, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(MFR, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		AddressRegisterPanel.setLayout(gl_AddressRegisterPanel);
		//Registers R0-R3
		GPR0 = new JTextField();
		GPR0.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR0.setText("0000000000000000");
		GPR0.setEditable(false);
		GPR0.setBackground(new Color(240, 240, 240));
		GPR0.setColumns(10);
		
		GPR1 = new JTextField();
		GPR1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR1.setText("0000000000000000");
		GPR1.setEditable(false);
		GPR1.setColumns(10);
		GPR1.setBackground(SystemColor.menu);
		
		GPR2 = new JTextField();
		GPR2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR2.setText("0000000000000000");
		GPR2.setEditable(false);
		GPR2.setColumns(10);
		GPR2.setBackground(SystemColor.menu);
		
		GPR3 = new JTextField();
		GPR3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		GPR3.setText("0000000000000000");
		GPR3.setEditable(false);
		GPR3.setColumns(10);
		GPR3.setBackground(SystemColor.menu);
		
		GPRTextList.add(GPR0); GPRTextList.add(GPR1); GPRTextList.add(GPR2); GPRTextList.add(GPR3);
		//Index Registers IX1-IX3
		IXR1 = new JTextField();
		IXR1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IXR1.setText("0000000000000000");
		IXR1.setEditable(false);
		IXR1.setColumns(10);
		IXR1.setBackground(SystemColor.menu);
		
		IXR2 = new JTextField();
		IXR2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IXR2.setText("0000000000000000");
		IXR2.setEditable(false);
		IXR2.setColumns(10);
		IXR2.setBackground(SystemColor.menu);
		
		IXR3 = new JTextField();
		IXR3.setFont(new Font("Tahoma", Font.PLAIN, 26));
		IXR3.setText("0000000000000000");
		IXR3.setEditable(false);
		IXR3.setColumns(10);
		IXR3.setBackground(SystemColor.menu);
		
		IXRTextList.add(IXR1); IXRTextList.add(IXR2); IXRTextList.add(IXR3);
		
		GPR0Label = new JLabel("GPR0");
		GPR0Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR0Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR0Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		GPR1Label = new JLabel("GPR1");
		GPR1Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR1Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR1Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		GPR2Label = new JLabel("GPR2");
		GPR2Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR2Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR2Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		GPR3Label = new JLabel("GPR3");
		GPR3Label.setVerticalAlignment(SwingConstants.BOTTOM);
		GPR3Label.setHorizontalAlignment(SwingConstants.CENTER);
		GPR3Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		IXR1Label = new JLabel("IXR1");
		IXR1Label.setVerticalAlignment(SwingConstants.BOTTOM);
		IXR1Label.setHorizontalAlignment(SwingConstants.CENTER);
		IXR1Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		IXR2Label = new JLabel("IXR2");
		IXR2Label.setVerticalAlignment(SwingConstants.BOTTOM);
		IXR2Label.setHorizontalAlignment(SwingConstants.CENTER);
		IXR2Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		IXR3Label = new JLabel("IXR3");
		IXR3Label.setVerticalAlignment(SwingConstants.BOTTOM);
		IXR3Label.setHorizontalAlignment(SwingConstants.CENTER);
		IXR3Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		LoadButtonGPR0 = new JButton("LD");
		LoadButtonGPR0.setBackground(new Color(192, 192, 192));
		LoadButtonGPR0.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR0.addActionListener(new ActionListener() {
			//On click the GPR0 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GPR0.setText(GetBitValue16());
				gpr0.setValue(GetBitValue16());
				operations.setGpr0(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonGPR1 = new JButton("LD");
		LoadButtonGPR1.setBackground(new Color(192, 192, 192));
		LoadButtonGPR1.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR1.addActionListener(new ActionListener() {
			//On click the GPR1 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GPR1.setText(GetBitValue16());
				gpr1.setValue(GetBitValue16());
				operations.setGpr1(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonGPR2 = new JButton("LD");
		LoadButtonGPR2.setBackground(new Color(192, 192, 192));
		LoadButtonGPR2.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR2.addActionListener(new ActionListener() {
			//On click the GPR2 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GPR2.setText(GetBitValue16());
				gpr2.setValue(GetBitValue16());
				operations.setGpr2(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonGPR3 = new JButton("LD");
		LoadButtonGPR3.setBackground(new Color(192, 192, 192));
		LoadButtonGPR3.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonGPR3.addActionListener(new ActionListener() {
			//On click the GPR3 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GPR3.setText(GetBitValue16());
				gpr3.setValue(GetBitValue16());
				operations.setGpr3(GetBitValue16());
				resetBitValue();
			}
		});
		
		LoadButtonIXR1 = new JButton("LD");
		LoadButtonIXR1.setBackground(new Color(192, 192, 192));
		LoadButtonIXR1.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonIXR1.addActionListener(new ActionListener() {
			//On click the IXR1 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				IXR1.setText(GetBitValue16());
				ixr1.setValue(GetBitValue16());
				operations.setIxr1(ixr1);
				resetBitValue();
			}
		});
		
		LoadButtonIXR2 = new JButton("LD");
		LoadButtonIXR2.setBackground(new Color(192, 192, 192));
		LoadButtonIXR2.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonIXR2.addActionListener(new ActionListener() {
			//On click the IXR2 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				IXR2.setText(GetBitValue16());
				ixr2.setValue(GetBitValue16());
				operations.setIxr2(ixr2);
				resetBitValue();
			}
		});
		
		LoadButtonIXR3 = new JButton("LD");
		LoadButtonIXR3.setBackground(new Color(192, 192, 192));
		LoadButtonIXR3.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonIXR3.addActionListener(new ActionListener() {
			//On click the IXR3 is loaded with the value sent in from the switches
			@Override
			public void actionPerformed(ActionEvent e) {
				
				IXR3.setText(GetBitValue16());
				ixr3.setValue(GetBitValue16());
				operations.setIxr3(ixr3);
				resetBitValue();
			}
		});
		
		FPR0Label = new JLabel("FPR0");
		FPR0Label.setVerticalAlignment(SwingConstants.BOTTOM);
		FPR0Label.setHorizontalAlignment(SwingConstants.CENTER);
		FPR0Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		FPR1Label = new JLabel("FPR1");
		FPR1Label.setVerticalAlignment(SwingConstants.BOTTOM);
		FPR1Label.setHorizontalAlignment(SwingConstants.CENTER);
		FPR1Label.setFont(new Font("Calibri", Font.BOLD, 24));
		
		FPR0 = new JTextField();
		FPR0.setText("0000000000000000");
		FPR0.setFont(new Font("Tahoma", Font.PLAIN, 26));
		FPR0.setEditable(false);
		FPR0.setColumns(10);
		FPR0.setBackground(SystemColor.menu);
		
		FPR1 = new JTextField();
		FPR1.setText("0000000000000000");
		FPR1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		FPR1.setEditable(false);
		FPR1.setColumns(10);
		FPR1.setBackground(SystemColor.menu);
		
		FPRTextList.add(FPR0); FPRTextList.add(FPR1);
		
		LoadButtonFPR0 = new JButton("LD");
		LoadButtonFPR0.addActionListener(new ActionListener() {
				//On click the FR0 is loaded with the value sent in from the switches
				@Override
				public void actionPerformed(ActionEvent e) {
					
					FPR0.setText(GetBitValue16());
					fpr0.setValue(GetBitValue16());
					operations.setFpr0(GetBitValue16());
					resetBitValue();
				}
			});
		LoadButtonFPR0.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonFPR0.setBackground(Color.LIGHT_GRAY);
		
		LoadButtonFPR1 = new JButton("LD");
		LoadButtonFPR1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FPR1.setText(GetBitValue16());
				fpr1.setValue(GetBitValue16());
				operations.setFpr1(GetBitValue16());
				resetBitValue();
			}
		});
		LoadButtonFPR1.setFont(new Font("Calibri", Font.BOLD, 26));
		LoadButtonFPR1.setBackground(Color.LIGHT_GRAY);
		
		
		GroupLayout gl_GPRIXRPanel = new GroupLayout(GPRIXRPanel);
		gl_GPRIXRPanel.setHorizontalGroup(
			gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_GPRIXRPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(FPR1Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(FPR1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(LoadButtonFPR1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addComponent(FPR0Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(FPR0, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(LoadButtonFPR0, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(IXR1Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(IXR2Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(IXR3Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(IXR3, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonIXR3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(IXR2, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonIXR2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(IXR1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonIXR1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(GPR1Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(GPR2Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(GPR3Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(GPR0Label, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(GPR0, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonGPR0, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(GPR3, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonGPR3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(GPR2, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonGPR2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_GPRIXRPanel.createSequentialGroup()
									.addComponent(GPR1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(LoadButtonGPR1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))))
					.addGap(18))
		);
		gl_GPRIXRPanel.setVerticalGroup(
			gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_GPRIXRPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(LoadButtonGPR0)
						.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(GPR0, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(GPR0Label, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GPR1Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(LoadButtonGPR1, 0, 0, Short.MAX_VALUE)
							.addComponent(GPR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GPR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(GPR2Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonGPR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(GPR3Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(GPR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonGPR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(IXR1Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_GPRIXRPanel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(LoadButtonIXR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(IXR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(IXR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR2Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoadButtonIXR2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(LoadButtonIXR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR3Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(IXR3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(FPR0, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(FPR0Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(LoadButtonFPR0, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_GPRIXRPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(FPR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(FPR1Label, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(LoadButtonFPR1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(424))
		);
		GPRIXRPanel.setLayout(gl_GPRIXRPanel);
		CSCIProjectTeam7.getContentPane().setLayout(groupLayout);
		CSCIProjectTeam7.setBounds(100, 100, 1316, 684);
		CSCIProjectTeam7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*
	 * This method is used to reset the values displayed in the GUI after IPL or Init is executed
	 */
	public void resetTextbox() {
		PC.setText("000000000000");
		MAR.setText("000000000000");
		MBR.setText("0000000000000000");
		MFR.setText("0000");
		IR.setText("0000000000000000");
		GPR0.setText("0000000000000000");
		GPR1.setText("0000000000000000");
		GPR2.setText("0000000000000000");
		GPR3.setText("0000000000000000");
		IXR1.setText("0000000000000000");
		IXR2.setText("0000000000000000");
		IXR3.setText("0000000000000000");
		FPR0.setText("0000000000000000");
		FPR1.setText("0000000000000000");
		for(int i = 0; i<ccbuttonList.size();i++) {
			ccbuttonList.get(i).setSelected(false);
			ccList.get(i).setValue(0);
		}
	}
/*
 * This method is used to change the Color of the switches when they are clicked to show the change in status
 */
	public void setBackgroundColourOnClick(JButton button){
		if(button.getBackground().equals(Color.WHITE)){
			button.setBackground(Color.PINK);
		}
		else {
			button.setBackground(Color.WHITE);
		}	
	}	
	/*
	 * This method is used to check the status of each switch and then fetch the 16 bit value from the corresponding state of each switch
	 */
	public String GetBitValue16() {
		String s = "";
		for (int i=bitArray.length-1;i>=0;i--) {
			if(bitArray[i].getBackground().equals(Color.PINK)) {
				s += 1; 
			}
			else
			{
				s += 0;
			}
		}
		return s;
	}
	/*
	 * This method is used to check the status of each switch and then fetch the 12 bit value from the corresponding state of each switch
	 */
	public String GetBitValue12() {
		String s = "";
		for (int i=11;i>=0;i--) {
			if(bitArray[i].getBackground().equals(Color.PINK)) {
				s += 1; 
			}
			else
			{
				s += 0;
			}
		}
		return s;
	}
	/*
	 * This method is used to reset the status of the switches after the click of a Load button
	 * This enables the switches to return to a default state and ready for use for the next set of instructions
	 */
	public void resetBitValue() {
		for (int i=bitArray.length-1;i>=0;i--) {
			bitArray[i].setBackground(Color.WHITE);
			}
	}
	
	public void setAllValues() {
		gprList = operations.getGPRList();
		ixrList = operations.getIXRList();
		fprList = operations.getFPRList();
		ccList = operations.getCCList();
		mar = operations.getMAR();
		mbr = operations.getMBR();
		mfr = operations.getMFR();
		ir = operations.getIr();
		pc = operations.getPc();
		for(int i=0; i<gprList.size(); i++) {
			GPRTextList.get(i).setText(gprList.get(i).getBitValue());
		}
		for(int i=1; i<ixrList.size(); i++) {
			IXRTextList.get(i-1).setText(ixrList.get(i).getBitValue());
		}
		for(int i=0; i<fprList.size(); i++) {
			FPRTextList.get(i).setText(fprList.get(i).getBitValue());
		}
		MAR.setText(mar.getBitValue());
		MBR.setText(mbr.getBitValue());
		MFR.setText(mfr.getBitValue());
		IR.setText(ir.getBitValue());
		PC.setText(pc.getBitValue());
		for(int i=0; i<ccList.size(); i++) {
			if(ccList.get(i).getValue() == 1) {
				ccbuttonList.get(i).setSelected(true);
			}
			else {
				ccbuttonList.get(i).setSelected(false);
			}
			
		}
		
	}
}
	
