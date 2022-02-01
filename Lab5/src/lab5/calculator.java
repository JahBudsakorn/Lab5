package lab5;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class calculator {

	protected Shell Calculator;
	private Text text;
	private Button btn8;
	private Button btn9;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn0;
	private Button btnadd;
	private Button btnsub;
	private Button btnmul;
	private Button btndiv;
	private Button btneq;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			calculator window = new calculator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		Calculator.open();
		Calculator.layout();
		while (!Calculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	public ArrayList<Character> arr = new ArrayList<Character>();
	public String str;
	public int opA, opB;
	public char operator;
	public int ans;
	public int pointer;
	public boolean eq = false;
	private Text text_ans;
	public void cal(char num) {
		if(eq == true) {
			arr.clear();
			text.setText("");
			text_ans.setText("");
			eq = false;
		}
		arr.add(num);
		text.append(Character.toString(num));
		System.out.println(arr);
	}
	
	public void summary() {
		str = arr.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");
		int pointer = str.indexOf(operator);
        int opA , opB;
        opA = Integer.valueOf(str.substring(0, pointer));
        opB = Integer.valueOf(str.substring(pointer + 1, str.length()));
        switch(operator){
        case '+' :
        	ans = opA + opB;
        	break;
        case '-' :
        	ans = opA - opB;
        	break;
        case '*' :
        	ans = opA * opB;
        	break;
        case '/' :
        	if(opB != 0) {
        		text_ans.append(String.valueOf((float)opA / (float)opB));
        	} else {
        		text_ans.append("Syntax Error");
        		
        	}
        	break;
        }
        if(operator != '/') {
        	text_ans.append(String.valueOf(ans));
        }
	}
	
	protected void createContents() {
		Calculator = new Shell();
		Calculator.setBackground(SWTResourceManager.getColor(216, 191, 216));
		Calculator.setSize(363, 390);
		Calculator.setText("Jah's Calculator");
		
		text = new Text(Calculator, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(255, 239, 213));
		text.setBounds(10, 10, 261, 44);
		
		text_ans = new Text(Calculator, SWT.BORDER);
		text_ans.setBackground(SWTResourceManager.getColor(255, 239, 213));
		text_ans.setForeground(SWTResourceManager.getColor(0, 0, 0));
		text_ans.setBounds(10, 60, 261, 44);
		
		btn0 = new Button(Calculator, SWT.NONE);
		btn0.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty()) {
					cal('0');
				}
			}
		});
		btn0.setText("0");
		btn0.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn0.setBounds(10, 284, 162, 50);
		
		btn1 = new Button(Calculator, SWT.NONE);
		btn1.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('1');
			}
		});
		btn1.setText("1");
		btn1.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn1.setBounds(10, 228, 50, 50);
		
		btn2 = new Button(Calculator, SWT.NONE);
		btn2.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('2');
			}
		});
		btn2.setText("2");
		btn2.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn2.setBounds(66, 228, 50, 50);
		
		btn3 = new Button(Calculator, SWT.NONE);
		btn3.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('3');
			}
		});
		btn3.setText("3");
		btn3.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn3.setBounds(122, 228, 50, 50);
		
		btn4 = new Button(Calculator, SWT.NONE);
		btn4.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('4');
			}
		});
		btn4.setText("4");
		btn4.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn4.setBounds(10, 172, 50, 50);
		
		btn5 = new Button(Calculator, SWT.NONE);
		btn5.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('5');
			}
		});
		btn5.setText("5");
		btn5.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn5.setBounds(66, 172, 50, 50);
		
		btn6 = new Button(Calculator, SWT.NONE);
		btn6.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('6');
			}
		});
		btn6.setText("6");
		btn6.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn6.setBounds(122, 172, 50, 50);
		
		Button btn7 = new Button(Calculator, SWT.NONE);
		btn7.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn7.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('7');
			}
		});
		btn7.setBounds(10, 116, 50, 50);
		btn7.setText("7");
		
		btn8 = new Button(Calculator, SWT.NONE);
		btn8.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('8');
			}
		});
		btn8.setText("8");
		btn8.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn8.setBounds(66, 116, 50, 50);
		
		btn9 = new Button(Calculator, SWT.NONE);
		btn9.setForeground(SWTResourceManager.getColor(0, 0, 139));
		btn9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cal('9');
			}
		});
		btn9.setText("9");
		btn9.setFont(SWTResourceManager.getFont("Calibri Light", 15, SWT.BOLD | SWT.ITALIC));
		btn9.setBounds(122, 116, 50, 50);
		
		btnadd = new Button(Calculator, SWT.NONE);
		btnadd.setForeground(SWTResourceManager.getColor(50, 205, 50));
		btnadd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('+');
					operator = '+' ;
				}
			}
		});
		btnadd.setText("+");
		btnadd.setFont(SWTResourceManager.getFont("Sitka Subheading", 16, SWT.BOLD | SWT.ITALIC));
		btnadd.setBounds(195, 116, 58, 50);
		
		btnsub = new Button(Calculator, SWT.NONE);
		btnsub.setForeground(SWTResourceManager.getColor(50, 205, 50));
		btnsub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('-');
					operator = '-' ;
				}
			}
		});
		btnsub.setText("-");
		btnsub.setFont(SWTResourceManager.getFont("Sitka Subheading", 16, SWT.BOLD | SWT.ITALIC));
		btnsub.setBounds(262, 116, 58, 50);
		
		btnmul = new Button(Calculator, SWT.NONE);
		btnmul.setForeground(SWTResourceManager.getColor(50, 205, 50));
		btnmul.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('*');
					operator = '*' ;
				}
			}
		});
		btnmul.setText("*");
		btnmul.setFont(SWTResourceManager.getFont("Sitka Subheading", 16, SWT.BOLD | SWT.ITALIC));
		btnmul.setBounds(195, 172, 58, 50);
		
		btndiv = new Button(Calculator, SWT.NONE);
		btndiv.setForeground(SWTResourceManager.getColor(50, 205, 50));
		btndiv.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					cal('/');
					operator = '/' ;
				}
			}
		});
		btndiv.setText("/");
		btndiv.setFont(SWTResourceManager.getFont("Sitka Subheading", 16, SWT.BOLD | SWT.ITALIC));
		btndiv.setBounds(262, 172, 58, 50);
		
		btneq = new Button(Calculator, SWT.NONE);
		btneq.setForeground(SWTResourceManager.getColor(139, 69, 19));
		btneq.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(!arr.isEmpty() && eq == false) {
					eq = true;
					summary();
				}
			}
		});
		btneq.setText("=");
		btneq.setFont(SWTResourceManager.getFont("Segoe UI Historic", 20, SWT.BOLD | SWT.ITALIC));
		btneq.setBounds(195, 228, 126, 106);
		

	}
}